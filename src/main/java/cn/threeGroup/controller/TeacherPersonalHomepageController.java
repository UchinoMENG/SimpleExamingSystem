package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.TeacherInfo;
import cn.threeGroup.model.TeacherPersonalPublishModel;
import cn.threeGroup.serivce.TeacherPersonalHomepageService;
import cn.threeGroup.serivce.TeacherPersonalSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("teacherPersonalHomepage")
public class TeacherPersonalHomepageController {
    @Autowired
    private TeacherPersonalHomepageService teacherPersonalHomepageSerivce;

    @ResponseBody
    @RequestMapping(value="showInfo",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ResultMsg showInfo(HttpServletRequest req){
        String userEmail=req.getHeader("userEmail");
        //入参日志
        System.out.println("showInfo方法的入参：HttpServletRequest = "+req+" userEmail = "+userEmail);
        ResultMsg res= new ResultMsg();
        try {
            List<TeacherInfo> l1= teacherPersonalHomepageSerivce.showInfo(userEmail);
            res= res.success();
            res=res.add("reswait",l1);
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res = res.failed();
            res.setMsg(errorInfo);
        }finally {
            //出参日志
            System.out.println("showInfo方法的出参："+res);
            return res;
        }
    }

}
