package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubjectDomain {
    private String choicea;
    private String choiceb;
    private String choicec;
    private String choiced;
    private Long diffcult;
    private Double score;
    private String answerA;
    private String answerB;
    private String answerC;
    private String answerD;
    private String title;
    private String rightres;
    private String useremail;
    private String type_t;
    private String type_title;
    private String course_type;
}
