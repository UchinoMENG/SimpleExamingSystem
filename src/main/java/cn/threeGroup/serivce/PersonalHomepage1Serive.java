package cn.threeGroup.serivce;

import cn.threeGroup.dao.PerInfoMapper;
import cn.threeGroup.dao.PerInfoMapper;
import cn.threeGroup.domain.PerInfo;
import cn.threeGroup.domain.PerInfoExample;
import cn.threeGroup.domain.PerInfo;
import cn.threeGroup.domain.PerInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalHomepage1Serive {
    @Autowired
    private PerInfoMapper perInfoMapper;

    public PerInfo getIdentity(String userEmail){
        return perInfoMapper.selectByPrimaryKey(userEmail);
    }
    public int setIdentity(String userEmail, PerInfo per){
        PerInfoExample perinfoExample=new PerInfoExample();
        perinfoExample.createCriteria().andUseremailEqualTo(userEmail);
        return perInfoMapper.updateByExampleSelective(per,perinfoExample);
    }
}
