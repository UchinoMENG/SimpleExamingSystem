package cn.threeGroup.model;

public class ExamNameModel {
    private String examinationName;

    public ExamNameModel(String examinationName) {
        this.examinationName = examinationName;
    }

    public String getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String examinationName) {
        this.examinationName = examinationName;
    }

    @Override
    public String toString() {
        return "ExamNameModel{" +
                "examinationName='" + examinationName + '\'' +
                '}';
    }
    //    private Byte sign;
//
//    public ExamNameModel(String examinationName, Byte sign) {
//        this.examinationName = examinationName;
//        this.sign = sign;
//    }
//
//    public String getExaminationName() {
//        return examinationName;
//    }
//
//    public void setExaminationName(String examinationName) {
//        this.examinationName = examinationName;
//    }
//
//    public Byte getSign() {
//        return sign;
//    }
//
//    public void setSign(Byte sign) {
//        this.sign = sign;
//    }
//
//    @Override
//    public String toString() {
//        return "ExamNameModel{" +
//                "examinationName='" + examinationName + '\'' +
//                ", sign='" + sign + '\'' +
//                '}';
//    }
}
