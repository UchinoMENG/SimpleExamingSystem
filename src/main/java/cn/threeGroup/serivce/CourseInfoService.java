package cn.threeGroup.serivce;

import cn.threeGroup.dao.CourseInfoMapper;
import cn.threeGroup.domain.CourseInfo;
import cn.threeGroup.domain.CourseInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseInfoService {
    @Autowired
    private CourseInfoMapper courseInfoMapper;
    //获取课程信息
    public List<CourseInfo> getCourseInfo(CourseInfo courseInfo){
        CourseInfoExample courseInfoExample = new CourseInfoExample();
        CourseInfoExample.Criteria criteria = courseInfoExample.createCriteria();
        criteria.andUseremailEqualTo(courseInfo.getUseremail());
        return courseInfoMapper.selectByExample(courseInfoExample);
    }
    public int addCourseInfo(CourseInfo courseInfo){
        return courseInfoMapper.insert(courseInfo);
    }
}
