package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.dao.SubjectMapper;
import cn.threeGroup.domain.*;
import cn.threeGroup.model.ExamUtilsModel;
import cn.threeGroup.model.SubExamModel;
import cn.threeGroup.model.TeacherBySelfModel2;
import cn.threeGroup.serivce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
public class ErrorTopicController extends BaseController {
    @Autowired
    private ErrorTopicService errorTopicService;
    @Autowired
    private ClassTableService classTableService;
    @Autowired
    private SubjectService subjectService;
    @Autowired
    private SubjectPinService subjectPinService;

    @Autowired
    private TeacherInfoService teacherInfoService;
    @ResponseBody
    @RequestMapping(value = "/initErrorTopic",method = RequestMethod.POST)
    public ResultMsg initErrorTopic( SubExamModel subExamModel,
                                    String examTime, String teacherEmail, String startTime,
                                    String gradeName, String className){
        ResultMsg res =null;
        //获取符合年级和班级的所有学生
        try{
            List<ClassTable> classTables = classTableService.allClassOfGrade(className, gradeName);
            //获取这个考试表中的所有的所有考题信息
            List<ExamUtilsModel> examUtilsModels = subjectService.allExamInfo(subExamModel.getRandom_title());
            //将这个年级这个班的所有学生全部导入error_topic表里
            for(int i = 0;i<classTables.size();i++){
                ClassTable classTable = classTables.get(i);
                //首先先将每个学生的考试信息都插入到courseinfo表中
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setUseremail(classTable.getUserEmail());
                courseInfo.setTeachername(teacherInfoService.getTeacherByEmail(teacherEmail).getUsername());

                System.out.println(json(classTable));
                for(int j = 0;j<examUtilsModels.size();j++){
                    ExamUtilsModel examUtilsModel = examUtilsModels.get(j);
                    System.out.println(json(examUtilsModel));
                    if(isSubject(examUtilsModel)){
                        //获取到这道题
                        Subject subject = subjectService.selectById((long) examUtilsModel.getSubjectCode()).get(0);
                        System.out.println(json(subject));
//                        ErrorTopic errorTopic = new ErrorTopic()
                        ErrorTopic errorTopic = new ErrorTopic(subject,classTable.getUserEmail(),
                                    teacherEmail,examUtilsModel,subExamModel.getRandom_title(),subExamModel.getSubject());
                        System.out.println(json(errorTopic));
                        errorTopicService.insertToErrorTopic(errorTopic);
                    }
                    else{
                        SubjectPin subjectPin = subjectPinService.selectSubjectPin((long) examUtilsModel.getSubjectPinCode());
                        System.out.println(json(subjectPin));
                        ErrorTopic errorTopic = new ErrorTopic(subjectPin,classTable.getUserEmail(),
                                teacherEmail,examUtilsModel,subExamModel.getRandom_title(),subExamModel.getSubject());
                        System.out.println(json(errorTopic));
                        errorTopicService.insertToErrorTopic(errorTopic);
                    }
                }
            }
            res = ResultMsg.success();
        }
        catch (Exception e){
            res = ResultMsg.failed();
            System.out.println(e.getMessage());
        }
        finally {
            return res;
        }

    }
    /**
     * @ClassName ErrorTopicController
     * @Description : 初始化ErrorTopic
     *
     * @param teacherBySelfModel2
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/7 14:27
    */

    @ResponseBody
    @RequestMapping(value = "/initErrorTopic2",method = RequestMethod.POST)
    public ResultMsg initErrorTopic2(TeacherBySelfModel2 teacherBySelfModel2){
        ResultMsg res =null;
        System.out.println(teacherBySelfModel2.getSubjectname());
        //获取符合年级和班级的所有学生
        try{
            List<ClassTable> classTables = classTableService.allClassOfGrade(teacherBySelfModel2.getBan(),
                    teacherBySelfModel2.getNian());
            //获取这个考试表中的所有的所有考题信息
            List<ExamUtilsModel> examUtilsModels = subjectService.allExamInfo(teacherBySelfModel2.getExamName());
            //将这个年级这个班的所有学生全部导入error_topic表里
            for(int i = 0;i<classTables.size();i++){
                ClassTable classTable = classTables.get(i);
                //首先先将每个学生的考试信息都插入到courseinfo表中
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setUseremail(classTable.getUserEmail());
                courseInfo.setTeachername(teacherInfoService.getTeacherByEmail(teacherBySelfModel2.getTeacher()).getUsername());

                System.out.println(json(classTable));
                for(int j = 0;j<examUtilsModels.size();j++){
                    ExamUtilsModel examUtilsModel = examUtilsModels.get(j);
                    System.out.println(json(examUtilsModel));
                    if(isSubject(examUtilsModel)){
                        //获取到这道题
                        Subject subject = subjectService.selectById((long) examUtilsModel.getSubjectCode()).get(0);
                        System.out.println(json(subject));
//                        ErrorTopic errorTopic = new ErrorTopic()
                        ErrorTopic errorTopic = new ErrorTopic(subject,classTable.getUserEmail(),
                                teacherBySelfModel2.getTeacher(),examUtilsModel,teacherBySelfModel2.getExamName(),teacherBySelfModel2.getSubjectname());
                        System.out.println(json(errorTopic));
                        errorTopicService.insertToErrorTopic(errorTopic);
                    }
                    else{
                        SubjectPin subjectPin = subjectPinService.selectSubjectPin((long) examUtilsModel.getSubjectPinCode());
                        System.out.println(json(subjectPin));
                        ErrorTopic errorTopic = new ErrorTopic(subjectPin,classTable.getUserEmail(),
                                teacherBySelfModel2.getTeacher(),examUtilsModel,teacherBySelfModel2.getExamName(),teacherBySelfModel2.getSubjectname());
                        System.out.println(json(errorTopic));
                        errorTopicService.insertToErrorTopic(errorTopic);
                    }
                }
            }
            res = ResultMsg.success();
        }
        catch (Exception e){
            res = ResultMsg.failed();
            System.out.println(e.getMessage());
        }
        finally {
            return res;
        }

    }

    //判断这个题是否是选择题类型还是简答题类型
    public boolean isSubject(ExamUtilsModel examUtilsModel){
        return examUtilsModel.getSubjectPinCode()==0;
    }
    public ErrorTopic addErrorTopicByExamUtilsModel(ExamUtilsModel examUtilsModel){
        if(isSubject(examUtilsModel)){
            Subject subject = subjectService.selectById((long) examUtilsModel.getSubjectCode()).get(0);
            ErrorTopic errorTopic = new ErrorTopic();
            errorTopic.setAnlysis(subject.getAnswerAnalysis());
        }
        return null;
    }
}
