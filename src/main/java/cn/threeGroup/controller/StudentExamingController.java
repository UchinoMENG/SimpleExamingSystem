package cn.threeGroup.controller;


import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.ErrorTopic;
import cn.threeGroup.domain.ExamInfo;
import cn.threeGroup.domain.Subject;
import cn.threeGroup.domain.SubjectPin;
import cn.threeGroup.model.ExamCommonModel;
import cn.threeGroup.model.ExamContentModel;
import cn.threeGroup.model.ExamUtilsModel;
import cn.threeGroup.serivce.ErrorTopicService;
import cn.threeGroup.serivce.ExamInfoService;
import cn.threeGroup.serivce.SubjectPinService;
import cn.threeGroup.serivce.SubjectService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class StudentExamingController extends BaseController {
    @Autowired
    private ErrorTopicService errorTopicService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectPinService subjectPinService;
    @Autowired
    private ExamInfoService examInfoService;
    @ResponseBody
    @RequestMapping(value = "/examing",method = RequestMethod.GET)
    public ResultMsg studentExaming(String examname){
        System.out.println("examname = "+examname);
        ResultMsg resultMsg = null;
        try{
            List<ExamUtilsModel> examUtilsModels = subjectService.allExamInfo(examname);
            List<ExamContentModel> dan = new ArrayList<>();
            List<ExamContentModel> duo = new ArrayList<>();
            List<ExamContentModel> tian = new ArrayList<>();
            List<ExamContentModel> zhu = new ArrayList<>();
            for(int i = 0;i<examUtilsModels.size();i++){

                //第i行
                ExamUtilsModel examUtilsModel = examUtilsModels.get(i);
                //表示为subject
                if(examUtilsModel.getSubjectCode()!=0){
                    Subject subject = subjectService.selectById((long) examUtilsModel.getSubjectCode()).get(0);
                    ExamContentModel examCommonModel = new ExamContentModel(
                            subject.getSubjectName(),
                            subject.getSubjectOptions(),true);
                    if(examUtilsModel.getSubjectCodeType()==1){
                        //单选
                        dan.add(examCommonModel);
                    }
                    else{
                        duo.add(examCommonModel);
                    }
                }
                else{
                    //表示为subjectpin
                    SubjectPin subjectPin = subjectPinService.selectById((long) examUtilsModel.getSubjectPinCode());
                    ExamContentModel examContentModel = new ExamContentModel(
                            subjectPin.getPinName(),"",
                            false
                    );
                    //填空
                    if(examUtilsModel.getSubjectPinType()==1){
                       tian.add(examContentModel);
                    }
                    else{
                        zhu.add(examContentModel);
                    }
                }
            }
            resultMsg = ResultMsg.success();
            resultMsg.add("dan",dan).add("duo",duo).add("tian",tian).add("zhu",zhu);
            System.out.println("考卷的信息"+json(resultMsg));
        }
        catch (Exception e){
            resultMsg = ResultMsg.failed();
            System.out.println(e.getMessage());
        }
        finally {
            return resultMsg;
        }
    }

    /**
     * @ClassName StudentExamingController
     * @Description : 根据考试名称获取考试相关的信息
     *
     * @param examname
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 6:11
    */

    @ResponseBody
    @RequestMapping(value = "/examtime",method = RequestMethod.GET)
    public ResultMsg examingTime(String examname){
        System.out.println("examname = " + examname);
        ResultMsg res= null;
        try{
            ExamInfo examInfo = examInfoService.searchExaminfoByExamName(examname);
            res = ResultMsg.success();
            res.add("obj",examInfo);
        }catch (Exception e){
            System.out.println(e.getMessage());
            res = ResultMsg.failed();
        }
        finally {
            return res;
        }
    }
    /**
     * @ClassName StudentExamingController
     * @Description : 将学生提交上来的答案弄到error_topic上
     *
     * @param request
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 10:12
    */

    @ResponseBody
    @RequestMapping(value = "/submitexam",method = RequestMethod.POST)
    public ResultMsg submitStudentExam(HttpServletRequest request){
        ResultMsg res = null;
        //获取考试名
        String examName = request.getParameter("examname");
        String useremail = request.getParameter("useremail");
        //存储多选题的答案的map,Integer代表题号，List代表学生自己写的答案
        Map<Integer,List<Character>> duoMap = new HashMap<>();
        try{
            Map<String, String[]> parameterMap = request.getParameterMap();
            for (String s : parameterMap.keySet()) {
                if(s.equals("useremail")||s.equals("examname")){
                    continue;
                }
                //单选题的题目和学生答案
                if(s.indexOf("dan")!=-1){
                    //获取题目的题号
                    int num = Integer.parseInt(s.substring(3,s.length()));
                    //获取学生的个人答案
                    String personalAnswer = request.getParameter(s);
                    //根据题号获取题目的id
                    ExamUtilsModel examUtilsModel = subjectService.selectByExamNameAndId(examName, num);
                    //根据题号和email将学生答案插入到error_topic上
                    int sign = errorTopicService.updateErrorByPersonalAnswer(useremail, examUtilsModel.getSubjectCode(),
                            "1", personalAnswer,examName);
                    if(sign!=0){
                        System.out.println("学生单选题个人答案更新成功");
                    }
                }
                else if(s.indexOf("tian")!=-1){
                    //填空题的题目和答案
                    //获取题目的题号
                    int num = Integer.parseInt(s.substring(4,s.length()));
                    //获取学生的个人答案
                    String personalAnswer = request.getParameter(s);
                    //根据题号获取题目的id
                    ExamUtilsModel examUtilsModel = subjectService.selectByExamNameAndId(examName, num);
                    int sign = errorTopicService.updateErrorByPersonalAnswer(useremail, examUtilsModel.getSubjectPinCode(),
                            "2", personalAnswer,examName);
                    if(sign!=0){
                        System.out.println("学生填空题个人答案更新成功");
                    }
                }
                else if(s.indexOf("zhu")!=-1) {
                    //主观题的题目和答案
                    //获取题目的题号
                    int num = Integer.parseInt(s.substring(3, s.length()));
                    //获取学生的个人答案
                    String personalAnswer = request.getParameter(s);
                    //根据题号获取题目的id
                    ExamUtilsModel examUtilsModel = subjectService.selectByExamNameAndId(examName, num);
                    int sign = errorTopicService.updateErrorByPersonalAnswer(useremail, examUtilsModel.getSubjectPinCode(),
                            "2", personalAnswer,examName);
                    if (sign != 0) {
                        System.out.println("主观题学生个人答案更新成功");
                    }
                }
                else{
                    //多选题的题目和答案
                    int num = Integer.parseInt(s.substring(3, s.length()-1));
                    Character answer = s.charAt(s.length()-1);
                    if(duoMap.get(num)==null){
                        List<Character> init = new ArrayList<>();
                        duoMap.put(num,init);
                    }
                    duoMap.get(num).add(answer);
                }
            }
            //多选题操作
            //根据题号更新学生的答案;
            for(Integer s:duoMap.keySet()){
                ExamUtilsModel examUtilsModel = subjectService.selectByExamNameAndId(examName, s);
                List<Character> characters = duoMap.get(s);
                //记录学生多选题的答案
                StringBuilder personalAnswer = new StringBuilder();
                for (Character character : characters) {
                    personalAnswer.append(character).append("@");
                }
                int sign = errorTopicService.updateErrorByPersonalAnswer(useremail, examUtilsModel.getSubjectCode(),
                        "1", personalAnswer.toString(),examName);
                if(sign!=0){
                    System.out.println("多选题学生个人答案更新成功");
                }
            }
            res = ResultMsg.success();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            res = ResultMsg.failed();
        }
        finally {
            return res;
        }
    }
}
