package cn.threeGroup.dao;

import cn.threeGroup.domain.ErrorTopic;
import cn.threeGroup.domain.ErrorTopicExample;
import java.util.List;

import cn.threeGroup.model.ExamNameModel;
import cn.threeGroup.model.PExamNameModel;
import cn.threeGroup.model.TeacherPersonalWaitModel;
import org.apache.ibatis.annotations.Param;

public interface ErrorTopicMapper {
    long countByExample(ErrorTopicExample example);

    int deleteByExample(ErrorTopicExample example);

    int insert(ErrorTopic record);

    int insertSelective(ErrorTopic record);

    List<ErrorTopic> selectByExample(ErrorTopicExample example);

    int updateByExampleSelective(@Param("record") ErrorTopic record, @Param("example") ErrorTopicExample example);
    int updateScore1(ErrorTopic errorTopic);
    int updateByExample(@Param("record") ErrorTopic record, @Param("example") ErrorTopicExample example);

    //    2表查询类
    List<TeacherPersonalWaitModel> selectByExamInfoErrorTopic(@Param("email") String email);

    List<PExamNameModel> selectWaitExamNameByEmail(@Param("email") String email);

    List<PExamNameModel> selectPublishExamNameByEmail(@Param("email") String email);

    /**
     * 查Email
     * @param examination_name
     * @param topic_id
     * @param topic_type
     * @return
     */
    String[] selectPeople( @Param(value="examination_name")String examination_name,  @Param(value="topic_id")Long topic_id,@Param(value="topic_type")String topic_type);

    /**
     * 查做错同学
     * @param examName
     * @param topic_id
     * @param topic_type
     * @return
     */
    List<ErrorTopic> errorStudentSearch( @Param(value="examination_name")String examName,@Param(value="topic_id")Long topic_id, @Param(value="topic_type")String topic_type);

    /**
     * shi
     * @param examination_name
     * @param student_id
     * @return
     */
    int doFlag(@Param(value="examination_name")String examination_name, @Param(value="student_id")String student_id);

}