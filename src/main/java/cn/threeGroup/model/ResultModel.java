package cn.threeGroup.model;

public class ResultModel <T>{
    private  String code = "200";
    private String message = "成功";
    private T data;

    public ResultModel(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public ResultModel() {
    }

    public String getCode() {
        return code;
    }

    public  void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
