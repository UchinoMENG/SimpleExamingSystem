package cn.threeGroup.serivce;

import cn.threeGroup.dao.SubjectMapper;
import cn.threeGroup.domain.Subject;
import cn.threeGroup.domain.SubjectExample;
import cn.threeGroup.model.ExamCommonModel;
import cn.threeGroup.model.ExamUtilsModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectMapper subjectMapper;

    public int addSubject(Subject subject){
        System.out.println("题目准备增加");
        return subjectMapper.insertSelective(subject);
    }

    //查询科目的总量
    public List<String> allSubject(){
        return subjectMapper.allSubject();
    }

    public void createDyTable(String tableName){
        subjectMapper.createExamTable(tableName);
    }

    //验证这个数据库中是否存在这个表
    public int existsExamTable(String tableName){
        return subjectMapper.existsExamTalble(tableName);
    }
    //找出所有的困难程度,题目类型和科目为指定的数所有数据
    //1. 科目 2难度程度 3类型
    public List<Subject> AllDataByDifficutl(String subjectType, Long difficultNum, String courseTypr){
        SubjectExample subjectExample = new SubjectExample();
        SubjectExample.Criteria criteria = subjectExample.createCriteria();
        criteria.andSubjectDifficultlyEqualTo(difficultNum).andSubjectTypeCodeEqualTo(subjectType).andCourseTypeCodeEqualTo(courseTypr);
        return subjectMapper.selectByExample(subjectExample);
    }

    public int insertToExamTable(ExamCommonModel examCommonModel){
        return subjectMapper.insertToExamTable(examCommonModel);
    }
    //获取考试表中的所有信息
    public List<ExamUtilsModel> allExamInfo(String examName){
        return subjectMapper.allExamInfo(examName);
    }
    //根据题目Id获取题目信息
    public List<Subject> selectById(Long id){
        SubjectExample s = new SubjectExample();
        s.createCriteria().andIdEqualTo(id);
        return subjectMapper.selectByExample(s);
    }
    /**
     * @ClassName SubjectService
     * @Description : 根据表名和id找到对应的那一行
     *
     * @param examName
     * @param id
     * @Return : cn.threeGroup.model.ExamUtilsModel
     * @Author : mlq
     * @Date : 2020/6/3 10:39
    */

    public ExamUtilsModel selectByExamNameAndId(String examName,int id){
        ExamUtilsModel examUtilsModel = subjectMapper.examTitleById(examName, id);
        return examUtilsModel;
    }

    public Subject selectByTopicId(long subjectCode) {
        Subject subject = subjectMapper.selectByTopicId(subjectCode);
        return subject;
    }
}
