package cn.threeGroup.serivce;

import cn.threeGroup.dao.ExamInfoMapper;
import cn.threeGroup.domain.ExamInfo;
import cn.threeGroup.domain.ExamInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ExamInfoService {
    @Autowired
    private ExamInfoMapper examInfoMapper;


    public int insertExamInfo(ExamInfo examInfo){
        return examInfoMapper.insertSelective(examInfo);
    }

    public List<ExamInfo> searchClassname(ExamInfo examInfo){
        ExamInfoExample examInfoExample = new ExamInfoExample();
        ExamInfoExample.Criteria criteria = examInfoExample.createCriteria();
        criteria.andExamNameEqualTo(examInfo.getExamName());
        return examInfoMapper.selectByExample(examInfoExample);
    }
    /**
     * @ClassName ExamInfoService
     * @Description : 返回发布考试的老师的名字
     *
     * @param examName
     * @Return : java.lang.String
     * @Author : mlq
     * @Date : 2020/6/3 5:54
    */

    public String searchTeacherEmailByExamName(String examName){
        ExamInfoExample examInfoExample = new ExamInfoExample();
        examInfoExample.createCriteria().andExamNameEqualTo(examName);
        return examInfoMapper.selectByExample(examInfoExample).get(0).getTeacherEmail();
    }
    /**
     * @ClassName ExamInfoService
     * @Description : 根据考试名返回全部的考试相关信息
     *
     * @param examName
     * @Return : cn.threeGroup.domain.ExamInfo
     * @Author : mlq
     * @Date : 2020/6/3 6:19
    */

    public ExamInfo searchExaminfoByExamName(String examName){
        ExamInfoExample examInfoExample = new ExamInfoExample();
        examInfoExample.createCriteria().andExamNameEqualTo(examName);
        return examInfoMapper.selectByExample(examInfoExample).get(0);
    }
}
