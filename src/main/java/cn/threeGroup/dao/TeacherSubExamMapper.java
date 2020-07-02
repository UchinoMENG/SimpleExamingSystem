package cn.threeGroup.dao;

import cn.threeGroup.domain.TeacherSubExam;
import cn.threeGroup.domain.TeacherSubExamExample;
import cn.threeGroup.domain.TeacherSubExamWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherSubExamMapper {
    long countByExample(TeacherSubExamExample example);

    int deleteByExample(TeacherSubExamExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeacherSubExamWithBLOBs record);

    int insertSelective(TeacherSubExamWithBLOBs record);

    List<TeacherSubExamWithBLOBs> selectByExampleWithBLOBs(TeacherSubExamExample example);

    List<TeacherSubExam> selectByExample(TeacherSubExamExample example);

    TeacherSubExamWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeacherSubExamWithBLOBs record, @Param("example") TeacherSubExamExample example);

    int updateByExampleWithBLOBs(@Param("record") TeacherSubExamWithBLOBs record, @Param("example") TeacherSubExamExample example);

    int updateByExample(@Param("record") TeacherSubExam record, @Param("example") TeacherSubExamExample example);

    int updateByPrimaryKeySelective(TeacherSubExamWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(TeacherSubExamWithBLOBs record);

    int updateByPrimaryKey(TeacherSubExam record);
}