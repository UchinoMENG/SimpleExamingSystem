package cn.threeGroup.dao;

import cn.threeGroup.domain.HistoryExam;
import cn.threeGroup.domain.HistoryExamExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HistoryExamMapper {
    long countByExample(HistoryExamExample example);

    int deleteByExample(HistoryExamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(HistoryExam record);

    int insertSelective(HistoryExam record);

    List<HistoryExam> selectByExample(HistoryExamExample example);

    HistoryExam selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") HistoryExam record, @Param("example") HistoryExamExample example);

    int updateByExample(@Param("record") HistoryExam record, @Param("example") HistoryExamExample example);

    int updateByPrimaryKeySelective(HistoryExam record);

    int updateByPrimaryKey(HistoryExam record);
    int selectAllStudent(@Param(value="history_exam")String history_exam);
}