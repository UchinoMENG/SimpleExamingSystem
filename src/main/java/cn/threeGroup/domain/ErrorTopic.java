package cn.threeGroup.domain;

import cn.threeGroup.model.ExamUtilsModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorTopic {
    private Long id;

    private String studentId;

    private String courseName;

    private String examinationName;

    private String judgeTeacher;

    private String topicType;

    private Long topicId;

    private Byte rightError;

    private String rightAnswer;

    private String personalAnswer;

    private String anlysis;

    private Float rightScore;

    private Float score;

    private Byte sign;
    //根据subject来创建ErrorTopic
    public ErrorTopic(Subject subject, String useremail, String teacherName, ExamUtilsModel examUtilsModel,String examinationName,String subjectName){
        this.topicType = "1";
        this.rightError = 0;    //默认为错误
        this.sign = 0;      //init为未阅
        this.rightAnswer = subject.getSubjectAnswer();
        this.rightScore = examUtilsModel.getScore();
        this.score = 0f;
        this.examinationName = examinationName;
        this.anlysis = subject.getAnswerAnalysis();
        this.studentId = useremail;
        this.topicId = subject.getId();
        this.judgeTeacher = teacherName;
        this.personalAnswer = "";
        this.courseName =subjectName;
    }
    //根据SubjectPin来创建ErrorTopic
    public ErrorTopic(SubjectPin subjectpin, String useremail, String teacherName, ExamUtilsModel examUtilsModel,String examinationName,String subjectName){
        this.topicType = "2";
        this.rightError = 0;    //默认为错误
        this.sign = 0;      //init为未阅
        this.rightAnswer = subjectpin.getPinAnswer();
        this.rightScore = examUtilsModel.getScore();
        this.score = 0f;
        this.courseName = subjectName;
        this.examinationName = examinationName;
        this.anlysis = subjectpin.getPinAnly();
        this.studentId = useremail;
        this.topicId = subjectpin.getPinId();
        this.judgeTeacher = teacherName;
        this.personalAnswer = "";
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId == null ? null : studentId.trim();
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName == null ? null : courseName.trim();
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName == null ? null : examinationName.trim();
    }

    public String getJudgeTeacher() {
        return judgeTeacher;
    }

    public void setJudgeTeacher(String judgeTeacher) {
        this.judgeTeacher = judgeTeacher == null ? null : judgeTeacher.trim();
    }

    public String getTopicType() {
        return topicType;
    }

    public void setTopicType(String topicType) {
        this.topicType = topicType == null ? null : topicType.trim();
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Byte getRightError() {
        return rightError;
    }

    public void setRightError(Byte rightError) {
        this.rightError = rightError;
    }

    public String getRightAnswer() {
        return rightAnswer;
    }

    public void setRightAnswer(String rightAnswer) {
        this.rightAnswer = rightAnswer == null ? null : rightAnswer.trim();
    }

    public String getPersonalAnswer() {
        return personalAnswer;
    }

    public void setPersonalAnswer(String personalAnswer) {
        this.personalAnswer = personalAnswer == null ? null : personalAnswer.trim();
    }

    public String getAnlysis() {
        return anlysis;
    }

    public void setAnlysis(String anlysis) {
        this.anlysis = anlysis == null ? null : anlysis.trim();
    }

    public Float getRightScore() {
        return rightScore;
    }

    public void setRightScore(Float rightScore) {
        this.rightScore = rightScore;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    public Byte getSign() {
        return sign;
    }

    public void setSign(Byte sign) {
        this.sign = sign;
    }
}