package cn.threeGroup.serivce;

import cn.threeGroup.dao.AccInfoMapper;
import cn.threeGroup.domain.AccInfo;
import cn.threeGroup.domain.AccInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class AccInfoService {
    @Autowired
    private AccInfoMapper accInfoMapper;
    //通过邮箱获取用户信息
    public AccInfo getAccInfo(AccInfo accInfo){
        return accInfoMapper.selectByPrimaryKey(accInfo.getUseremail());
    }

    public void insertAccInfo(AccInfo accInfo){
        accInfoMapper.insertSelective(accInfo);
    }
    //更新数据
    public int updateAsName(AccInfo accInfo){
        return accInfoMapper.updateByPrimaryKeySelective(accInfo);
    }
    public int UpAccinfo(AccInfo accInfo){
        return accInfoMapper.updateByPrimaryKeySelective(accInfo);
    }
}
