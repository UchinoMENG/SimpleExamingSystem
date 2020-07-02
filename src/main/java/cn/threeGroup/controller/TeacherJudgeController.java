package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.*;
import cn.threeGroup.model.ResultModal;
import cn.threeGroup.model.TeacherJudgeModel;
import cn.threeGroup.serivce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Mzh
 * @date 2020-05-28 15:24
 * @description:
 * @version:
 */
@Controller
public class TeacherJudgeController extends BaseController {
    @Autowired
    ErrorTopicService errorTopicService;
    @Autowired
    SubjectPinService subjectPinService;
    @Autowired
    ExamInfoService examInfoService;
    @Autowired
    ClassTableService classTableService;
    @Autowired
    HistoryExamService historyExamService;
    //显示错题
    @ResponseBody
    @RequestMapping(value = "/showTeacherQuestion",method = RequestMethod.GET ,produces = "text/html;charset=UTF-8")
    public String showTeacherQuestion(String examination_name){
        System.out.println("==================================");
        System.out.println("考试名字："+examination_name);

        ResultModal<List<TeacherJudgeModel>> res=new ResultModal<>();
        try{
//            CheckParam.checkTeacherJudge(token,testId,courseCode);
//            QuestionModel questionModel=new QuestionModel(2,"math","answer","answer_mine");
//            ArrayList<TecherJudgeModel> list=new ArrayList<>();
//            TecherJudgeModel examUserModel =new TecherJudgeModel(questionModel,"34","20171004009");
//            list.add(examUserModel);
            ExamInfo examInfo=new ExamInfo();
            examInfo.setExamName(examination_name);
            //得到年级，班级名
            List<ExamInfo> ExamInfoList=examInfoService.searchClassname(examInfo);
            for (int num=0;num<ExamInfoList.size();++num) {
                //得到学生email
                ClassTable classTable = new ClassTable();
                classTable.setGradeName(ExamInfoList.get(num).getGradeName());
                classTable.setClassName(ExamInfoList.get(num).getClassName());
                //找出所有人
                System.out.println(ExamInfoList.get(0).getClassName());
                List<ClassTable> classTableList = classTableService.getStudentEmail(classTable);
                //试卷，学生email得到题
                ErrorTopic errorTopic = new ErrorTopic();
                //循环学生
                List<TeacherJudgeModel> teacherJudgeModels = new ArrayList<>();
                byte a = 0;
                while (!classTableList.isEmpty()) {
                    System.out.println("班级");
                    errorTopic.setExaminationName(examination_name);
                    errorTopic.setStudentId(classTableList.get(0).getUserEmail());
                    //痛过学生，考试名查
                    List<ErrorTopic> errorTopicList = errorTopicService.selectTopic1(errorTopic, a);
                    if (errorTopicList.isEmpty()) {
                        classTableList.remove(0);
                        continue;
                    }
                    while (!errorTopicList.isEmpty()) {
                        System.out.println(errorTopicList.size());
                        Long topicId = errorTopicList.get(0).getTopicId();
                        //subject鸟查题目
                        SubjectPin subjectPin = subjectPinService.selectSubjectPin(topicId);
                        teacherJudgeModels.add(new TeacherJudgeModel(subjectPin.getPinName(), subjectPin.getPinType()
                                , subjectPin.getPinKnowledge(), subjectPin.getPinAnswer(),
                                errorTopicList.get(0).getPersonalAnswer(), subjectPin.getPinAnly(),
                                errorTopicList.get(0).getId(), errorTopicList.get(0).getStudentId()
                                , errorTopicList.get(0).getRightScore()));
                        errorTopicList.remove(0);
                    }
                    classTableList.remove(0);
                    break;
                }
                res.setData(teacherJudgeModels);
                if (teacherJudgeModels.size() > 0) {

                    res.setCode("000");
                    res.setMassage("还有未判的");
                    break;
                } else {
                    res.setCode("101");
                    res.setMassage("全判完了");
                }
            }
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res.setMassage(errorInfo);
            res.setCode("111");
            System.out.println(json(res));
        }finally {
            String json=json(res);
            System.out.println(json);
            return json(res);
        }
    }

    //打分
    @ResponseBody
    @RequestMapping(value = "/giveScore",method = RequestMethod.GET)
    public ResultMsg giveScore(HttpServletRequest rep, String stuId, String score) {
        System.out.println("=====================================================");
        System.out.println("rucan:" + stuId + score);
        for (Map.Entry e:rep.getParameterMap().entrySet()){
            System.out.println(e.getKey());
            System.out.println(e.getValue());
        }
        rep.getParameter("stuId");
        rep.getParameter("score");
        System.out.println("rucan1:" + rep.getParameterMap() + score);
        Long a=Long.valueOf(stuId);
        Float sc=Float.valueOf(score);
        List<ErrorTopic> errorTopicList=errorTopicService.selectTopic(a);
        int s=0;
        if(!errorTopicList.isEmpty()){
            ErrorTopic errorTopic= errorTopicList.get(0);
           errorTopic.setScore(sc);
            System.out.println(errorTopic);
            s=errorTopicService.updateScore1(errorTopic);
        }
        if (s > 0) {
            System.out.println("Score更新完成");
            return ResultMsg.success();
        } else {
            System.out.println("Score更新shibai");
            return ResultMsg.failed();
        }
    }

    @ResponseBody
    @RequestMapping(value = "/sumScore",method = RequestMethod.GET)
    public ResultMsg sumScore(String stuId, String exam) {
        System.out.println("=====================================================");
        System.out.println("判卷:" + stuId + exam);
        ErrorTopic errorTopic=new ErrorTopic();
        errorTopic.setStudentId(stuId);
        errorTopic.setExaminationName(exam);
        byte a=0;
        byte b=1;
        String m="1";
        String n="2";
        //查找这学生的选择题，判断题
        List<ErrorTopic> subjectList=errorTopicService.selectTopicSubject(errorTopic.getExaminationName(),errorTopic.getStudentId(),a,m);
        System.out.println("选择题"+subjectList.size());
        List<ErrorTopic> subjectPinList=errorTopicService.selectTopicSubjectPin(errorTopic.getExaminationName(),errorTopic.getStudentId(),a,n);
        System.out.println("主观题"+subjectPinList.size());
        int s=0;


//客观题
        while(!subjectList.isEmpty()){
            System.out.println("客观题");
            errorTopic= subjectList.get(0);
            if(errorTopic.getRightAnswer().equals(errorTopic.getPersonalAnswer())){
                errorTopic.setRightError(b);
                errorTopic.setScore(errorTopic.getRightScore());
                errorTopic.setSign(b);
                s= errorTopicService.updateScore(errorTopic);
            }else {
                Float x=Float .valueOf(0);
                errorTopic.setRightError(a);
                errorTopic.setScore(x);
                errorTopic.setSign(b);
                s= errorTopicService.updateScore(errorTopic);
            }
            subjectList.remove(0);
            //errorTopic.setScore(score);
            // System.out.println(errorTopic);
        }
        System.out.println(subjectPinList.size()+"所有提");
//主观题处分
        while(!subjectPinList.isEmpty()){
            System.out.println("主观题");
            errorTopic= subjectPinList.get(0);
            SubjectPin subjectPin=subjectPinService.selectSubjectPin(errorTopic.getTopicId());
           //填空
            System.out.println(subjectPin.getPinOption());
            if(subjectPin.getPinOption()==1){
                System.out.println("填空");
                if(errorTopic.getRightAnswer().equals(errorTopic.getPersonalAnswer())){
                    errorTopic.setRightError(b);
                    errorTopic.setScore(errorTopic.getRightScore());
                    errorTopic.setSign(b);
                    s= errorTopicService.updateScore(errorTopic);
                    System.out.println("1"+s);
                }else {
                    Float x=Float .valueOf(0);
                    errorTopic.setRightError(a);
                    errorTopic.setScore(x);
                    errorTopic.setSign(b);
                    s= errorTopicService.updateScore(errorTopic);
                    System.out.println("2"+s);
                }
                //大题
                errorTopic.setSign(b);
            }else{
                System.out.println("大题");
                System.out.println(subjectPin.getPinOption());
               boolean flag= Math.abs(errorTopic.getRightScore() - errorTopic.getScore()) < 0.000001;
                if(flag){
                    errorTopic.setRightError(a);
                    errorTopic.setSign(b);
                    System.out.println("same");
                }else {
                    errorTopic.setRightError(b);
                    errorTopic.setSign(b);
                }
                s= errorTopicService.updateScore(errorTopic);
                System.out.println("3"+s);
            }
            //errorTopic.setScore(score);
            // System.out.println(errorTopic);
            subjectPinList.remove(0);
        }
        double sum = 0;
        List<ErrorTopic> listAll=errorTopicService.selectAllTopic(errorTopic.getExaminationName(),errorTopic.getStudentId());
        for (ErrorTopic topic : listAll) {
            sum+= topic.getScore();

        }
        HistoryExam historyExam=new HistoryExam();
        historyExam.setStudentEmail(stuId);
        historyExam.setHistoryExam(exam);
        historyExam.setScore(sum);
        int i = historyExamService.updateScore(historyExam);
        if (s > 0&&i>0) {
            System.out.println("Score更新完成");
            return ResultMsg.success();
        } else {
            System.out.println("Score更新shibai");
            return ResultMsg.failed();
        }
    }
}
