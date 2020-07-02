package cn.threeGroup.domain;

import cn.threeGroup.model.BaseTeacherModel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
public class UserInfo {
    private String useremail;

    private Long id;

    private Date createTime;

    private Date updateTime;

    private Integer deleteStatus;

    private Date deleteTime;

    private String password;

    private Integer userType;

    private String username;
    public UserInfo(BaseTeacherModel  baseTeacherModel){
        this.username = baseTeacherModel.getUsername();
        this.useremail = baseTeacherModel.getUseremail();
        this.createTime = new Timestamp(System.currentTimeMillis());
        this.deleteStatus = 0;
        this.password = baseTeacherModel.getUseremail();
        this.userType = baseTeacherModel.getUserType();
    }
    public String getUseremail() {
        return useremail;
    }

    public void setUseremail(String useremail) {
        this.useremail = useremail == null ? null : useremail.trim();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Integer getUserType() {
        return userType;
    }

    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}