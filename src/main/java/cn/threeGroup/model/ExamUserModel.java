package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamUserModel {
    private String userEmail;
    private String examName;
    private Timestamp timestamp;
    private Double examgrade;


    public ExamUserModel(String userEmail, String examName, Timestamp timestamp) {
        this.userEmail = userEmail;
        this.examName = examName;
        this.timestamp = timestamp;
    }
    public ExamUserModel(String userEmail, String examName) {
        this.userEmail = userEmail;
        this.examName = examName;
    }

}
