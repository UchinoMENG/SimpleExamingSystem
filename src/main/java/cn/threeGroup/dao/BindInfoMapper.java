package cn.threeGroup.dao;

import cn.threeGroup.domain.BindInfo;
import cn.threeGroup.domain.BindInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BindInfoMapper {
    long countByExample(BindInfoExample example);

    int deleteByExample(BindInfoExample example);

    int deleteByPrimaryKey(String useremail);

    int insert(BindInfo record);

    int insertSelective(BindInfo record);

    List<BindInfo> selectByExample(BindInfoExample example);

    BindInfo selectByPrimaryKey(String useremail);

    int updateByExampleSelective(@Param("record") BindInfo record, @Param("example") BindInfoExample example);

    int updateByExample(@Param("record") BindInfo record, @Param("example") BindInfoExample example);

    int updateByPrimaryKeySelective(BindInfo record);

    int updateByPrimaryKey(BindInfo record);
}