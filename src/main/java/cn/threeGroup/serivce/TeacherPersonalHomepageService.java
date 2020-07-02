package cn.threeGroup.serivce;

import cn.threeGroup.dao.TeacherInfoMapper;
import cn.threeGroup.domain.TeacherInfo;
import cn.threeGroup.domain.TeacherInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import java.awt.*;

@Service
public class TeacherPersonalHomepageService {
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    //显示教师个人信息
    public List<TeacherInfo> showInfo(String email){
        TeacherInfoExample teacherInfoExample=new TeacherInfoExample();
        teacherInfoExample.createCriteria().andUseremailEqualTo(email);
        return teacherInfoMapper.selectByExample(teacherInfoExample);
    }
}
