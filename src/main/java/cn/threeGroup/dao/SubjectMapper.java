package cn.threeGroup.dao;

import cn.threeGroup.domain.Subject;
import cn.threeGroup.domain.SubjectExample;
import cn.threeGroup.domain.SubjectKey;

import java.util.ArrayList;
import java.util.List;

import cn.threeGroup.model.ExamCommonModel;
import cn.threeGroup.model.ExamUtilsModel;
import org.apache.ibatis.annotations.Param;

public interface SubjectMapper {
    long countByExample(SubjectExample example);

    int deleteByExample(SubjectExample example);

    int deleteByPrimaryKey(SubjectKey key);

    int insert(Subject record);

    int insertSelective(Subject record);

    List<Subject> selectByExample(SubjectExample example);

    Subject selectByPrimaryKey(SubjectKey key);

    int updateByExampleSelective(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    int updateByPrimaryKeySelective(Subject record);

    int updateByPrimaryKey(Subject record);
    void createExamTable(@Param("examName") String examName);
    int existsExamTalble(@Param("examName") String examName);
    int insertToExamTable(ExamCommonModel examCommonModel);
    List<String> allSubject();
    Subject selectByTopicId(long id);
    List<ExamUtilsModel> allExamInfo(@Param("examName") String examName);
    ExamUtilsModel examTitleById(@Param("examName") String examName, @Param("examid") int examid);
}