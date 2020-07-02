package cn.threeGroup.serivce;

import cn.threeGroup.dao.UserInfoMapper;
import cn.threeGroup.domain.UserInfo;
import cn.threeGroup.domain.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mzh
 * @date 2020-05-30 16:38
 * @description:
 * @version:
 */
@Service
public class PasswordChangeService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<UserInfo> getPassword(UserInfo userInfo){
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUseremailEqualTo(userInfo.getUseremail()).andPasswordEqualTo(userInfo.getPassword());
        return userInfoMapper.selectByExample(userInfoExample);
    }

    public int setPasswordUserInfo(UserInfo userInfo){
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
    public int setPasswordAccInfo(UserInfo userInfo){
        return userInfoMapper.updateByPrimaryKeySelective(userInfo);
    }
}
