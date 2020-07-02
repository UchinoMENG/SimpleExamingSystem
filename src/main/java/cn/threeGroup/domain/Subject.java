package cn.threeGroup.domain;

import cn.threeGroup.model.SubjectDomain;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
public class Subject extends SubjectKey {
    private String subjectName;

    private String subjectCentent;

    private String subjectOptions;

    private Double subjectValue;

    private String subjectAnswer;

    private String answerAnalysis;

    private String subjectTypeCode;

    private String courseTypeCode;

    private String knowledgeCode;

    private Long subjectDifficultly;

    private String createAccount;

    private Date createTime;

    private Date updateTime;

    private Date deleteTime;

    public Subject(SubjectDomain temp){
        this.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        this.setKnowledgeCode(temp.getType_t());
        this.setSubjectTypeCode(temp.getCourse_type());
        this.setAnswerAnalysis(temp.getRightres());
        this.setDeleteStatus(0);
        this.setSubjectValue(temp.getScore());
        this.setCourseTypeCode(temp.getType_title());
        this.setCreateTime(new Timestamp(System.currentTimeMillis()));
        this.setSubjectDifficultly(temp.getDiffcult());
        this.setSubjectCentent(temp.getTitle());
        this.setSubjectName(temp.getTitle());
        this.setCreateAccount(temp.getUseremail());
        String  options = "";
        if(temp.getChoicea()!=null){
            options+=temp.getChoicea()+"@";
        }
        if(temp.getChoiceb()!=null){
            options+=temp.getChoiceb()+"@";
        }
        if(temp.getChoicec()!=null){
            options+=temp.getChoicec()+"@";
        }
        if(temp.getChoiced()!=null){
            options+=temp.getChoiced();
        }
        this.setSubjectOptions(options);
        String answer = "";
        if(temp.getAnswerA()!=null&&temp.getAnswerA().equals("on")){
            answer+="A@";
            System.out.println(1111111);
        }
        if(temp.getAnswerB()!=null&&temp.getAnswerB().equals("on")){
            answer+="B@";
            System.out.println(22222222);
        }
        if(temp.getAnswerC()!=null&&temp.getAnswerC().equals("on")){
            System.out.println(3333333);
            answer+="C@";
        }
        if(temp.getAnswerD()!=null&&temp.getAnswerD().equals("on")){
            System.out.println(444444444);
            answer+="D@";
        }
        this.setSubjectAnswer(answer);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName == null ? null : subjectName.trim();
    }

    public String getSubjectCentent() {
        return subjectCentent;
    }

    public void setSubjectCentent(String subjectCentent) {
        this.subjectCentent = subjectCentent == null ? null : subjectCentent.trim();
    }

    public String getSubjectOptions() {
        return subjectOptions;
    }

    public void setSubjectOptions(String subjectOptions) {
        this.subjectOptions = subjectOptions == null ? null : subjectOptions.trim();
    }

    public Double getSubjectValue() {
        return subjectValue;
    }

    public void setSubjectValue(Double subjectValue) {
        this.subjectValue = subjectValue;
    }

    public String getSubjectAnswer() {
        return subjectAnswer;
    }

    public void setSubjectAnswer(String subjectAnswer) {
        this.subjectAnswer = subjectAnswer == null ? null : subjectAnswer.trim();
    }

    public String getAnswerAnalysis() {
        return answerAnalysis;
    }

    public void setAnswerAnalysis(String answerAnalysis) {
        this.answerAnalysis = answerAnalysis == null ? null : answerAnalysis.trim();
    }

    public String getSubjectTypeCode() {
        return subjectTypeCode;
    }

    public void setSubjectTypeCode(String subjectTypeCode) {
        this.subjectTypeCode = subjectTypeCode == null ? null : subjectTypeCode.trim();
    }

    public String getCourseTypeCode() {
        return courseTypeCode;
    }

    public void setCourseTypeCode(String courseTypeCode) {
        this.courseTypeCode = courseTypeCode == null ? null : courseTypeCode.trim();
    }

    public String getKnowledgeCode() {
        return knowledgeCode;
    }

    public void setKnowledgeCode(String knowledgeCode) {
        this.knowledgeCode = knowledgeCode == null ? null : knowledgeCode.trim();
    }

    public Long getSubjectDifficultly() {
        return subjectDifficultly;
    }

    public void setSubjectDifficultly(Long subjectDifficultly) {
        this.subjectDifficultly = subjectDifficultly;
    }

    public String getCreateAccount() {
        return createAccount;
    }

    public void setCreateAccount(String createAccount) {
        this.createAccount = createAccount == null ? null : createAccount.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}