package cn.threeGroup.controller;

import cn.threeGroup.model.TeacherPersonalPublishModel;
import cn.threeGroup.model.TeacherPersonalWaitModel;
import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.serivce.TeacherPersonalSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("teacherPersonal")
public class TeacherPersonalController {

    @Autowired
    TeacherPersonalSerivce teacherPersonalSerivce;
    @ResponseBody
    @RequestMapping(value = "showWait",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ResultMsg showWait(HttpServletRequest req){
        String userEmail=req.getHeader("userEmail");
        //入参日志
        System.out.println("showWait方法的入参：HttpServletRequest = "+req+" userEmail = "+userEmail);
        ResultMsg res= new ResultMsg();
        try {
            List<TeacherPersonalWaitModel> l1= teacherPersonalSerivce.getWait(userEmail);
            res= res.success();
            res=res.add("reswait",l1);
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res = res.failed();
            res.setMsg(errorInfo);
        }finally {
            //出参日志
            System.out.println("showWait方法的出参："+res);
            return res;
        }
    }
    @ResponseBody
    @RequestMapping(value = "published",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ResultMsg published(HttpServletRequest req){
        String userEmail=req.getHeader("userEmail");
        //入参日志
        System.out.println("published方法的入参：HttpServletRequest = "+req+" userEmail = "+userEmail);
        ResultMsg res= new ResultMsg();
        try {
            List<TeacherPersonalPublishModel> l1= teacherPersonalSerivce.getPublished(userEmail);
            res= res.success();
            res=res.add("reswait",l1);
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res = res.failed();
            res.setMsg(errorInfo);
        }finally {
            //出参日志
            System.out.println("published方法的出参："+res);
            return res;
        }
    }
}
