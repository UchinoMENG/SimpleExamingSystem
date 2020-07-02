package cn.threeGroup.dao;

import cn.threeGroup.domain.ExamInfo;
import cn.threeGroup.domain.ExamInfoExample;
import java.util.List;

import cn.threeGroup.model.ExamNameModel;
import cn.threeGroup.model.PExamNameModel;
import cn.threeGroup.model.TeacherPersonalWaitModel;
import org.apache.ibatis.annotations.Param;

public interface ExamInfoMapper {
    long countByExample(ExamInfoExample example);

    int deleteByExample(ExamInfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExamInfo record);

    int insertSelective(ExamInfo record);

    List<ExamInfo> selectByExample(ExamInfoExample example);

    ExamInfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExamInfo record, @Param("example") ExamInfoExample example);

    int updateByExample(@Param("record") ExamInfo record, @Param("example") ExamInfoExample example);

    int updateByPrimaryKeySelective(ExamInfo record);

    int updateByPrimaryKey(ExamInfo record);

}