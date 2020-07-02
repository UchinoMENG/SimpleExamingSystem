package cn.threeGroup.model;

import cn.threeGroup.domain.Subject;
import cn.threeGroup.domain.SubjectPin;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamCommonModel {
    private int id;
    private int subjectCode;
    private int subjectCodeType;
    private int subjectPinCode;
    private int subjectPinType;
    private float score;
    private String examName;
    public ExamCommonModel(Subject res, SubExamModel subExamModel) {
        this.subjectCode = Math.toIntExact(res.getId());
        this.subjectCodeType = Integer.parseInt(res.getCourseTypeCode());
        this.subjectPinCode = 0;
        subjectPinType = 0;
        if (res.getCourseTypeCode().equals("1")) {
            score = (float) (subExamModel.getRandom_dan_sum() * 1.0 / subExamModel.getRandom_dan_num());
        } else {
            score = (float) (subExamModel.getRandom_duo_sum() * 1.0 / subExamModel.getRandom_duo_num());
        }

    }

    public ExamCommonModel(SubjectPin res, SubExamModel subExamModel) {
        this.subjectCode = 0;
        this.subjectCodeType = 0;
        this.subjectPinCode = Math.toIntExact(res.getPinId());
        subjectPinType = res.getPinOption();
        if (subjectPinType == 1) {
            score = (float) (subExamModel.getRandom_tian_sum() * 1.0 / subExamModel.getRandom_tian_num());
        } else {
            score = (float) (subExamModel.getRandom_zhu_sum() * 1.0 / subExamModel.getRandom_zhu_num());
        }
    }
    public ExamCommonModel(Subject res, Float score1, Float score2) {
        this.subjectCode = Math.toIntExact(res.getId());
        this.subjectCodeType = Integer.parseInt(res.getCourseTypeCode());
        this.subjectPinCode = 0;
        subjectPinType = 0;
        if (res.getCourseTypeCode().equals("1")) {
            score = score1;
        } else {
            score = score2;
        }
    }

    public ExamCommonModel(SubjectPin res, Float score1, Float score2) {
        this.subjectCode = 0;
        this.subjectCodeType = 0;
        this.subjectPinCode = Math.toIntExact(res.getPinId());
        subjectPinType = res.getPinOption();
        if (subjectPinType == 1) {
            score = score1;
        } else {
            score = score2;
        }
    }

}
