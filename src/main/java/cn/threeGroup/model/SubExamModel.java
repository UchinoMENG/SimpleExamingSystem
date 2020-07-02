package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SubExamModel {
    private String subject;     //科目
    private String random_dan;  //单选提开关
    private int random_dan_num;     //单选题的个数
    private int random_dan_sum;     //单选题的总分数
    private String random_duo;//多选题开关
    private int random_duo_num;//多选题的个数
    private int random_duo_sum; //多选题总分数
    private String random_tian;
    private int random_tian_num;
    private int random_tian_sum;
    private String random_zhu;
    private int random_zhu_num;
    private int random_zhu_sum;
    private String random_zhu_sum_on;
    private String random_title;
    private int randomDanDifficultNum;
    private int randomDanMiddleNum;
    private int randomDanSimpleNum;
    private int randomDuoDifficultNum;
    private int randomDuoMiddleNum;
    private int randomDuoSimpleNum;
    private int randomTianDifficultNum;
    private int randomTianMiddleNum;
    private int randomTianSimpleNum;
    private int randomZhuDifficultNum;
    private int randomZhuMiddleNum;
    private int randomZhuSimpleNum;
}
