package cn.threeGroup.serivce;

import cn.threeGroup.dao.SubjectPinMapper;
import cn.threeGroup.domain.SubjectPin;
import cn.threeGroup.domain.SubjectPinExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectPinService {
    @Autowired
    private SubjectPinMapper subjectPinMapper;

    public SubjectPin selectSubjectPin(long id){
        return subjectPinMapper.selectByPrimaryKey(id);
    }
    //加入pin表中
    public int addSubjectPin(SubjectPin s){
        return subjectPinMapper.insertSelective(s);
    }

    //找出所有的困难程度,题目类型和科目为指定的数所有数据
    //1. 科目 2难度程度 3类型
    public List<SubjectPin> AllDataByDifficutl(String subjectType,Long difficultNum,int courseTypr){
        SubjectPinExample subjectPinExample = new SubjectPinExample();
        SubjectPinExample.Criteria criteria = subjectPinExample.createCriteria();
        criteria.andPinDifficultEqualTo(difficultNum).andPinTypeEqualTo(subjectType).andPinOptionEqualTo(courseTypr);
        return subjectPinMapper.selectByExample(subjectPinExample);
    }
    public List<String> allSubject(){
        return subjectPinMapper.allSubject();
    }
    //根据题目Id获取这个ID的所有的信息
    public SubjectPin selectById(Long  id){
        return subjectPinMapper.selectByPrimaryKey(id);
    }
}
