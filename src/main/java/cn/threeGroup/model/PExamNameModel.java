package cn.threeGroup.model;

public class PExamNameModel {
    private String examinationName;
    private Byte sign;

    public PExamNameModel(){
        super();
    }
    public PExamNameModel(String examinationName, Byte sign) {
        this.examinationName = examinationName;
        this.sign = sign;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    public Byte getSign() {
        return sign;
    }

    public void setSign(Byte sign) {
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "PExamNameModel{" +
                "examinationName='" + examinationName + '\'' +
                ", sign=" + sign +
                '}';
    }
}
