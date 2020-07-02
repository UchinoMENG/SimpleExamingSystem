package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.dao.HistoryExamMapper;
import cn.threeGroup.domain.HistoryExam;
import cn.threeGroup.domain.TeacherInfo;
import cn.threeGroup.serivce.AnalyResultsSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("analyResults")
public class AnalysisResultsController {
   @Autowired
    private AnalyResultsSerivce analyResultsSerivce;

   @ResponseBody
    @RequestMapping(value="stuAna",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public ResultMsg stuAna(HttpServletRequest req){
       String userEmail=req.getHeader("userEmail");
       //入参日志
       System.out.println("stuAna方法的入参：HttpServletRequest = "+req+" userEmail = "+userEmail);
       ResultMsg res= new ResultMsg();
       try {
           List<HistoryExam> l1= analyResultsSerivce.getStuana(userEmail);
           res= res.success();
           res=res.add("stuAna",l1);
       }catch (Exception e){
           String errorInfo=e.getMessage();
           res = res.failed();
           res.setMsg(errorInfo);
       }finally {
           //出参日志
           System.out.println("stuAna方法的出参："+res);
           return res;
       }
   }


}
