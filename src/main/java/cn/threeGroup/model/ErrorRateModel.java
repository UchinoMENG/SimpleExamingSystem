package cn.threeGroup.model;

/**
 * @author Mzh
 * @date 2020-05-29 08:27
 * @description:
 * @version:
 */

public class ErrorRateModel {
    private String course_type_code;
    private String question_type;
    private String question_error_node;
    private String question_content;
    private String error_rate;

    public ErrorRateModel(String course_type_code, String question_type, String question_error_node, String question_content, String error_rate) {
        this.course_type_code = course_type_code;
        this.question_type = question_type;
        this.question_error_node = question_error_node;
        this.question_content = question_content;
        this.error_rate = error_rate;
    }
}
