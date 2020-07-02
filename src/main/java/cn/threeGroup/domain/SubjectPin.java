package cn.threeGroup.domain;

public class SubjectPin {
    private Long pinId;

    private String pinName;

    private String pinType;

    private String pinKnowledge;

    private String pinAnswer;

    private String pinAnly;

    private Double pinScore;

    private Long pinDifficult;

    private Integer pinOption;

    public Long getPinId() {
        return pinId;
    }

    public void setPinId(Long pinId) {
        this.pinId = pinId;
    }

    public String getPinName() {
        return pinName;
    }

    public void setPinName(String pinName) {
        this.pinName = pinName == null ? null : pinName.trim();
    }

    public String getPinType() {
        return pinType;
    }

    public void setPinType(String pinType) {
        this.pinType = pinType == null ? null : pinType.trim();
    }

    public String getPinKnowledge() {
        return pinKnowledge;
    }

    public void setPinKnowledge(String pinKnowledge) {
        this.pinKnowledge = pinKnowledge == null ? null : pinKnowledge.trim();
    }

    public String getPinAnswer() {
        return pinAnswer;
    }

    public void setPinAnswer(String pinAnswer) {
        this.pinAnswer = pinAnswer == null ? null : pinAnswer.trim();
    }

    public String getPinAnly() {
        return pinAnly;
    }

    public void setPinAnly(String pinAnly) {
        this.pinAnly = pinAnly == null ? null : pinAnly.trim();
    }

    public Double getPinScore() {
        return pinScore;
    }

    public void setPinScore(Double pinScore) {
        this.pinScore = pinScore;
    }

    public Long getPinDifficult() {
        return pinDifficult;
    }

    public void setPinDifficult(Long pinDifficult) {
        this.pinDifficult = pinDifficult;
    }

    public Integer getPinOption() {
        return pinOption;
    }

    public void setPinOption(Integer pinOption) {
        this.pinOption = pinOption;
    }
}