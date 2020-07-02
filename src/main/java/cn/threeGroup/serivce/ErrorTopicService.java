package cn.threeGroup.serivce;

import cn.threeGroup.dao.ErrorTopicMapper;
import cn.threeGroup.domain.ErrorTopic;
import cn.threeGroup.domain.ErrorTopicExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.ByteBuffer;
import java.util.List;

@Service
public class ErrorTopicService {
    @Autowired
    private ErrorTopicMapper errorTopicMapper;
    public List<ErrorTopic> selectErrorTopic(ErrorTopic errorTopic){
        ErrorTopicExample errorTopicExample=new ErrorTopicExample();
        ErrorTopicExample.Criteria criteria = errorTopicExample.createCriteria();
        criteria.andExaminationNameEqualTo(errorTopic.getExaminationName())
                .andTopicIdEqualTo(errorTopic.getTopicId())
                .andJudgeTeacherEqualTo(errorTopic.getJudgeTeacher())
                .andStudentIdEqualTo(errorTopic.getStudentId())
                .andTopicTypeEqualTo(errorTopic.getTopicType());
        return errorTopicMapper.selectByExample(errorTopicExample);
    }
    public List<ErrorTopic> selectTopic(Long id){
        ErrorTopicExample errorTopicExample=new ErrorTopicExample();

        ErrorTopicExample.Criteria criteria = errorTopicExample.createCriteria();
        criteria.andIdEqualTo(id);
        return errorTopicMapper.selectByExample(errorTopicExample);
    }
    public int updateScore1(ErrorTopic errorTopic){
        return errorTopicMapper.updateScore1(errorTopic);
    }
    public List<ErrorTopic> selectTopic1(ErrorTopic errorTopic,byte a){
        ErrorTopicExample errorTopicExample=new ErrorTopicExample();

        ErrorTopicExample.Criteria criteria = errorTopicExample.createCriteria();
        criteria.andExaminationNameEqualTo(errorTopic.getExaminationName())
                .andStudentIdEqualTo(errorTopic.getStudentId())
                .andSignEqualTo(a).andTopicTypeEqualTo("2");
        return errorTopicMapper.selectByExample(errorTopicExample);
    }

    public List<ErrorTopic> selectTopicSubject(String es,String id,byte a,String b){
        ErrorTopicExample errorTopicExample=new ErrorTopicExample();

        ErrorTopicExample.Criteria criteria = errorTopicExample.createCriteria();
        criteria.andExaminationNameEqualTo(es)
                .andStudentIdEqualTo(id)
                .andTopicTypeEqualTo(b)
                .andSignEqualTo(a)
        ;
        System.out.println("==============="+b);
        return errorTopicMapper.selectByExample(errorTopicExample);
    }
    public List<ErrorTopic> selectTopicSubjectPin(String es,String id,byte a,String n){
        ErrorTopicExample errorTopicExample=new ErrorTopicExample();

        ErrorTopicExample.Criteria criteria = errorTopicExample.createCriteria();
        criteria.andExaminationNameEqualTo(es)
                .andStudentIdEqualTo(id).andTopicTypeEqualTo(n).andSignEqualTo(a);
        return errorTopicMapper.selectByExample(errorTopicExample);
    }

    public int updateScore(ErrorTopic errorTopic){
        ErrorTopicExample errorTopicExample=new ErrorTopicExample();

        ErrorTopicExample.Criteria criteria = errorTopicExample.createCriteria();
        criteria.andIdEqualTo(errorTopic.getId());
        return errorTopicMapper.updateByExampleSelective(errorTopic,errorTopicExample);
    }

    public List<ErrorTopic> selectAllTopic(String es,String id) {
        ErrorTopicExample errorTopicExample=new ErrorTopicExample();

        ErrorTopicExample.Criteria criteria = errorTopicExample.createCriteria();
        criteria.andExaminationNameEqualTo(es)
                .andStudentIdEqualTo(id);
        return errorTopicMapper.selectByExample(errorTopicExample);
    }

    public int insertToErrorTopic(ErrorTopic errorTopic){
        return errorTopicMapper.insertSelective(errorTopic);
    }

    /**
     * @ClassName ErrorTopicService
     * @Description : 根据考试名找出所有学生的每道题的做题情况
     *
     * @param examName
     * @Return : java.util.List<cn.threeGroup.domain.ErrorTopic>
     * @Author : mlq
     * @Date : 2020/6/2 14:49
     */
    public List<ErrorTopic> selectByExamName(String examName){
        ErrorTopicExample errorTopicExample = new ErrorTopicExample();
        errorTopicExample.createCriteria().andExaminationNameEqualTo(examName);
        return errorTopicMapper.selectByExample(errorTopicExample);
    }
    /**
     * @ClassName ErrorTopicService
     * @Description : 根据exam，sign，type返回所有的考试实例
     *
     * @param examName
     * @param sign
     * @param type
     * @Return : java.util.List<cn.threeGroup.domain.ErrorTopic>
     * @Author : mlq
     * @Date : 2020/6/2 18:14
     */

    public List<ErrorTopic> selectByAutoExam(String examName,byte sign,String type,String useremail){
        ErrorTopicExample errorTopicExample = new ErrorTopicExample();
        errorTopicExample.createCriteria().andExaminationNameEqualTo(examName).andSignEqualTo(sign)
                .andTopicTypeEqualTo(type).andStudentIdEqualTo(useremail);
        return errorTopicMapper.selectByExample(errorTopicExample);
    }
    public int updateErrorTopic(ErrorTopic errorTopic){
        ErrorTopicExample errorTopicExample = new ErrorTopicExample();
        errorTopicExample.createCriteria().andIdEqualTo(errorTopic.getId());
        return errorTopicMapper.updateByExampleSelective(errorTopic,errorTopicExample);
    }

    /**
     * @ClassName ErrorTopicService
     * @Description : 根据email,topicId,topicType查找大某个题，然后将个人答案更新
     *
     * @param email
     * @param topicId
     * @param topicType
     * @param personalAnswer
     * @Return : int
     * @Author : mlq
     * @Date : 2020/6/3 10:45
     */
    public int updateErrorByPersonalAnswer(String email,long topicId,String topicType,String personalAnswer,String examname){
        ErrorTopicExample errorTopicExample1 = new ErrorTopicExample();
        errorTopicExample1.createCriteria().andTopicIdEqualTo(topicId).andStudentIdEqualTo(email)
                .andTopicTypeEqualTo(topicType).andExaminationNameEqualTo(examname);
        ErrorTopic errorTopic = new ErrorTopic();
        errorTopic.setPersonalAnswer(personalAnswer);
        return errorTopicMapper.updateByExampleSelective(errorTopic,errorTopicExample1);
    }
    /**
     * @ClassName ErrorTopicService
     * @Description : 根据考试名，题目类型，sign值得到试题，由于填空题会自动判卷，所以填空sign的为1，而简答题是为0的
     *
     * @param exam
     * @param type
     * @param sign
     * @Return : java.util.List<cn.threeGroup.domain.ErrorTopic>
     * @Author : mlq
     * @Date : 2020/6/4 5:44
     */

    public List<ErrorTopic> selectByExamNameAndSignAndType(String exam, String type, byte sign){
        ErrorTopicExample errorTopicExample1 = new ErrorTopicExample();
        errorTopicExample1.createCriteria().andExaminationNameEqualTo(exam).andTopicTypeEqualTo(type)
                .andSignEqualTo(sign);
        return errorTopicMapper.selectByExample(errorTopicExample1);
    }
    /**
     * @ClassName ErrorTopicService
     * @Description : 根据学生的邮箱和exam返回学生的全部考题
     *
     * @param useremail
     * @param exam
     * @Return : cn.threeGroup.domain.ErrorTopic
     * @Author : mlq
     * @Date : 2020/6/4 17:49
     */

    public List<ErrorTopic> findByUseremailAndExam(String useremail,String exam){
        ErrorTopicExample errorTopicExample = new ErrorTopicExample();
        errorTopicExample.createCriteria().andExaminationNameEqualTo(exam).andStudentIdEqualTo(useremail);
        return errorTopicMapper.selectByExample(errorTopicExample);
    }

    public String[] selectPeople(@Param(value="examName")String examName, @Param(value="topic_id")Long topic_id,@Param(value="topic_type")String topic_type) {
        return  errorTopicMapper.selectPeople(examName,topic_id,topic_type);
    }

    public List<ErrorTopic> errorStudentSearch(@Param(value="examName")String examName,@Param(value="topic_id")Long topic_id, @Param(value="topic_type")String topic_type ) {
        return errorTopicMapper.errorStudentSearch(examName,topic_id,topic_type);
    }

    /**
     *是否做过试卷
     * @param examName
     * @param studentEmail
     * @return
     */
    public int doFlag(@Param(value="examName")String examName, @Param(value="studentEmail")String studentEmail) {
        return errorTopicMapper.doFlag(examName,studentEmail);
    }
}
