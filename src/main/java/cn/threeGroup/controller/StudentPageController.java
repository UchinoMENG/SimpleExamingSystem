package cn.threeGroup.controller;

import cn.threeGroup.domain.ExamInfo;
import cn.threeGroup.domain.HistoryExam;
import cn.threeGroup.model.ResultModal;
import cn.threeGroup.model.StuTestModel;
import cn.threeGroup.serivce.ErrorTopicService;
import cn.threeGroup.serivce.ExamInfoService;
import cn.threeGroup.serivce.HistoryExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Mzh
 * @date 2020-06-02 19:41
 * @description:
 * @version:
 */
@Controller
public class StudentPageController extends BaseController {
    @Autowired
    HistoryExamService historyExamService;
    @Autowired
    ExamInfoService examInfoService;
    @Autowired
    ErrorTopicService errorTopicService;
    @ResponseBody
    @RequestMapping(value = "/studentTestShow",method = RequestMethod.GET ,produces = "text/html;charset=UTF-8")
    public String studentTestShow(String studentEmail){
        System.out.println("入参："+studentEmail);
        //通过学生邮箱查历史试卷
       List<HistoryExam> historyExamList= historyExamService.stuSearchExam(studentEmail);
       List<StuTestModel> examInfoList=new ArrayList<>();
//       循环试卷去试卷信息找
        while (!historyExamList.isEmpty()){
            String examName=historyExamList.get(0).getHistoryExam();
            System.out.println("试卷名："+examName);
            ExamInfo examInfo=new ExamInfo();
            examInfo.setExamName(examName);
            //是否做过
            int did=errorTopicService.doFlag(examName,studentEmail);
            if(!examInfoService.searchClassname(examInfo).isEmpty()){
                ExamInfo examInfo1= examInfoService.searchClassname(examInfo).get(0);
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String start = dateFormat.format(examInfo1.getStartTime());
                String end = dateFormat.format(examInfo1.getExamTime());
                examInfoList.add(new StuTestModel(examInfo1.getExamName(),start,end,examInfo1.getGradeName(),examInfo1.getClassName(),did,historyExamList.get(0).getScore()));
            }else{
                continue;
            }
            historyExamList.remove(0);
        }
        ResultModal<List<StuTestModel>> res=new ResultModal<>();
        res.setData(examInfoList);
        String json=json(res);
        System.out.println(json);
        return json(res);
    }
}
