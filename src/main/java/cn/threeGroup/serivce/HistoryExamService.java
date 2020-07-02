package cn.threeGroup.serivce;

import cn.threeGroup.dao.HistoryExamMapper;
import cn.threeGroup.domain.HistoryExam;
import cn.threeGroup.domain.HistoryExamExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryExamService {
    @Autowired
    private HistoryExamMapper historyExamMapper;

    public List<HistoryExam> allHistoryExam(String useremail){
        HistoryExamExample historyExamExample = new HistoryExamExample();
        System.out.println("查询历史考试成绩执行开始");
        historyExamExample.createCriteria().andStudentEmailEqualTo(useremail);
        return historyExamMapper.selectByExample(historyExamExample);
    }

    public int insertHistoryExam(HistoryExam historyExam){
        return historyExamMapper.insertSelective(historyExam);
    }

    public  List<HistoryExam> stuSearchExam(String studentEmail) {
        HistoryExamExample historyExamExample=new HistoryExamExample();
        HistoryExamExample.Criteria criteria = historyExamExample.createCriteria();
        criteria.andStudentEmailEqualTo(studentEmail);
        return historyExamMapper.selectByExample(historyExamExample);
    }
    /**
     * @ClassName HistoryExamService
     * @Description : 根据学生的邮箱和exam返回学生的分数
     *
     * @param useremail
     * @param exam
     * @Return : double
     * @Author : mlq
     * @Date : 2020/6/4 17:44
     */

    public double getScoreByUseremailAndExam(String useremail,String exam){
        HistoryExamExample historyExamExample = new HistoryExamExample();
        historyExamExample.createCriteria().andStudentEmailEqualTo(useremail).andHistoryExamEqualTo(exam);
        return historyExamMapper.selectByExample(historyExamExample).get(0).getScore();
    }

    public int updateScore(HistoryExam historyExam) {
        HistoryExamExample historyExamExample=new HistoryExamExample();
        HistoryExamExample.Criteria criteria = historyExamExample.createCriteria();
        criteria.andStudentEmailEqualTo(historyExam.getStudentEmail()).andHistoryExamEqualTo(historyExam.getHistoryExam());
        return historyExamMapper.updateByExampleSelective(historyExam,historyExamExample);
    }
    public int selectAllStudent(@Param(value="examName")String examName) {
        return historyExamMapper.selectAllStudent(examName);
    }
}
