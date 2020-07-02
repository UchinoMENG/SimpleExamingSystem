package cn.threeGroup.serivce;

import cn.threeGroup.dao.PerInfoMapper;
import cn.threeGroup.domain.PerInfo;
import cn.threeGroup.domain.PerInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerInfoService {
    @Autowired
    private PerInfoMapper perInfoMapper;

    public PerInfo getPerInfo(PerInfo perInfo){
        return perInfoMapper.selectByPrimaryKey(perInfo.getUseremail());
    }
    public void insertPerInfo(PerInfo perInfo){
        perInfoMapper.insertSelective(perInfo);
    }
}
