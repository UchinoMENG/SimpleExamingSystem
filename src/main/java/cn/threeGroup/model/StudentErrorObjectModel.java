package cn.threeGroup.model;

/**
 * @author Mzh
 * @date 2020-05-28 23:18
 * @description:
 * @version:
 */

public class StudentErrorObjectModel {
    private String object_type;
    private String question_error_node;
    private String question_content;
    private String question_answer;
    private String my_answer;
    private String question_analysis;

    public StudentErrorObjectModel(String object_type, String question_error_node, String question_content, String question_answer, String my_answer, String question_analysis) {
        this.object_type = object_type;
        this.question_error_node = question_error_node;
        this.question_content = question_content;
        this.question_answer = question_answer;
        this.my_answer = my_answer;
        this.question_analysis = question_analysis;
    }

    public StudentErrorObjectModel() {
    }
}
