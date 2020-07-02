package cn.threeGroup.model;

import lombok.Data;

/**
 * @author Mzh
 * @date 2020-05-28 20:17
 * @description:
 * @version:
 */
@Data
public class TeacherJudgeModel {

    private String question_name;
    private String type;
    private String knowledge;
    private String right_answer;
    private String personal_answer;
    private String analysis;
    private Long id;
    private String stuId;
    private Float rightScore;

    public TeacherJudgeModel(String question_name, String type, String knowledge, String right_answer, String personal_answer, String analysis, Long id, String stuId, Float rightScore) {
        this.question_name = question_name;
        this.type = type;
        this.knowledge = knowledge;
        this.right_answer = right_answer;
        this.personal_answer = personal_answer;
        this.analysis = analysis;
        this.id = id;
        this.stuId = stuId;
        this.rightScore = rightScore;
    }

    public TeacherJudgeModel() {
    }

}
