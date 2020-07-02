package cn.threeGroup.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TeacherPersonalPublishModel {
    private String examination_name;
    private String grade_name;
    private String class_name;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm",timezone="GMT+8")
    private Date start_time;

    public TeacherPersonalPublishModel(String examination_name, String grade_name, String class_name, Date start_time) {
        this.examination_name = examination_name;
        this.grade_name = grade_name;
        this.class_name = class_name;
        this.start_time = start_time;
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
        return "TeacherPersonalPublishModel{" +
                "examination_name='" + examination_name + '\'' +
                ", grade_name='" + grade_name + '\'' +
                ", class_name='" + class_name + '\'' +
                ", start_time=" + start_time +
                '}';
    }
}
