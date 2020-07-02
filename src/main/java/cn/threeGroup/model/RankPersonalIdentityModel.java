package cn.threeGroup.model;

public class RankPersonalIdentityModel {
    private String userName;
    private String examinationSubject;
    private float grade;
    private int rank;

    public RankPersonalIdentityModel(String userName, String examinationSubject, float grade, int rank) {
        this.userName = userName;
        this.examinationSubject = examinationSubject;
        this.grade = grade;
        this.rank = rank;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getExaminationSubject() {
        return examinationSubject;
    }

    public void setExaminationSubject(String examinationSubject) {
        this.examinationSubject = examinationSubject;
    }

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade) {
        this.grade = grade;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
