package cn.threeGroup.model;

import lombok.Data;

/**
 * @author Mzh
 * @date 2020-05-28 20:52
 * @description:
 * @version:
 */
@Data
public class QuestionModel {
    private int question_node;
    private String question_name;
    private String answer_right;
    private String answer_mine;

    public QuestionModel(int question_node, String question_name, String answer_right, String answer_mine) {
        this.question_node = question_node;
        this.question_name = question_name;
        this.answer_right = answer_right;
        this.answer_mine = answer_mine;
    }
}
