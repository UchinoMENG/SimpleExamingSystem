package cn.threeGroup.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MessageExamModel extends MessageModel {
    private String examName;
    private Timestamp timestamp;
    private int sign;
 }
