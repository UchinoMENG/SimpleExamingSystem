package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Mzh
 * @date 2020-05-29 08:10
 * @description:
 * @version:
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherAnalysisSubjectPinModel {
    private String object_type;
    private Long question_node;
    private String question_content;
    private String question_answer;
    private List<String> error_people;
    private String analysis;

}
