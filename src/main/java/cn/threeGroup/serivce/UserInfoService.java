package cn.threeGroup.serivce;

import cn.threeGroup.dao.UserInfoMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Mzh
 * @date 2020-06-07 16:44
 * @description:
 * @version:
 */
@Service
public class UserInfoService {
    @Autowired
    UserInfoMapper userInfoMapper;

    public String selectStudentName(@Param(value="useremail")String useremail ) {
        return userInfoMapper.selectStudentName(useremail);
    }
}
