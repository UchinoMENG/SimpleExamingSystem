package cn.threeGroup.domain;

import org.springframework.stereotype.Component;


public class BindInfo {
    private String useremail;

    private String userid;

    private String margin;

    private String userclass;

    private String userschool;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin == null ? null : margin.trim();
    }

    public String getUserclass() {
        return userclass;
    }

    public void setUserclass(String userclass) {
        this.userclass = userclass == null ? null : userclass.trim();
    }

    public String getUserschool() {
        return userschool;
    }

    public void setUserschool(String userschool) {
        this.userschool = userschool == null ? null : userschool.trim();
    }
}