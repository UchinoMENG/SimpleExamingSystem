package cn.threeGroup.model;

import cn.threeGroup.domain.ErrorTopic;
import cn.threeGroup.domain.Subject;
import cn.threeGroup.domain.SubjectPin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class TiModel {
    private String title;
    private String options;
    private String anly;
    private String personal;
    private String rightAnswer;
    private Double score;
    private Double rightscore;
    public TiModel(ErrorTopic errorTopic, Subject subject){
        this.title = subject.getSubjectName();
        this.anly = errorTopic.getAnlysis();
        this.options = subject.getSubjectOptions();
        this.score = (double)errorTopic.getScore();
        this.rightscore = (double)errorTopic.getRightScore();
        this.personal = errorTopic.getPersonalAnswer();
        this.rightAnswer = errorTopic.getRightAnswer();
    }
    public TiModel(ErrorTopic errorTopic, SubjectPin subject){
        this.title = subject.getPinName();
        this.anly = errorTopic.getAnlysis();
        this.score = (double)errorTopic.getScore();
        this.rightscore = (double)errorTopic.getRightScore();
        this.personal = errorTopic.getPersonalAnswer();
        this.rightAnswer = errorTopic.getRightAnswer();
    }
}
