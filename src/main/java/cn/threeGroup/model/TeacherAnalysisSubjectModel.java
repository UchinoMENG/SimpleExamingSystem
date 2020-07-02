package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mzh
 * @date 2020-05-29 08:09
 * @description:
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherAnalysisSubjectModel {
    private String single_type;
    private Long question_node;
    private String question_content;
    private List<String> options;
    private List<String> answer;
    private List<String> error_people;
    private String analysis;

}
