package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ClassName ExamContentModel
 * @Description : 用于返回题目的Model
 *
 * @Author : mlq
 * @Date : 2020/6/2 14:57
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamContentModel {
    private String title;           //用于显示题目
    private String choice;      //sign = true用于显示题目的选项，用@分割了,sign
    private boolean chooseSign;     //用于标志
}
