package cn.threeGroup.model;

import cn.threeGroup.domain.ErrorTopic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentTitleModel {
    private String choice;
    private float score;
    private String title;
    private String personalAnswer;
    private String useremail;
    private String rightRnswer;
    private String anly;
    public StudentTitleModel(ErrorTopic errorTopic){
        this.choice = errorTopic.getRightAnswer();
        this.score = errorTopic.getRightScore();
        this.personalAnswer = errorTopic.getPersonalAnswer();
        this.useremail = errorTopic.getStudentId();
        this.anly = errorTopic.getAnlysis();
        this.rightRnswer = errorTopic.getRightAnswer();
    }
}
