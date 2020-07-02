package cn.threeGroup.controller;

import cn.threeGroup.model.RankClassModel;
import cn.threeGroup.model.RankYearModel;
import cn.threeGroup.model.ResultModel;
import cn.threeGroup.Utils.TableResultMsg;
import cn.threeGroup.check.CheckRank;
import cn.threeGroup.domain.HistoryExam;
import cn.threeGroup.serivce.RankSerivce;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
@RequestMapping("rank")
public class RankController extends BaseController{
    Gson gson=new Gson();
    @Autowired
    private RankSerivce rankSerivce;

    @ResponseBody
    @RequestMapping(value = "personalIdentity",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    public ResultModel personalIdentity(HttpServletRequest req, String history_exam){
        //入参日志
        System.out.println("personalIdentity方法的入参：HttpServletRequest = "+req+" userEmail = "+req.getHeader("userEmail")+" history_exam = "+history_exam);
        ResultModel <ArrayList<HistoryExam>> res=new ResultModel<>();
        try{
//            CheckToken(req);
//            String userEmail=getUserEmail(req);
            String userEmail=req.getHeader("userEmail");
            CheckRank.checkPersonalIdentity(history_exam);
            HistoryExam history_exam1 = rankSerivce.getPersonalInformation(userEmail,history_exam).get(0);
            String username=rankSerivce.getUsername(userEmail).getUsername();
            ArrayList<HistoryExam> list = new ArrayList<>();
            System.out.println("前："+username);
            history_exam1.setStudentEmail(username);
            System.out.println("后："+history_exam1.getStudentEmail());
            list.add(history_exam1);
            res.setData(list);
        } catch (Exception e) {
            String errorInfo=e.getMessage();
            res.setMessage(errorInfo);
            res.setCode("111");
        }
        finally {
            String json=json(res);
            //出参日志
            System.out.println("personalIdentity方法的出参："+json);
            return res;
        }

    }
    @ResponseBody
    @RequestMapping(value = "showGrade",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String showGrade(HttpServletRequest req ,String history_exam,String keyword,Integer page ,Integer limit){
        //入参日志
        System.out.println("showGrade方法的入参：HttpServletRequest = "+req+" userEmail = "+req.getHeader("userEmail")+" history_exam = "+history_exam+" keyword="+keyword+" page="+page+" limit="+limit);
        TableResultMsg res=new TableResultMsg();
        try{
            CheckRank.checkShowGrade(history_exam);
            res=rankSerivce.getClass(req.getHeader("userEmail"),history_exam,keyword,page,limit);
        } catch (Exception e) {
            String errorInfo=e.getMessage();
            res.setCode(1);
            res.setMsg(errorInfo);
        }
        finally {
            String json=json(res);
            //出参日志
            System.out.println("showGrade方法的出参："+json);
            return json;
        }

    }
    @ResponseBody
    @RequestMapping(value = "showGradeYear",method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
    public String showGradeYear(HttpServletRequest req ,String history_exam,String keyword,Integer page ,Integer limit){
        //入参日志
        System.out.println("showGradeYear方法的入参：HttpServletRequest = "+req+" userEmail = "+req.getHeader("userEmail")+" history_exam = "+history_exam+" keyword="+keyword);
        TableResultMsg res=new TableResultMsg();
        try{
            CheckRank.checkShowGrade(history_exam);
            res=rankSerivce.getClassYear(req.getHeader("userEmail"),history_exam,keyword,page,limit);
        } catch (Exception e) {
            String errorInfo=e.getMessage();
            res.setMsg(errorInfo);
            res.setCode(1);
        }
        finally {
            String json=json(res);
            //出参日志
            System.out.println("showGradeYear方法的出参："+json);
            return json;
        }
    }


}
