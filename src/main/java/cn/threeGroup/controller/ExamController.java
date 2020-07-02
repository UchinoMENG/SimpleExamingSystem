package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.*;
import cn.threeGroup.model.ExamCommonModel;
import cn.threeGroup.model.SubExamModel;
import cn.threeGroup.model.TeacherExamBySelf;
import cn.threeGroup.serivce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class ExamController extends BaseController {

    @Autowired
    private SubjectService subjectService;
    //创建一个考试表的controller
    @Autowired
    private SubjectPinService subjectPinService;
    @Autowired
    private ExamInfoService examInfoService;
    @Autowired
    private ClassTableService classTableService;
    @Autowired
    private  CourseInfoService courseInfoService;
    @Autowired
    private TeacherInfoService teacherInfoService;
    @Autowired
    private HistoryExamService historyExamService;

    @Autowired
    private ErrorTopicService errorTopicService;


    /**
     * @ClassName ExamController
     * @Description : 自动判题
     *
     * @param examName
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 5:46
    */

    @ResponseBody
    @RequestMapping(value = "/autoJudeg",method = RequestMethod.POST)
    public ResultMsg autoJuage(String examName,String useremail){
        System.out.println("exam = "+examName);
        System.out.println("useremail = "+useremail);
        ResultMsg res = null;
        try{
            //单选题和多选题
            List<ErrorTopic> errorTopics = errorTopicService.selectByAutoExam(examName, (byte) 0, "1",useremail);
            for(int i = 0;i<errorTopics.size();i++){
                ErrorTopic errorTopic = errorTopics.get(i);
                errorTopic.setSign((byte)1);
                if(errorTopic.getRightAnswer().equals(errorTopic.getPersonalAnswer())){
                    errorTopic.setScore(errorTopic.getRightScore());
                    errorTopic.setRightError((byte) 1);
                }
                errorTopicService.updateErrorTopic(errorTopic);
            }
            List<ErrorTopic> errorTopics1 = errorTopicService.selectByAutoExam(examName, (byte) 0, "2", useremail);
            for (ErrorTopic errorTopic : errorTopics1) {
                //说明这是填空题
                if(subjectPinService.selectById(errorTopic.getTopicId()).getPinOption()==1){
                    errorTopic.setSign((byte)1);
                    if(errorTopic.getRightAnswer().equals(errorTopic.getPersonalAnswer())){
                        errorTopic.setScore(errorTopic.getRightScore());
                        errorTopic.setRightError((byte) 1);
                    }
                    errorTopicService.updateErrorTopic(errorTopic);
                }
            }

            res = ResultMsg.success();
        }catch (Exception e){
            res = ResultMsg.failed();
        }
        finally {
            System.out.println();
            return res;
        }
    }

    @ResponseBody
    @RequestMapping(value = "/subexaminfo",method = RequestMethod.POST)
    public ResultMsg subExamInfo(ExamInfo examInfo){
        System.out.println(json(examInfo));
        System.out.println("正在执行插入操作");
        int i = examInfoService.insertExamInfo(examInfo);
        System.out.println("执行操作结束");
        if(i!=0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
    //找出所有的符合gradeName,className的所有学生，然后将这些学生全部插入到这个HistoryExam中，默认成绩0
    //并且将这门考试加到courseinfo中去
    public List<HistoryExam> updateHistoryExam(String gradeName,String className,String examName){
        List<ClassTable> classTables = classTableService.allClassOfGrade(className, gradeName);
        List<HistoryExam> historyExams = new ArrayList<>();
        try{
            for(int i=0;i<classTables.size();i++){
                ClassTable classTable = classTables.get(i);
                CourseInfo courseInfo = new CourseInfo();
                courseInfo.setUseremail(classTable.getUserEmail());
                courseInfo.setCoursename(examName);
                String s = examInfoService.searchTeacherEmailByExamName(examName);
                String username = teacherInfoService.getTeacherByEmail(s).getUsername();
                courseInfo.setTeachername(username);
                courseInfo.setTesttime(" ");
                courseInfoService.addCourseInfo(courseInfo);
                HistoryExam historyExam = new HistoryExam(classTables.get(i),examName);
                int i1 = historyExamService.insertHistoryExam(historyExam);
                if(i1==0){
                    System.out.println("插入失败");
                }
                else{
                    System.out.println(json(historyExam));
                    System.out.println("插入成功");
                }
                historyExams.add(historyExam);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return historyExams;
    }
    @ResponseBody
    @RequestMapping(value = "/subexam" ,method = RequestMethod.POST)
    public ResultMsg subExam(SubExamModel subExamModel,
                             String examTime,String teacherEmail,String startTime,
                             String gradeName,String className){
        System.out.println(json(subExamModel));
        //首先看看这个考试是否有人创建过,没有的话则创建这个考试表
        int cnt = subjectService.existsExamTable(subExamModel.getRandom_title());
        if(cnt==1){
            return ResultMsg.failed();
        }
        SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
        Calendar calendar = Calendar.getInstance();
        //这里对examinfo表进行操作
        try{
            Date st = sdf.parse(startTime);
            calendar.setTime(st);
            calendar.add(Calendar.MINUTE,Integer.parseInt(examTime));
            Date ed = calendar.getTime();
            ExamInfo examInfo = new ExamInfo();
            examInfo.setClassName(className);
            examInfo.setGradeName(gradeName);
            examInfo.setTeacherEmail(teacherEmail);
            examInfo.setStartTime(st);
            examInfo.setExamTime(ed);
            examInfo.setExamName(subExamModel.getRandom_title());
            examInfoService.insertExamInfo(examInfo);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        //这里对history_exam表进行填充
        updateHistoryExam(gradeName,className,subExamModel.getRandom_title());

        //以下是创建表

        subjectService.createDyTable(subExamModel.getRandom_title());
        List<Subject> res1 = new LinkedList<>();
        List<SubjectPin> res2 = new LinkedList<>();
        //以下是随机选题并且加入到刚刚创建的这个表中
        //随机加入单选题的困难类型
        try{
            addListId(res1,allDanDifficultSubject(subExamModel),subExamModel.getRandomDanDifficultNum());

            addListId(res1,allDanMiddleSubject(subExamModel),subExamModel.getRandomDanMiddleNum());

            addListId(res1,allDanSimpleSubject(subExamModel),subExamModel.getRandomDanSimpleNum());

            addListId(res1,allDuoDifficultSubject(subExamModel),subExamModel.getRandomDuoDifficultNum());

            addListId(res1,allDuoMiddleSubject(subExamModel),subExamModel.getRandomDuoMiddleNum());

            addListId(res1 ,allDuoSimpleSubject(subExamModel),subExamModel.getRandomDuoSimpleNum());

            //随机加入多选题的类型题目

            addListIdPin(res2,allTianDifficultSubject(subExamModel),subExamModel.getRandomTianDifficultNum());

            addListIdPin(res2,allTianMiddleSubject(subExamModel),subExamModel.getRandomTianMiddleNum());

            addListIdPin(res2,allTianSimpleSubject(subExamModel),subExamModel.getRandomTianSimpleNum());

            addListIdPin(res2,allZhuDifficultSubject(subExamModel),subExamModel.getRandomZhuDifficultNum());

            addListIdPin(res2,allZhuMiddleSubject(subExamModel),subExamModel.getRandomZhuMiddleNum());

            addListIdPin(res2,allZhuSimpleSubject(subExamModel),subExamModel.getRandomZhuSimpleNum());
            subjectInsertToExam(res1,subExamModel,subExamModel.getRandom_title());
            subjectPinInsertToExam(res2,subExamModel,subExamModel.getRandom_title());
        }
        catch (Exception e){

            System.out.println(e.getMessage());
        }
        finally {
            return ResultMsg.success();
        }

    }

    /**
     * @ClassName ExamController
     * @Description : 老师手动出题
     *
     * @param teacherExamBySelf
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/6 17:28
     */

    @ResponseBody
    @RequestMapping(value = "/subExamByteacher",method = RequestMethod.POST)
    public ResultMsg subExamByteacher(@RequestBody TeacherExamBySelf teacherExamBySelf){
        ResultMsg res = null;
        try{
            //考试名
            String examname =  teacherExamBySelf.getExamName();
            int cnt = subjectService.existsExamTable(examname);
            if(cnt==1){
                res = ResultMsg.failed();
                res.setMsg("这个考试名已经存在了");
                return res;
            }
            SimpleDateFormat sdf =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
            Calendar calendar = Calendar.getInstance();
            Date st = sdf.parse(teacherExamBySelf.getStarttime());
            calendar.setTime(st);
            calendar.add(Calendar.MINUTE,Integer.parseInt(teacherExamBySelf.getTime()));
            //获取结束时间
            Date ed = calendar.getTime();
            //将这些信息插入到Examinfo表中
            ExamInfo examInfo = new ExamInfo();
            examInfo.setClassName(teacherExamBySelf.getBan());
            examInfo.setGradeName(teacherExamBySelf.getNian());
            examInfo.setTeacherEmail(teacherExamBySelf.getTeacher());
            examInfo.setStartTime(st);
            examInfo.setExamTime(ed);
            examInfo.setExamName(teacherExamBySelf.getExamName());
            examInfoService.insertExamInfo(examInfo);
            //对HistoryExam这个表进行添加信息
            updateHistoryExam(teacherExamBySelf.getNian(),teacherExamBySelf.getBan()
                    ,teacherExamBySelf.getExamName());
            subjectService.createDyTable(examname);
            //添加信息,将题加入列表中
            //存放的是单选题的id
            List<Integer> subject = new ArrayList<>();
            for(int i = 0;i<teacherExamBySelf.getDan().length;i++){
                subject.add((teacherExamBySelf.getDan())[i]);
            }
            for(int i = 0;i<teacherExamBySelf.getDuo().length;i++){
                subject.add((teacherExamBySelf.getDuo())[i]);
            }
//            subject.addAll(teacherExamBySelf.getDan());
//            subject.addAll(teacherExamBySelf.getDuo());
            //存放的是多选题的id
            List<Integer> subjectPin = new LinkedList<>();
            for(int i = 0;i<teacherExamBySelf.getTian().length;i++){
                subjectPin.add((teacherExamBySelf.getTian())[i]);
            }
            for(int i = 0;i<teacherExamBySelf.getZhu().length;i++){
                subjectPin.add((teacherExamBySelf.getZhu())[i]);
            }
            for(int i = 0;i<subject.size();i++){
                Subject subjects = subjectService.selectById((long)subject.get(i)).get(0);
                ExamCommonModel examCommonModel = new ExamCommonModel(subjects,teacherExamBySelf.getDanzhi(),
                        teacherExamBySelf.getDuozhi());
                examCommonModel.setExamName(examname);
                subjectService.insertToExamTable(examCommonModel);
            }
            for(int i = 0;i<subjectPin.size();i++){
                SubjectPin subjectPin1 = subjectPinService.selectSubjectPin(subjectPin.get(i));
                ExamCommonModel examCommonModel = new ExamCommonModel(subjectPin1,teacherExamBySelf.getTianzhi(),
                        teacherExamBySelf.getZhuzhi());
                examCommonModel.setExamName(examname);
                subjectService.insertToExamTable(examCommonModel);
            }
            res =  ResultMsg.success();
        }
        catch (Exception e){
            res = ResultMsg.failed();
            res.setMsg(e.getMessage());
        }
        finally {
            System.out.println(json(res));
            return res;
        }
    }


    public void subjectInsertToExam(List<Subject> res,SubExamModel subExamModel,String examName){
        for(int i = 0;i<res.size();i++){
            ExamCommonModel examCommonModel = new ExamCommonModel(res.get(i),subExamModel);
            examCommonModel.setExamName(examName);
            subjectService.insertToExamTable(examCommonModel);
        }
    }
    public void subjectPinInsertToExam(List<SubjectPin> res,SubExamModel subExamModel,String examName){
        for(int i = 0;i<res.size();i++){
            ExamCommonModel examCommonModel = new ExamCommonModel(res.get(i),subExamModel);
            examCommonModel.setExamName(examName);
            subjectService.insertToExamTable(examCommonModel);
        }
    }
    public void addListId(List<Subject> ss,List<Subject> subject,int num){
        while(num-->0){
            System.out.println("subject的大小为"+subject.size());
            int random =(int)(Math.random()*(subject.size()));
            System.out.println("random = "+random);
            ss.add(subject.get(random));
            subject.remove(random);
        }
    }
    public void addListIdPin(List<SubjectPin> ss,List<SubjectPin> subject,int num){
        while(num-->0){
            int random =(int)(Math.random()*(subject.size()));;
            ss.add(subject.get(random));
            subject.remove(random);

        }
    }
    //这个方法是获取单选题困难题所有符合条件的题目类型
    public List<Subject> allDanDifficultSubject(SubExamModel subExamModel) {
        List<Subject> res = new ArrayList<>();
        if (subExamModel.getRandom_dan().equals("on")) {
            //所有单选困难的题
            List<Subject> subjects = subjectService.AllDataByDifficutl(subExamModel.getSubject(),
                    subExamModel.getRandomDanDifficultNum()==0?(long) 999:(long) 3,
                    "1");
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取单选题中等题所有符合条件的题目类型
    public List<Subject> allDanMiddleSubject(SubExamModel subExamModel) {
        List<Subject> res = new ArrayList<>();
        if (subExamModel.getRandom_dan().equals("on")) {
            //所有单选困难的题
            List<Subject> subjects = subjectService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomDanMiddleNum()==0?(long) 999:(long) 2,
                    "1");
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取单选题简单题所有符合条件的题目类型
    public List<Subject> allDanSimpleSubject(SubExamModel subExamModel) {
        List<Subject> res = new ArrayList<>();
        if (subExamModel.getRandom_dan().equals("on")) {
            //所有单选困难的题
            List<Subject> subjects = subjectService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomDanSimpleNum()==0?(long) 999:(long) 1,
                    "1");
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取多选题困难题所有符合条件的题目类型
    public List<Subject> allDuoDifficultSubject(SubExamModel subExamModel) {
        List<Subject> res = new ArrayList<>();
        if (subExamModel.getRandom_duo().equals("on")) {
            //所有单选困难的题
            List<Subject> subjects = subjectService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomDuoDifficultNum()==0?(long) 999:(long) 3,
                    "2");
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取多选题中等题所有符合条件的题目类型
    public List<Subject> allDuoMiddleSubject(SubExamModel subExamModel) {
        List<Subject> res = new ArrayList<>();
        if (subExamModel.getRandom_duo().equals("on")) {
            //所有单选困难的题
            List<Subject> subjects = subjectService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomDuoMiddleNum()==0?(long) 999:(long) 2,
                    "2");
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取多选题简单题所有符合条件的题目类型
    public List<Subject> allDuoSimpleSubject(SubExamModel subExamModel) {
        List<Subject> res = new ArrayList<>();
        if (subExamModel.getRandom_duo().equals("on")) {
            //所有单选困难的题
            List<Subject> subjects = subjectService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomDuoSimpleNum()==0?(long) 999:(long) 1,
                    "2");
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取填空题题困难题所有符合条件的题目类型
    public List<SubjectPin> allTianDifficultSubject(SubExamModel subExamModel) {
        List<SubjectPin> res = new ArrayList<>();
        if (subExamModel.getRandom_tian().equals("on")) {
            //所有单选困难的题
            List<SubjectPin> subjects = subjectPinService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomTianDifficultNum()==0?(long) 999:(long) 3,
                    1);
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取填空题题中等题所有符合条件的题目类型
    public List<SubjectPin> allTianMiddleSubject(SubExamModel subExamModel) {
        List<SubjectPin> res = new ArrayList<>();
        if (subExamModel.getRandom_tian().equals("on")) {
            //所有单选困难的题
            List<SubjectPin> subjects = subjectPinService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomTianMiddleNum()==0?(long) 999:(long) 2,
                    1);
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取填空题题中等题所有符合条件的题目类型
    public List<SubjectPin> allTianSimpleSubject(SubExamModel subExamModel) {
        List<SubjectPin> res = new ArrayList<>();
        if (subExamModel.getRandom_tian().equals("on")) {
            //所有单选困难的题
            List<SubjectPin> subjects = subjectPinService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomTianSimpleNum()==0?(long) 999:(long) 1,
                    1);
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取简答题困等题所有符合条件的题目类型
    public List<SubjectPin> allZhuDifficultSubject(SubExamModel subExamModel) {
        List<SubjectPin> res = new ArrayList<>();
        if (subExamModel.getRandom_zhu().equals("on")) {
            //所有单选困难的题
            List<SubjectPin> subjects = subjectPinService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomZhuDifficultNum()==0?(long) 999:(long) 3,
                    2);
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取简答题题中等题所有符合条件的题目类型
    public List<SubjectPin> allZhuMiddleSubject(SubExamModel subExamModel) {
        List<SubjectPin> res = new ArrayList<>();
        if (subExamModel.getRandom_zhu().equals("on")) {
            //所有单选困难的题
            List<SubjectPin> subjects = subjectPinService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomZhuMiddleNum()==0?(long) 999:(long) 2,
                    2);
            res.addAll(subjects);
        }
        return res;
    }
    //这个方法是获取简答题题简单题所有符合条件的题目类型
    public List<SubjectPin> allZhuSimpleSubject(SubExamModel subExamModel) {
        List<SubjectPin> res = new ArrayList<>();
        if (subExamModel.getRandom_zhu().equals("on")) {
            //所有单选简单的题
            List<SubjectPin> subjects = subjectPinService.AllDataByDifficutl(subExamModel.getSubject(),
                    (long) subExamModel.getRandomZhuSimpleNum()==0?(long) 999:(long) 1,
                    2);
            res.addAll(subjects);
        }
        return res;
    }

}
