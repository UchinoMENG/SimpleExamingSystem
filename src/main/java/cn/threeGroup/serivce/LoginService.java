package cn.threeGroup.serivce;

import cn.threeGroup.dao.UserInfoMapper;
import cn.threeGroup.domain.UserInfo;
import cn.threeGroup.domain.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LoginService {
    @Autowired
    private UserInfoMapper userInfoMapper;
    //获取符合邮箱和密码的用户
    public List<UserInfo> getUserInfo(UserInfo userInfo){
        UserInfoExample userInfoExample = new UserInfoExample();
        UserInfoExample.Criteria criteria = userInfoExample.createCriteria();
        criteria.andUseremailEqualTo(userInfo.getUseremail()).andPasswordEqualTo(userInfo.getPassword())
        .andUserTypeEqualTo(userInfo.getUserType());
        List<UserInfo> userInfos = userInfoMapper.selectByExample(userInfoExample);
        return userInfos;
    }
    //增加userinfo中的用户
    public int addUserInfo(UserInfo userInfo){
        return userInfoMapper.insertSelective(userInfo);
    }
    public UserInfo checkUserType(String useremail){
       return userInfoMapper.selectByPrimaryKey(useremail);
    }
}
