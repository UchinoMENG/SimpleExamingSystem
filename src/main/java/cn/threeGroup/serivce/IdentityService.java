package cn.threeGroup.serivce;

import cn.threeGroup.dao.IdentityMapper;
import cn.threeGroup.domain.Identity;
import cn.threeGroup.domain.IdentityExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityService {
    @Autowired
    private IdentityMapper identityMapper;
    //获取身份
    public Identity getIdentity(Identity identity){
        return identityMapper.selectByPrimaryKey(identity.getId());
    }
}
