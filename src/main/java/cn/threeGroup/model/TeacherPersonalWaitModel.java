package cn.threeGroup.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TeacherPersonalWaitModel {
    private String examination_name;
    private String grade_name;
    private String class_name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date start_time;
    private long count;
    private long countWait;

    public TeacherPersonalWaitModel(String examination_name, String grade_name, String class_name, Date start_time, long count, long countWait) {
        this.examination_name = examination_name;
        this.grade_name = grade_name;
        this.class_name = class_name;
        this.start_time = start_time;
        this.count = count;
        this.countWait = countWait;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getCountWait() {
        return countWait;
    }

    public void setCountWait(long countWait) {
        this.countWait = countWait;
    }

    public String getExamination_name() {
        return examination_name;
    }

    public void setExamination_name(String examination_name) {
        this.examination_name = examination_name;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    @Override
    public String toString() {
        return "TeacherPersonalWaitModel{" +
                "examination_name='" + examination_name + '\'' +
                ", grade_name='" + grade_name + '\'' +
                ", class_name='" + class_name + '\'' +
                ", start_time=" + start_time +
                ", count=" + count +
                ", countWait=" + countWait +
                '}';
    }
}
