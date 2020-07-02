package cn.threeGroup.controller;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Controller
@RequestMapping("user")
public class UserController {

//    @Autowired
//    private UserService userService;

    /**
//     * 登录
//     * @param userVo
//     * @param model
//     * @return
//     */
//    @RequestMapping("login")
//    public String login(UserVo userVo, Model model){
//        String msg = "";
//        String code = (String) WebUtils.getHttpSession().getAttribute("code");
//
//        //验证码是否正确
//        if(code.equals(userVo.getCode())){
//            //查询用户是否存在
//            User user = userService.checkUserName(userVo);
//            System.out.println(user+"______________");
//            if(user != null){
//                //查询用户密码是否正确
//                User userAndPwd = userService.checkUserNameAndPwd(userVo);
//                if(userAndPwd != null){
//                    //人有，帐号也有
//                    String realName = userAndPwd.getRealname();
//                    //放到session里
//                    WebUtils.getHttpSession().setAttribute("user",realName);
//                    model.addAttribute("realName",realName);
//                    return "index";
//                }else{
//                    msg = SysContast.PWD_ERROE_MSG;
//                    model.addAttribute("msg",msg);
//                    return "login";
//                }
//            }else{
//                msg = SysContast.USER_ERROE_MSG;
//                model.addAttribute("msg",msg);
//                return "login";
//            }
//        }else{
//            msg = SysContast.CODE_ERROE_MSG;
//            model.addAttribute("msg",msg);
//            return "login";
//        }
//
//    }

    /**
     * 验证码
     * @param response
     * @param session
     * @throws IOException
     */
    @RequestMapping("getCode")
    public void getCode(HttpServletResponse response, HttpSession session) throws IOException {
        //定义图形验证码的图片 长116和宽33   字母数，线条干扰个数
        LineCaptcha lineCaptcha = CaptchaUtil.createLineCaptcha(116, 33,4,30);
        //图形验证码写输出到浏览器
        lineCaptcha.write(response.getOutputStream());
        //获取验证码上的数
        session.setAttribute("code",lineCaptcha.getCode());
    }
}
