package cn.threeGroup.dao;

import cn.threeGroup.domain.CourseInfo;
import cn.threeGroup.domain.CourseInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CourseInfoMapper {
    long countByExample(CourseInfoExample example);

    int deleteByExample(CourseInfoExample example);

    int insert(CourseInfo record);

    int insertSelective(CourseInfo record);

    List<CourseInfo> selectByExample(CourseInfoExample example);

    int updateByExampleSelective(@Param("record") CourseInfo record, @Param("example") CourseInfoExample example);

    int updateByExample(@Param("record") CourseInfo record, @Param("example") CourseInfoExample example);
}