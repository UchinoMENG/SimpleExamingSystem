package cn.threeGroup.check;

public class CheckRank {
    public static void checkPersonalIdentity(String history_exam) throws Exception{
       if(history_exam ==null ||history_exam.equals("")){
            throw new Exception("考试id不正确");
        }
    }
    public static void checkShowGrade(String history_exam) throws Exception{
        if(history_exam ==null ||history_exam.equals("")){
            throw new Exception("考试id不正确");
        }
    }
}
