package cn.threeGroup.model;

/**
 * @author Mzh
 * @date 2020-06-02 22:34
 * @description:
 * @version:
 */

public class StuTestModel {
    private String examName;

    private String startTime;

    private String examTime;

    private String gradeName;

    private String className;

    private Integer did;

    private Double score;

    public StuTestModel(String examName, String startTime, String examTime, String gradeName, String className, Integer did, Double score) {
        this.examName = examName;
        this.startTime = startTime;
        this.examTime = examTime;
        this.gradeName = gradeName;
        this.className = className;
        this.did = did;
        this.score = score;
    }
}
