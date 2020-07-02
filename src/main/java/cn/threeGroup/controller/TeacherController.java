package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.TeacherInfo;
import cn.threeGroup.domain.UserInfo;
import cn.threeGroup.model.BaseTeacherModel;
import cn.threeGroup.serivce.LoginService;
import cn.threeGroup.serivce.TeacherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeacherController {
    @Autowired
    private LoginService loginService;

    @Autowired
    private TeacherInfoService teacherInfoService;

    @ResponseBody
    @RequestMapping(value = "/insertTeacher",method = RequestMethod.POST)
    public ResultMsg addTeacherInfo(BaseTeacherModel baseTeacherModel){
        UserInfo userInfo = new UserInfo(baseTeacherModel);
        TeacherInfo teacherInfo = new TeacherInfo(baseTeacherModel);
        try{
            loginService.addUserInfo(userInfo);
            System.out.println("往userinfo增添信息成功");
            teacherInfoService.addTeacherInfo(teacherInfo);
            System.out.println("往teacherinfo增添信息成功");
        }
        catch (Exception e){
            System.out.println("请求//insertTeacher失败了");
            return ResultMsg.failed();
        }
        return ResultMsg.success();
    }
}
