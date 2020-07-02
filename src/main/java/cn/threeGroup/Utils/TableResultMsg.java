package cn.threeGroup.Utils;

public class TableResultMsg {
    private Integer code=0 ;
    private String msg="";
    private long count;
    private Object data;

    public TableResultMsg() {
    }

    public TableResultMsg(Object data) {
        super();
        this.data = data;
    }

    public TableResultMsg(long count, Object data){
        super();
        this.count = count;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "TableResultMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", count=" + count +
                ", data=" + data +
                '}';
    }
}
