package cn.threeGroup.serivce;

import cn.threeGroup.model.ExamNameModel;
import cn.threeGroup.model.PExamNameModel;
import cn.threeGroup.model.TeacherPersonalPublishModel;
import cn.threeGroup.model.TeacherPersonalWaitModel;
import cn.threeGroup.dao.ErrorTopicMapper;
import cn.threeGroup.dao.ExamInfoMapper;
import cn.threeGroup.domain.ErrorTopicExample;
import cn.threeGroup.domain.ExamInfo;
import cn.threeGroup.domain.ExamInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherPersonalSerivce {
    @Autowired
    private ErrorTopicMapper errorTopicMapper;

    @Autowired
    private ExamInfoMapper examInfoMapper;

    public List<TeacherPersonalWaitModel> getWait(String email){
        List<PExamNameModel> le=errorTopicMapper.selectWaitExamNameByEmail(email);
        List<TeacherPersonalWaitModel> tpm=new ArrayList<TeacherPersonalWaitModel>();
        for(int i=0;i<le.size();i++){
            String exam=le.get(i).getExaminationName();
            List<ExamInfo> ll=getWaitInfo(exam);
            long count=getSum(exam);
            long countWait=getWaitSum(exam);
            TeacherPersonalWaitModel t=new TeacherPersonalWaitModel(exam,ll.get(0).getGradeName(),ll.get(0).getClassName(),ll.get(0).getStartTime(),count,countWait);
            tpm.add(t);
        }
        return tpm;
    }
    public List<ExamInfo> getWaitInfo(String exam){
        ExamInfoExample e2=new ExamInfoExample();
        e2.createCriteria().andExamNameEqualTo(exam);
        return examInfoMapper.selectByExample(e2);
    }
    public long getSum(String exam){
        ErrorTopicExample e1=new ErrorTopicExample();
        e1.createCriteria().andExaminationNameEqualTo(exam);
        return errorTopicMapper.countByExample(e1);
    }
    public long getWaitSum(String exam){
        ErrorTopicExample e1=new ErrorTopicExample();
        e1.createCriteria().andExaminationNameEqualTo(exam).andSignEqualTo((byte)1);
        return errorTopicMapper.countByExample(e1);
    }

    //发布试卷信息
    public List<TeacherPersonalPublishModel> getPublished(String email){
//        ErrorTopicExample e3=new ErrorTopicExample();
//        e3.setDistinct(true);
//        e3.createCriteria().andJudgeTeacherEqualTo(email).andSignEqualTo((byte)  1);
        List<PExamNameModel> le= errorTopicMapper.selectPublishExamNameByEmail(email);
        List<TeacherPersonalPublishModel> tpm=new ArrayList<TeacherPersonalPublishModel>();
        int temp=1;
        for(int i=0;i<le.size();i++){
            String exam=le.get(i).getExaminationName();
            List<ExamInfo> ll=getWaitInfo(exam);
            TeacherPersonalPublishModel t=new TeacherPersonalPublishModel(exam,ll.get(0).getGradeName(),ll.get(0).getClassName(),ll.get(0).getStartTime());
            tpm.add(t);
        }
        return tpm;
    }


}
