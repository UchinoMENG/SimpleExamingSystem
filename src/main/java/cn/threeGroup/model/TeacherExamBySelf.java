package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeacherExamBySelf {
    private String teacher;
    private String examName;
    private Integer[] dan;
    private Integer[] duo;
    private Integer[] tian;
    private Integer[] zhu;
    private Float danzhi;
    private Float duozhi;
    private Float tianzhi;
    private Float zhuzhi;
    private String ban;
    private String nian;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String starttime;
    private String time;
}
