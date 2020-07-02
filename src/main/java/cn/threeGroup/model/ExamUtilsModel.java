package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamUtilsModel {
    private int id;
    private int subjectCode;
    private int subjectCodeType;
    private int subjectPinCode;
    private int subjectPinType;
    private float score;
}
