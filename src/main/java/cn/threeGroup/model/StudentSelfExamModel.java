package cn.threeGroup.model;

import cn.threeGroup.model.TiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSelfExamModel {
    private float score;
    private List<TiModel> dan;
    private List<TiModel> duo;
    private List<TiModel> tian;
    private List<TiModel> zhu;

}
