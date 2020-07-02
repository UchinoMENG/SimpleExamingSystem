package cn.threeGroup.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HistoryExam {
    private Long id;

    private String gradename;

    private String classname;

    private String studentEmail;

    private String historyExam;

    private Double score;

    public HistoryExam(ClassTable classTable,String historyExam){
        this.score = 0.0;
        this.classname = classTable.getClassName();
        this.gradename = classTable.getGradeName();
        this.studentEmail = classTable.getUserEmail();
        this.historyExam = historyExam;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail == null ? null : studentEmail.trim();
    }

    public String getHistoryExam() {
        return historyExam;
    }

    public void setHistoryExam(String historyExam) {
        this.historyExam = historyExam == null ? null : historyExam.trim();
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}