package cn.threeGroup.model;

import java.util.ArrayList;

/**
 * @author Mzh
 * @date 2020-05-28 22:06
 * @description:
 * @version:
 */

public class StudentErrorSelectModel {
    private String single_type;
    private String question_error_node;
    private String question_content;
    private ArrayList<String> options;
    private String question_answer;
    private String my_answer;
    private String question_analysis;

    public StudentErrorSelectModel(String single_type, String question_error_node, String question_content, ArrayList<String> options, String question_answer, String my_answer, String question_analysis) {
        this.single_type = single_type;
        this.question_error_node = question_error_node;
        this.question_content = question_content;
        this.options = options;
        this.question_answer = question_answer;
        this.my_answer = my_answer;
        this.question_analysis = question_analysis;
    }

    public StudentErrorSelectModel(ArrayList<String> options) {
        this.options = options;
    }

    public StudentErrorSelectModel() {
    }

    public ArrayList<String> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<String> options) {
        this.options = options;
    }
}
