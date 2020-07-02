package cn.threeGroup.dao;

import cn.threeGroup.domain.AccInfo;
import cn.threeGroup.domain.AccInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccInfoMapper {
    long countByExample(AccInfoExample example);

    int deleteByExample(AccInfoExample example);

    int deleteByPrimaryKey(String useremail);

    int insert(AccInfo record);

    int insertSelective(AccInfo record);

    List<AccInfo> selectByExample(AccInfoExample example);

    AccInfo selectByPrimaryKey(String useremail);

    int updateByExampleSelective(@Param("record") AccInfo record, @Param("example") AccInfoExample example);

    int updateByExample(@Param("record") AccInfo record, @Param("example") AccInfoExample example);

    int updateByPrimaryKeySelective(AccInfo record);

    int updateByPrimaryKey(AccInfo record);
}