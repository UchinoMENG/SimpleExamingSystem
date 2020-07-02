package cn.threeGroup.controller;

import cn.threeGroup.model.ResultModel;
import cn.threeGroup.check.CheckPersonalHomepage;
import cn.threeGroup.domain.PerInfo;
import cn.threeGroup.serivce.PersonalHomepage1Serive;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("personalHomepage")
public class PersonalHomepage1Controller extends BaseController {
    Gson gson=new Gson();

    @Autowired
    private PersonalHomepage1Serive personalHomepage1Serive;

    @ResponseBody
    @RequestMapping(value = "showPersonalInformation",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String showPersonalInformation(HttpServletRequest req){
        //入参日志
        System.out.println("showPersonalInformation方法的入参：HttpServletRequest = "+req+" useremail = "+req.getHeader("useremail"));
        ResultModel<ArrayList<PerInfo>> res=new ResultModel<>();
        try{
//            add(req.getHeader("token"),"3434345453@qq.com");
//            CheckToken(req);
//            String userEmail=getUserEmail(req);
            PerInfo per=personalHomepage1Serive.getIdentity(req.getHeader("useremail"));
            ArrayList<PerInfo> list = new ArrayList<PerInfo>();
            list.add(per);
            res.setData(list);
        } catch (Exception e) {
            String errorInfo=e.getMessage();
            res.setMessage(errorInfo);
            res.setCode("111");
        }
        finally {
            String json=json(res);
            //出参日志
            System.out.println("showPersonalInformation方法的出参："+json);
            return json;
        }
    }


    @ResponseBody
    @RequestMapping(value = "personalInformation",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String personalInformation(HttpServletRequest req, PerInfo per){
        //入参日志
        System.out.println("personalInformation方法的入参：HttpServletRequest = "+req+" userEmail = "+req.getHeader("userEmail")+" Perinfo = "+per);

        ResultModel<ArrayList<Integer>> res=new ResultModel<>();
        try{
//            add(req.getHeader("token"),"33333@qq.com");
//            CheckToken(req);
            String useremail=req.getHeader("userEmail");
            CheckPersonalHomepage.personalInformation(per);
            int flag =personalHomepage1Serive.setIdentity(useremail,per);
            ArrayList<Integer> list = new ArrayList<>();
            list.add(flag);
            res.setData(list);
        } catch (Exception e) {
            String errorInfo=e.getMessage();
            res.setMessage(errorInfo);
            res.setCode("111");
        }
        finally {
            String json=json(res);
            //出参日志
            System.out.println("personalInformation方法的出参："+json);
            return json;
        }
    }

}
