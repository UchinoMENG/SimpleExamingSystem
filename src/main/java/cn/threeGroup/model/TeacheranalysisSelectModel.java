package cn.threeGroup.model;

import java.util.ArrayList;

/**
 * @author Mzh
 * @date 2020-05-29 08:09
 * @description:
 * @version:
 */

public class TeacheranalysisSelectModel {
    private String single_type;
    private String question_error_node;
    private String question_content;
    private ArrayList<String> options;
    private String question_answer;
    private String error_rate;
    private String question_analysis;

    public TeacheranalysisSelectModel(String single_type, String question_error_node, String question_content, ArrayList<String> options, String question_answer, String error_rate, String question_analysis) {
        this.single_type = single_type;
        this.question_error_node = question_error_node;
        this.question_content = question_content;
        this.options = options;
        this.question_answer = question_answer;
        this.error_rate = error_rate;
        this.question_analysis = question_analysis;
    }
}
