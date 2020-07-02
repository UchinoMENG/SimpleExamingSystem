package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.ErrorTopic;
import cn.threeGroup.helpper.CheckParam;
import cn.threeGroup.model.*;
import cn.threeGroup.serivce.ErrorTopicService;
import cn.threeGroup.serivce.HistoryExamService;
import cn.threeGroup.serivce.SubjectPinService;
import cn.threeGroup.serivce.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class StudentErrorController extends BaseController{
    @Autowired
    private HistoryExamService historyExamService;

    @Autowired
    private ErrorTopicService errorTopicService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectPinService subjectPinService;

    @RequestMapping(value = "/studentError",method = GET)
    public String studentError(String token ,int testId,int courseCode){
        System.out.println("身份："+token+"考试场数："+testId+"科目："+courseCode+"分数：");
        ResultModal<ArrayList<Object>> resultModal=new ResultModal<>();
        try{
            CheckParam.checkStudntError(token ,testId,courseCode);
            ArrayList<String> arrSingle=new ArrayList<>();
            arrSingle.add("选项A");
            arrSingle.add("选项B");
            arrSingle.add("选项C");
            arrSingle.add("选项D");
            StudentErrorSelectModel singleSelect=new StudentErrorSelectModel("1","1","1",arrSingle,"q","q","q");
            ArrayList<String> arrMutiple=new ArrayList<>();
            arrMutiple.add("选项A");
            arrMutiple.add("选项B");
            arrMutiple.add("选项C");
            arrMutiple.add("选项D");
            StudentErrorSelectModel mutipleSelect=new StudentErrorSelectModel("1","1","1",arrMutiple,"q","q","q");
            StudentErrorBlanksModel blanksModel=new StudentErrorBlanksModel("1","1","1",12,"q","q","q");
            StudentErrorObjectModel objectModel=new StudentErrorObjectModel("1","1","1","q","q","q");
            ArrayList<Object> list=new ArrayList<>();
            list.add(singleSelect);
            list.add(mutipleSelect);
            list.add(blanksModel);
            list.add(objectModel);
            resultModal.setData(list);
        }catch(Exception e){
            String errorInfo=e.getMessage();
            resultModal.setMassage(errorInfo);
            resultModal.setCode("111");
        }finally {
            String json=json(resultModal);
            System.out.println("出参"+json);
            return json;
        }
    }
    /**
     * @ClassName StudentErrorController
     * @Description : 返回考生的做题情况
     *
     * @param useremail
     * @param examname
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/4 17:46
     */

    @ResponseBody
    @RequestMapping(value = "/lookSelfExam",method = RequestMethod.POST)
    public ResultMsg useremailSelfExam(String useremail,String examname){
        System.out.println("useremai = "+useremail);
        System.out.println("examname = "+examname);
        ResultMsg res = null;
        try{
            double score= historyExamService.getScoreByUseremailAndExam(useremail, examname);
            List<TiModel> dan = new ArrayList<>();
            List<TiModel> duo = new ArrayList<>();
            List<TiModel> tian = new ArrayList<>();
            List<TiModel> zhu = new ArrayList<>();
            List<ErrorTopic> byUseremailAndExam = errorTopicService.findByUseremailAndExam(useremail, examname);
            for (ErrorTopic errorTopic : byUseremailAndExam) {
                //选择题
                if(errorTopic.getTopicType().equals("1")){
                    //单选题
                    if(subjectService.selectById(errorTopic.getTopicId()).get(0).getCourseTypeCode().equals("1")){
                        dan.add(new TiModel(errorTopic,subjectService.selectById(errorTopic.getTopicId()).get(0)) );
                        //danjie.add(subjectService.selectById(errorTopic.getTopicId()).get(0).getSubjectOptions());
                    }
                    else{
                        duo.add(new TiModel(errorTopic,subjectService.selectById(errorTopic.getTopicId()).get(0)));
                    }
                }
                else{
                    //非选择题
                    if(subjectPinService.selectSubjectPin(errorTopic.getTopicId()).getPinOption()==1){
                        tian.add(new TiModel(errorTopic,subjectPinService.selectById(errorTopic.getTopicId())));
                    }
                    else {
                        zhu.add(new TiModel(errorTopic,subjectPinService.selectById(errorTopic.getTopicId())));
                    }
                }
            }
            StudentSelfExamModel studentSelfExamModel = new StudentSelfExamModel((float) score,dan,duo,tian,zhu);
            res = ResultMsg.success();
            res.add("obj",studentSelfExamModel);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            res = ResultMsg.failed();
        }
        finally {
            System.out.println(json(res));
            return res;
        }

    }

}
