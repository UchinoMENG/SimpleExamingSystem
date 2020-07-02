package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.UserInfo;
import cn.threeGroup.serivce.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

@Controller
public class LoginController extends BaseController{
    @Autowired
    private LoginService loginService;

    /**
     * @ClassName LoginController
     * @Description : 登录
     *
     * @param useremail
     * @param password
     * @param id
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 13:45
    */

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ResultMsg loginTest(String useremail, String password, int id,String code, HttpSession session){
        System.out.println("useremail = " +useremail+",password = "+password);
        String code1=(String) session.getAttribute("code");
        if(!code1.equals(code)){
            ResultMsg msg = ResultMsg.failed();
            msg.setMsg("验证码错误");
            return msg;
        }
        UserInfo userInfo = new UserInfo();
        userInfo.setPassword(password);
        userInfo.setUseremail(useremail);
        userInfo.setUserType(id+1);
        String token = UUID.randomUUID().toString();
        //这里put进去
       add(useremail,token);
        List<UserInfo> userInfo1 = loginService.getUserInfo(userInfo);
        if(userInfo1==null||userInfo1.size()==0){
            ResultMsg msg = ResultMsg.failed();
            msg.setMsg("用户名或者密码错误");
            return msg;
        }
        ResultMsg success = ResultMsg.success();
        success.add("token",token);
        return success;
    }
    /**
     * @ClassName LoginController
     * @Description : 每个页面进来之前需要验证的身份
     *
     * @param req
     * @param useremail
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 13:46
    */

    @ResponseBody
    @RequestMapping(value = "/checkUser",method = RequestMethod.GET)
    public ResultMsg tokenUseremail(HttpServletRequest req, String useremail){
        ResultMsg resultMsg = null;
        try {
            checkToken(req);
            String useremail1 = getUseremail(req);
            if(!useremail.equals(useremail1)){
                throw new Exception("用户邮箱不一致");
            }
            UserInfo userInfo = loginService.checkUserType(useremail);
            resultMsg = ResultMsg.success();
            resultMsg.add("obj",userInfo);
        }
        catch (Exception e){
            String errorInfo = e.getMessage();
            resultMsg = ResultMsg.failed();
            resultMsg.setMsg(errorInfo);
        }
        finally {
            return resultMsg;
        }
    }
}
