package cn.threeGroup.dao;

import cn.threeGroup.domain.TeacherInfo;
import cn.threeGroup.domain.TeacherInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeacherInfoMapper {
    long countByExample(TeacherInfoExample example);

    int deleteByExample(TeacherInfoExample example);

    int insert(TeacherInfo record);

    int insertSelective(TeacherInfo record);

    List<TeacherInfo> selectByExample(TeacherInfoExample example);

    int updateByExampleSelective(@Param("record") TeacherInfo record, @Param("example") TeacherInfoExample example);

    int updateByExample(@Param("record") TeacherInfo record, @Param("example") TeacherInfoExample example);
}