package cn.threeGroup.Utils;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
@Component
public class ResultMsg {
    private Boolean flag;
    private String msg;
    private Map<String,Object> map = new HashMap<>();
    public static ResultMsg success(){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.flag=true;
        resultMsg.msg = "处理成功";
        return resultMsg;
    }
    public static ResultMsg failed(){
        ResultMsg resultMsg = new ResultMsg();
        resultMsg.flag=false;
        resultMsg.msg = "处理失败";
        return resultMsg;
    }
    public ResultMsg add(String name,Object value){
        map.put(name,value);
        return this;
    }
    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }

    @Override
    public String toString() {
        return "ResultMsg{" +
                "flag=" + flag +
                ", msg='" + msg + '\'' +
                ", map=" + map +
                '}';
    }
}
