package cn.threeGroup.helpper;

public class CheckParam {
    public static void chekcParam(String email, String password) throws Exception{
        checkUseremail(email);
        checkPassword(password);
    }
    public static void checkUseremail(String email) throws Exception{
        if(email.length()<6||email.length()>16){
            throw new Exception("邮箱长度不符合要求");
        }
    }
    public static void checkPassword(String password) throws Exception{
        if(password.length()<6||password.length()>16){
            throw new Exception("密码长度不符合要求");
        }
    }
    public static  void checkTeacherJudge(String token,int testId,int courseCode) throws Exception {
        if(token.length()<6||token.length()>16){
            throw new Exception("长度不合要求");
        }
        if(testId<0||testId>16){
            throw new Exception("密码长度不合要求");
        }
        if(courseCode<1||courseCode>16){
            throw new Exception("科目长度不合要求");
        }
    }

    public static  void checkStudntError(String token,int testId,int courseCode) throws Exception {
        if(token.length()<6||token.length()>16){
            throw new Exception("长度不合要求");
        }
        if(testId<0||testId>16){
            throw new Exception("密码长度不合要求");
        }
        if(courseCode<1||courseCode>16){
            throw new Exception("科目长度不合要求");
        }
    }

    public static  void checkFind(int courseCode,String per) throws Exception {
        if(per.length()<6||per.length()>16){
            throw new Exception("问题长度不合要求");
        }

        if(courseCode<1||courseCode>16){
            throw new Exception("科目长度不合要求");
        }
    }
}
