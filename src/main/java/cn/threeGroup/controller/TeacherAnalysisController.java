package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.dao.ErrorTopicMapper;
import cn.threeGroup.dao.UserInfoMapper;
import cn.threeGroup.domain.*;
import cn.threeGroup.helpper.CheckParam;
import cn.threeGroup.model.*;
import cn.threeGroup.serivce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * @author Mzh
 * @date 2020-05-29 08:03
 * @description:
 * @version:
 */
@Controller
public class TeacherAnalysisController extends BaseController {
//老师分析
    @Autowired
    ErrorTopicMapper errorTopicMapper;
    @Autowired
    SubjectService subjectService;
    @Autowired
    SubjectPinService subjectPinService;
    @Autowired
    HistoryExamService historyExamService;
    @Autowired
    ErrorTopicService errorTopicService;
    @Autowired
    UserInfoService userInfoService;
    @RequestMapping("teacherAnalisis")
    @ResponseBody
    public ResultMsg teacherAnalisis(String examName){
        ResultMsg resultMsg=new ResultMsg();
        System.out.println(examName);
        //考试人总数
        int studentSum=historyExamService.selectAllStudent(examName);
        resultMsg.add("studentSum",studentSum);
        //选择题
        //查找所有题号
        List<ExamUtilsModel> historyExamList=subjectService.allExamInfo(examName);
        List<TeacherAnalysisSubjectModel> teacherAnalysisSubjectModelList=new ArrayList<>();
        List<TeacherAnalysisSubjectPinModel> teacherAnalysisSubjectPinModelList=new ArrayList<>();
        while (!historyExamList.isEmpty()){
            if (historyExamList.get(0).getSubjectCodeType()==1){
                //单选
                Subject subjectSingle=subjectService.selectByTopicId((long)historyExamList.get(0).getSubjectCode());
                String opt=subjectSingle.getSubjectOptions();
                //选项
                String[] opts=opt.split("\\@");
                List<String> stringList = Arrays.asList(opts);
                //答案
                String[] ans=subjectSingle.getSubjectAnswer().split("\\@");
                List<String> stringList1 = Arrays.asList(ans);
                //题号，和试卷，找出正确的人emial
                String[] peoples= errorTopicService.selectPeople(examName,subjectSingle.getId(),"1");
                System.out.println("-------------------单选"+peoples.length);
                List<String> stuNames=new ArrayList<>();
               for(int i=0;i<peoples.length;++i){
                    stuNames.add(userInfoService.selectStudentName(peoples[i]));
               }
                TeacherAnalysisSubjectModel teacherAnalysisSubjectModel=new TeacherAnalysisSubjectModel("1",
                        subjectSingle.getId(),subjectSingle.getSubjectCentent(),stringList,stringList1,stuNames,subjectSingle.getAnswerAnalysis());
                teacherAnalysisSubjectModelList.add(teacherAnalysisSubjectModel);
            }else if(historyExamList.get(0).getSubjectCodeType()==2){
                //多选
                Subject subjectSingle=subjectService.selectByTopicId((long)historyExamList.get(0).getSubjectCode());
                String opt=subjectSingle.getSubjectOptions();
                //选项
                String[] opts=opt.split("\\@");
                List<String> stringList = Arrays.asList(opts);
                //答案
                String[] ans=subjectSingle.getSubjectAnswer().split("\\@");
                List<String> stringList1 = Arrays.asList(ans);
                List<String> stuNames=new ArrayList<>();
                String[] peoples= errorTopicService.selectPeople(examName,subjectSingle.getId(),"1");
                for(int i=0;i<peoples.length;++i){
                    stuNames.add(userInfoService.selectStudentName(peoples[i]));
                }
                TeacherAnalysisSubjectModel teacherAnalysisSubjectModel=new TeacherAnalysisSubjectModel("2",
                        subjectSingle.getId(),subjectSingle.getSubjectCentent(),stringList,stringList1,stuNames,subjectSingle.getAnswerAnalysis());
                teacherAnalysisSubjectModelList.add(teacherAnalysisSubjectModel);
            }else if (historyExamList.get(0).getSubjectPinType()==1){
//填空
                SubjectPin subjectPinBlank=subjectPinService.selectById((long)historyExamList.get(0).getSubjectPinCode());
                List<String> stuNames=new ArrayList<>();

                    String[] peoples= errorTopicService.selectPeople(examName,subjectPinBlank.getPinId(),"2");
                    for(int i=0;i<peoples.length;++i){
                        stuNames.add(userInfoService.selectStudentName(peoples[i]));
                    }

                TeacherAnalysisSubjectPinModel teacherAnalysisSubjectPinModel=new TeacherAnalysisSubjectPinModel("1",subjectPinBlank.getPinId()
                ,subjectPinBlank.getPinName(),subjectPinBlank.getPinAnswer(),stuNames,subjectPinBlank.getPinAnly());
                        teacherAnalysisSubjectPinModelList.add(teacherAnalysisSubjectPinModel);
            }else if(historyExamList.get(0).getSubjectPinType()==2){
//答题
                SubjectPin subjectPinBlank=subjectPinService.selectById((long)historyExamList.get(0).getSubjectPinCode());
                List<String> stuNames=new ArrayList<>();
                    String[] peoples= errorTopicService.selectPeople(examName,subjectPinBlank.getPinId(),"2");
                    for(int i=0;i<peoples.length;++i){
                        stuNames.add(userInfoService.selectStudentName(peoples[i]));
                    }

                TeacherAnalysisSubjectPinModel teacherAnalysisSubjectPinModel=new TeacherAnalysisSubjectPinModel("2",subjectPinBlank.getPinId()
                        ,subjectPinBlank.getPinName(),subjectPinBlank.getPinAnswer(),stuNames,subjectPinBlank.getPinAnly());
                teacherAnalysisSubjectPinModelList.add(teacherAnalysisSubjectPinModel);
            }
            historyExamList.remove(0);
        }
        resultMsg.add("subject",teacherAnalysisSubjectModelList);
        resultMsg.add("subjectPin",teacherAnalysisSubjectPinModelList);
        resultMsg.setFlag(true);
        return resultMsg;
    }

    @ResponseBody
    @RequestMapping("errorStudentSearch")
    public ResultMsg errorStudentSearch(Long id,String type,String subjectType,String examName){

        ResultMsg resultMsg=new ResultMsg();
        //0是选择题
        if (subjectType.equals("1")){
            List<ErrorTopic> errorTopicList=errorTopicService.errorStudentSearch(examName,id,"1");
            String[] people1 = errorTopicService.selectPeople(examName, id, "1");
            if (errorTopicList.isEmpty()){
                resultMsg.setFlag(false);
            }else{
                List<String> stuNames=new ArrayList<>();
                for(int i=0;i<people1.length;++i){
                    stuNames.add(userInfoService.selectStudentName(people1[i]));
                }
                resultMsg.setFlag(true);
                resultMsg.add("errorPeople",errorTopicList);
                resultMsg.add("subjectPeople",stuNames);
            }

        }else{
            List<ErrorTopic> errorTopicList=errorTopicService.errorStudentSearch(examName,id,"2");
            String[] people2 = errorTopicService.selectPeople(examName, id, "2");
            if (errorTopicList.isEmpty()){
                resultMsg.setFlag(false);
            }else{
                List<String> stuNames=new ArrayList<>();
                for(int i=0;i<people2.length;++i){
                    stuNames.add(userInfoService.selectStudentName(people2[i]));
                }
                resultMsg.setFlag(true);
                resultMsg.add("errorPeople",errorTopicList);
                resultMsg.add("subjectPeople",stuNames);
            }

        }
        return resultMsg;
    }
}
