package cn.threeGroup.dao;

import cn.threeGroup.domain.PerInfo;
import cn.threeGroup.domain.PerInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerInfoMapper {
    long countByExample(PerInfoExample example);

    int deleteByExample(PerInfoExample example);

    int deleteByPrimaryKey(String useremail);

    int insert(PerInfo record);

    int insertSelective(PerInfo record);

    List<PerInfo> selectByExampleWithBLOBs(PerInfoExample example);

    List<PerInfo> selectByExample(PerInfoExample example);

    PerInfo selectByPrimaryKey(String useremail);

    int updateByExampleSelective(@Param("record") PerInfo record, @Param("example") PerInfoExample example);

    int updateByExampleWithBLOBs(@Param("record") PerInfo record, @Param("example") PerInfoExample example);

    int updateByExample(@Param("record") PerInfo record, @Param("example") PerInfoExample example);

    int updateByPrimaryKeySelective(PerInfo record);

    int updateByPrimaryKeyWithBLOBs(PerInfo record);

    int updateByPrimaryKey(PerInfo record);
}