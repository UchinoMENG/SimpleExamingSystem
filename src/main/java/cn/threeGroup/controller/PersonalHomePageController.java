package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.*;
import cn.threeGroup.serivce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class PersonalHomePageController {
    @Autowired
    private AccInfoService accInfoService;
    @Autowired
    private BindInfoService bindInfoService;
    @Autowired
    private CourseInfoService courseInfoService;
    @Autowired
    private PerInfoService perInfoService;
    @Autowired
    private ClassTableService classTableService;
    @Autowired
    private LoginService loginService;
    @Autowired
    private PasswordChangeService passwordChangeService;


    /**
     * @ClassName PersonalHomePageController
     * @Description : 获取账户信息
     *
     * @param useremail
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 13:48
    */

    @ResponseBody
    @RequestMapping(value = "/accinfo",method = RequestMethod.GET)
    public ResultMsg getAccInfo(String useremail){
        AccInfo accInfo = new AccInfo();
        accInfo.setUseremail(useremail);
        AccInfo res = accInfoService.getAccInfo(accInfo);
        System.out.println(res);
        if(res==null){
            return ResultMsg.failed();
        }
        else{
            return ResultMsg.success().add("obj",res);
        }
    }
    /**
     * @ClassName PersonalHomePageController
     * @Description : 获取绑定信息
     *
     * @param useremail
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 13:49
    */

    @ResponseBody
    @RequestMapping(value = "/bindinfo",method = RequestMethod.GET)
    public ResultMsg getBindInfo(String useremail){
        BindInfo bindInfo = new BindInfo();
        bindInfo.setUseremail(useremail);
        BindInfo res = bindInfoService.getBindInfo(bindInfo);
        if(res==null){
            return ResultMsg.failed();
        }
        else{
            return ResultMsg.success().add("obj",res);
        }
    }
    /**
     * @ClassName PersonalHomePageController
     * @Description : 获取课程信息
     *
     *
     * @param useremail
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 13:49
    */

    @ResponseBody
    @RequestMapping(value = "/courseinfo",method = RequestMethod.GET)
    public ResultMsg getCourseInfo(String useremail){
        CourseInfo courseInfo = new CourseInfo();
        courseInfo.setUseremail(useremail);
        List<CourseInfo> res = courseInfoService.getCourseInfo(courseInfo);
        if(res==null||res.size()==0){
            return ResultMsg.failed();
        }
        else{
            return ResultMsg.success().add("obj",res);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/perinfo",method = RequestMethod.GET)
    public ResultMsg getPerInfo(String useremail){
        PerInfo perInfo = new PerInfo();
        System.out.println(useremail);
        perInfo.setUseremail(useremail);
        PerInfo res = perInfoService.getPerInfo(perInfo);
        if(res==null){
            return ResultMsg.failed();
        }
        else{
            return ResultMsg.success().add("obj",res);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/student",method = RequestMethod.POST)
    public ResultMsg insertStudent(String useremail,String gradename,String classname){
        ClassTable classTable = new ClassTable();
        classTable.setClassName(classname);
        classTable.setGradeName(gradename);
        classTable.setUserEmail(useremail);
        classTable.setDeletestaus(0);
        System.out.println("/student执行开始.....");
        classTable.setCreateTime(new Timestamp(System.currentTimeMillis()));
        List<ClassTable> classTable1 = classTableService.getClassTable(classTable);
        System.out.println("执行到这了吗");
        if(classTable1==null||classTable1.size()==0){
            insertAccinfo(useremail);
            insertPerinfo(useremail);
            insertBindInfo(useremail, String.valueOf(classname), 1);
            insertUserInfo(useremail,useremail,1);
            int sign = classTableService.insertClassTable(classTable);
            if(sign==0){
                System.out.println("classTable添加失败");
            }
            else{
                System.out.println("classTable添加成功");
            }
            System.out.println("/student执行结束.....");
            return ResultMsg.success();
        }
        else{
            ResultMsg resultMsg = ResultMsg.failed();
            resultMsg.setMsg("这个年级和班级存在这个用户");
            return resultMsg;
        }
    }
    @ResponseBody
    @RequestMapping(value = "/updateInfo",method = RequestMethod.GET)
    public ResultMsg updateInfo(String  useremail,String password){
        System.out.println("我执行了吗");
        AccInfo accInfo = new AccInfo();
        accInfo.setUseremail( useremail);
        accInfo.setPassword(password);
        accInfo.setAsname("嘿嘿");
        accInfo.setIdentity(1);
        accInfoService.UpAccinfo(accInfo);
        System.out.println("执行成功");
        return ResultMsg.success();
    }
    public void insertAccinfo(String useremail){
        AccInfo accInfo = new AccInfo();
        accInfo.setUseremail(useremail);
        accInfo.setIdentity(1);
        accInfo.setPassword(useremail);
        accInfo.setAsname("");
        System.out.println("Accinfo添加正在执行");
        accInfoService.insertAccInfo(accInfo);
        System.out.println("Accinfo添加完成");
    }
    //默认密码和邮箱相同
    public void insertUserInfo(String useremail,String password,Integer id){
        UserInfo userInfo = new UserInfo();
        userInfo.setUseremail(useremail);
        userInfo.setPassword(password);
        userInfo.setDeleteStatus(0);
        userInfo.setCreateTime(new Timestamp(System.currentTimeMillis()));
        userInfo.setUserType(id);
        userInfo.setUsername(" ");
        System.out.println("增加userinfo用户正在执行");
        loginService.addUserInfo(userInfo);
        System.out.println("增加userinfo用户已经完成");
    }
    public void insertPerinfo(String useremail){
        PerInfo perInfo = new PerInfo();
        perInfo.setUseremail(useremail);
        perInfo.setAddress("北京");
        perInfo.setUsername(" ");
        perInfo.setHobby(" ");
        perInfo.setSex("男");
        System.out.println("perinfo添加正在执行");
        perInfoService.insertPerInfo(perInfo);
        System.out.println("perinfo添加成功");
    }
    public void  insertBindInfo(String useremail,String classname,int id){
        BindInfo bindInfo = new BindInfo();
        bindInfo.setUseremail(useremail);
        bindInfo.setUserclass(classname);
        bindInfo.setMargin(" ");
        bindInfo.setUserschool("河北大学");
        if(id==1){
            bindInfo.setUserid("学生");
        }
        else if(id==2){
            bindInfo.setUserid("老师");
        }
        else{bindInfo.setUserid("超级管理员");}
        System.out.println("bindinfo正在添加");
        bindInfoService.addBindInfo(bindInfo);
        System.out.println("bindinfo添加成功");
    }
    @ResponseBody
    @RequestMapping(value = "/passwordChange",method = RequestMethod.GET)
    public ResultMsg passwordChange(String userEmail,String pwdOld,String pwdNew){
        System.out.println("=====================================================");
        System.out.println("rucan:"+userEmail+pwdNew);
        UserInfo userInfo=new UserInfo();
        userInfo.setPassword(pwdOld);
        userInfo.setUseremail(userEmail);
        List<UserInfo> res = passwordChangeService.getPassword(userInfo);
        System.out.println(res);
        if(res.size()==0){
            System.out.println("空");
            return ResultMsg.failed();
        }
        else{
            userInfo.setPassword(pwdNew);
            int a=passwordChangeService.setPasswordUserInfo(userInfo);
            int b=passwordChangeService.setPasswordAccInfo(userInfo);
            if(a>0&&b>0){
                ResultMsg.success().setMsg("修改成功");
            }
            System.out.println("正常"+res);
            return ResultMsg.success().add("obj",res);
        }
    }

    @ResponseBody
    @RequestMapping(value = "/asNameUpdate",method = RequestMethod.GET)
    public ResultMsg asNameUpdate(String userEmail,String asname) {
        System.out.println("=====================================================");
        System.out.println("rucan:" + userEmail + asname);
        AccInfo accInfo = new AccInfo();
        accInfo.setUseremail(userEmail);
        accInfo.setAsname(asname);
        if (accInfoService.updateAsName(accInfo) > 0) {
            System.out.println("asname更新完成");
            return ResultMsg.success();
        } else {
            return ResultMsg.failed();
        }
    }
}
