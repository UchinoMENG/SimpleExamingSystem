package cn.threeGroup.serivce;

import cn.threeGroup.dao.HistoryExamMapper;
import cn.threeGroup.domain.HistoryExam;
import cn.threeGroup.domain.HistoryExamExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnalyResultsSerivce {
    @Autowired
    private HistoryExamMapper historyExamMapper;

    public List<HistoryExam> getStuana(String email){
        HistoryExamExample historyExamExample=new HistoryExamExample();
        historyExamExample.createCriteria().andStudentEmailEqualTo(email);
        return historyExamMapper.selectByExample(historyExamExample);
    }
}
