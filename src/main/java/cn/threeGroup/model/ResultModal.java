package cn.threeGroup.model;

/**
 * @author Mzh
 * @date 2020-05-28 14:21
 * @description:
 * @version:
 */

public class ResultModal<T> {
    private String code="200";
    private String massage="成功";
    private T data;

    public ResultModal(String code, String massage, T data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public ResultModal() {
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
