package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseTeacherModel {
    private String useremail;
    private String username;
    private String jobTitle;
    private int userType;
}
