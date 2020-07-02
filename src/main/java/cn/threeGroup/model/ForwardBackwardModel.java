package cn.threeGroup.model;

/**
 * @author Mzh
 * @date 2020-05-29 08:41
 * @description:
 * @version:
 */

public class ForwardBackwardModel {
    private int student_id;
    private String student_name;
    private String score_current;
    private String score_last;
    private String forward_backward;

    public ForwardBackwardModel(int student_id, String student_name, String score_current, String score_last, String forward_backward) {
        this.student_id = student_id;
        this.student_name = student_name;
        this.score_current = score_current;
        this.score_last = score_last;
        this.forward_backward = forward_backward;
    }
}
