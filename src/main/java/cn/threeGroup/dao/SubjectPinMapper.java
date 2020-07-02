package cn.threeGroup.dao;

import cn.threeGroup.domain.SubjectPin;
import cn.threeGroup.domain.SubjectPinExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SubjectPinMapper {
    long countByExample(SubjectPinExample example);

    int deleteByExample(SubjectPinExample example);

    int deleteByPrimaryKey(Long pinId);

    int insert(SubjectPin record);

    int insertSelective(SubjectPin record);

    List<SubjectPin> selectByExample(SubjectPinExample example);

    SubjectPin selectByPrimaryKey(Long pinId);

    int updateByExampleSelective(@Param("record") SubjectPin record, @Param("example") SubjectPinExample example);

    int updateByExample(@Param("record") SubjectPin record, @Param("example") SubjectPinExample example);

    int updateByPrimaryKeySelective(SubjectPin record);

    int updateByPrimaryKey(SubjectPin record);

    List<String> allSubject();
}