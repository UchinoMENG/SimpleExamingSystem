package cn.threeGroup.model;

//@NoArgsConstructor
//@AllArgsConstructor
//@Data
public class RankYearModel {
    private String student_email;
    private String historyExam;
    private String gradeName;
    private String class1;
    private double score;
    private long rank;

    public RankYearModel(String student_email, String historyExam, String gradeName, String class1, double score, long rank) {
        this.student_email = student_email;
        this.historyExam = historyExam;
        this.gradeName = gradeName;
        this.class1 = class1;
        this.score = score;
        this.rank = rank;
    }

    public String getStudent_email() {
        return student_email;
    }

    public void setStudent_email(String student_email) {
        this.student_email = student_email;
    }

    public String getHistoryExam() {
        return historyExam;
    }

    public void setHistoryExam(String historyExam) {
        this.historyExam = historyExam;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getRank() {
        return rank;
    }

    public void setRank(long rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "RankYearModel{" +
                "student_email='" + student_email + '\'' +
                ", historyExam='" + historyExam + '\'' +
                ", gradeName='" + gradeName + '\'' +
                ", class1='" + class1 + '\'' +
                ", score=" + score +
                ", rank=" + rank +
                '}';
    }
}
