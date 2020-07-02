package cn.threeGroup.serivce;

import cn.threeGroup.dao.BindInfoMapper;
import cn.threeGroup.domain.BindInfo;
import cn.threeGroup.domain.BindInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BindInfoService {
    @Autowired
    private BindInfoMapper bindInfoMapper;
    //获取绑定信息
    public BindInfo getBindInfo(BindInfo bindInfo){
        return bindInfoMapper.selectByPrimaryKey(bindInfo.getUseremail());
    }
    //增加Bindinfo
    public void addBindInfo(BindInfo bindInfo){
        bindInfoMapper.insertSelective(bindInfo);
    }

}
