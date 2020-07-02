package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.domain.HistoryExam;
import cn.threeGroup.helpper.CheckParam;
import cn.threeGroup.model.ExamUserModel;
import cn.threeGroup.model.ResultModel;
import cn.threeGroup.serivce.HistoryExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HistoryController extends BaseController{

    @Autowired
    private HistoryExamService historyExamService;

    /**
     * @ClassName HistoryController
     * @Description : 获取这个考生的全部考试
     *
     * @param useremail
     * @Return : cn.threeGroup.Utils.ResultMsg
     * @Author : mlq
     * @Date : 2020/6/3 13:45
    */

    @ResponseBody
    @RequestMapping(value = "/histroyexam",method = RequestMethod.GET)
    public ResultMsg historyExam(String useremail){
        System.out.println("useremail = "+useremail);
        ResultMsg resultMsg = null;
        try{
            CheckParam.checkUseremail(useremail);
            List<HistoryExam> historyExams = historyExamService.allHistoryExam(useremail);
            resultMsg = ResultMsg.success();
            resultMsg.add("obj",historyExams);
        }
        catch (Exception e){
            resultMsg = ResultMsg.failed();
            String errorinfo = e.getMessage();
            resultMsg.setMsg(errorinfo);
            System.out.println(json(resultMsg));
        }
        finally {
            return resultMsg;
        }

    }

}
