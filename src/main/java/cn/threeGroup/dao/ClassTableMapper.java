package cn.threeGroup.dao;

import cn.threeGroup.domain.ClassTable;
import cn.threeGroup.domain.ClassTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ClassTableMapper {
    long countByExample(ClassTableExample example);

    int deleteByExample(ClassTableExample example);

    int deleteByPrimaryKey(String userEmail);

    int insert(ClassTable record);

    int insertSelective(ClassTable record);

    List<ClassTable> selectByExample(ClassTableExample example);

    ClassTable selectByPrimaryKey(String userEmail);

    int updateByExampleSelective(@Param("record") ClassTable record, @Param("example") ClassTableExample example);

    int updateByExample(@Param("record") ClassTable record, @Param("example") ClassTableExample example);

    int updateByPrimaryKeySelective(ClassTable record);

    int updateByPrimaryKey(ClassTable record);
    List<String> allGradeName();
    List<String> allClassName(@Param("gradeName") String gradeName);
}