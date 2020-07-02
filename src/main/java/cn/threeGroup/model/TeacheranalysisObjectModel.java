package cn.threeGroup.model;

/**
 * @author Mzh
 * @date 2020-05-29 08:10
 * @description:
 * @version:
 */

public class TeacheranalysisObjectModel {
    private String object_type;
    private String question_error_node;
    private String question_content;
    private String question_answer;
    private String error_rate;
    private String question_analysis;

    public TeacheranalysisObjectModel(String object_type, String question_error_node, String question_content, String question_answer, String error_rate, String question_analysis) {
        this.object_type = object_type;
        this.question_error_node = question_error_node;
        this.question_content = question_content;
        this.question_answer = question_answer;
        this.error_rate = error_rate;
        this.question_analysis = question_analysis;
    }
}
