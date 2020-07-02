package cn.threeGroup.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SubjectPinModel {
    private String title;
    private Double score;
    private Long difficult;
    private String anly;
    private String answer;
    private Integer pin_option;
    private String pin_knowledge;
    private String pin_type;
}
