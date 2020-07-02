package cn.threeGroup.check;

import cn.threeGroup.domain.PerInfo;

public class CheckPersonalHomepage {
    public static void personalInformation(PerInfo per) throws Exception {
        if(per.getUsername() ==null ||per.getUsername().equals("")){
            throw new Exception("用户姓名不正确");
        }else if(!per.getSex().equals("男")  && !per.getSex().equals("女") && per.getSex()!="" && per.getSex()!=null){
            throw new Exception("用户性别不正确");
        }
    }
}
