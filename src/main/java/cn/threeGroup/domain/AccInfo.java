package cn.threeGroup.domain;


public class AccInfo {
    private String useremail;

    private String asname;

    private Integer identity;

    private String password;

    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public String getAsname() {
        return asname;
    }

    public void setAsname(String asname) {
        this.asname = asname == null ? null : asname.trim();
    }

    public Integer getIdentity() {
        return identity;
    }

    public void setIdentity(Integer identity) {
        this.identity = identity;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}