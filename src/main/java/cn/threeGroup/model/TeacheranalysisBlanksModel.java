package cn.threeGroup.model;

import java.util.ArrayList;

/**
 * @author Mzh
 * @date 2020-05-29 08:10
 * @description:
 * @version:
 */

public class TeacheranalysisBlanksModel {
    private String blanks_type;
    private String question_error_node;
    private String question_content;
    private int blanks;
    private String question_answer;
    private String error_rate;
    private String question_analysis;

    public TeacheranalysisBlanksModel(String blanks_type, String question_error_node, String question_content, int blanks, String question_answer, String error_rate, String question_analysis) {
        this.blanks_type = blanks_type;
        this.question_error_node = question_error_node;
        this.question_content = question_content;
        this.blanks = blanks;
        this.question_answer = question_answer;
        this.error_rate = error_rate;
        this.question_analysis = question_analysis;
    }
}
