package cn.threeGroup.serivce;

import cn.threeGroup.dao.TeacherInfoMapper;
import cn.threeGroup.domain.TeacherInfo;
import cn.threeGroup.domain.TeacherInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherInfoService {
    @Autowired
    private TeacherInfoMapper teacherInfoMapper;

    public int addTeacherInfo(TeacherInfo teacherInfo){
        System.out.println("开始增加老师信息");
        return teacherInfoMapper.insertSelective(teacherInfo);
    }

    public TeacherInfo getTeacherByEmail(String useremail){
        TeacherInfoExample teacherInfoExample = new TeacherInfoExample();
        teacherInfoExample.createCriteria().andUseremailEqualTo(useremail);
        return teacherInfoMapper.selectByExample(teacherInfoExample).get(0);
    }
}
