package cn.threeGroup.dao;

import cn.threeGroup.domain.Kk;
import cn.threeGroup.domain.KkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface KkMapper {
    long countByExample(KkExample example);

    int deleteByExample(KkExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Kk record);

    int insertSelective(Kk record);

    List<Kk> selectByExample(KkExample example);

    Kk selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Kk record, @Param("example") KkExample example);

    int updateByExample(@Param("record") Kk record, @Param("example") KkExample example);

    int updateByPrimaryKeySelective(Kk record);

    int updateByPrimaryKey(Kk record);
}