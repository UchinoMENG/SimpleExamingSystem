package cn.threeGroup.model;

import lombok.Data;

import java.util.ArrayList;

/**
 * @author Mzh
 * @date 2020-05-28 22:56
 * @description:
 * @version:
 */
@Data
public class StudentErrorBlanksModel {
    private String blanks_type;
    private String question_error_node;
    private String question_content;
    private int blanks;
    private String question_answer;
    private String my_answer;
    private String question_analysis;

    public StudentErrorBlanksModel(String blanks_type, String question_error_node, String question_content, int blanks, String question_answer, String my_answer, String question_analysis) {
        this.blanks_type = blanks_type;
        this.question_error_node = question_error_node;
        this.question_content = question_content;
        this.blanks = blanks;
        this.question_answer = question_answer;
        this.my_answer = my_answer;
        this.question_analysis = question_analysis;
    }

    public String getBlanks_type() {
        return blanks_type;
    }

    public void setBlanks_type(String blanks_type) {
        this.blanks_type = blanks_type;
    }

    public String getQuestion_error_node() {
        return question_error_node;
    }

    public void setQuestion_error_node(String question_error_node) {
        this.question_error_node = question_error_node;
    }

    public String getQuestion_content() {
        return question_content;
    }

    public void setQuestion_content(String question_content) {
        this.question_content = question_content;
    }

    public int getBlanks() {
        return blanks;
    }

    public void setBlanks(int blanks) {
        this.blanks = blanks;
    }

    public String getQuestion_answer() {
        return question_answer;
    }

    public void setQuestion_answer(String question_answer) {
        this.question_answer = question_answer;
    }

    public String getMy_answer() {
        return my_answer;
    }

    public void setMy_answer(String my_answer) {
        this.my_answer = my_answer;
    }

    public String getQuestion_analysis() {
        return question_analysis;
    }

    public void setQuestion_analysis(String question_analysis) {
        this.question_analysis = question_analysis;
    }
}
