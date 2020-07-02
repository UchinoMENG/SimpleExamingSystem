package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.Subject;
import cn.threeGroup.domain.SubjectPin;
import cn.threeGroup.model.SubjectDomain;
import cn.threeGroup.serivce.SubjectPinService;
import cn.threeGroup.serivce.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

//增加题目的controller
@Controller
public class SubjectController extends BaseController{

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private SubjectPinService subjectPinService;

    @ResponseBody
    @RequestMapping(value = "/initSubject",method = RequestMethod.GET)
    public ResultMsg initSubject(){
        Set<String> set = new HashSet<>();
        set.addAll(subjectService.allSubject());
        set.addAll(subjectPinService.allSubject());
        return ResultMsg.success().add("obj",set);
    }

    @ResponseBody
    @RequestMapping(value = "/subject",method = RequestMethod.POST)
    public ResultMsg addSubject(String title,Double score,String diffcult,String answer,String choicea,String choiceb,
                                String choicec,String choiced,String rightres,String type_t,String useremail,String course_type){
        //啊啊啊啊啊，这里要写疯了，还不如用BeanUtils了
        System.out.println("我执行了subject方法");
        Subject subject = new Subject();
        subject.setAnswerAnalysis(answer);
        subject.setCreateTime(new Timestamp(System.currentTimeMillis()));
        subject.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        subject.setSubjectName(title);
        subject.setSubjectTypeCode(course_type);
        subject.setKnowledgeCode(type_t);
        subject.setCreateAccount(useremail);
        subject.setCourseTypeCode("1");
        subject.setDeleteStatus(0);
        String choice = choicea+"@"+choiceb+"@"+choicec+"@"+choiced;
        subject.setSubjectOptions(choice);
        subject.setSubjectAnswer(rightres);
        subject.setSubjectDifficultly(Long.parseLong(diffcult));
        subject.setSubjectValue(score);
        subject.setSubjectCentent(title);
        int i = subjectService.addSubject(subject);
        System.out.println("题目增加成功");
        if(i==0){
            return ResultMsg.failed();
        }
        else{
            return ResultMsg.success();
        }
    }
    @ResponseBody
    @RequestMapping(value = "/mulsubject",method = RequestMethod.POST)
    public ResultMsg addMulSubject(SubjectDomain res){
        Subject subject = new Subject(res);
        System.out.println(json(res));
        System.out.println(json(subject));
        int i = subjectService.addSubject(subject);
        if(i!=0){
            return ResultMsg.success();
        }
        return ResultMsg.failed();
    }
    @ResponseBody
    @RequestMapping(value = "/subjectpin",method = RequestMethod.POST)
    public ResultMsg addSubjectPin(SubjectPin pinModel){
        System.out.println(json(pinModel));
        int sign = subjectPinService.addSubjectPin(pinModel);
        if(sign!=1){
            return ResultMsg.failed();
        }
        return ResultMsg.success();
    }
}
