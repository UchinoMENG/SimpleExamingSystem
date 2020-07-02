package cn.threeGroup.controller;

import com.google.gson.Gson;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BaseController {
    private Gson gson = new Gson();
    public String json(Object object){
        return gson.toJson(object);
    }
    private static Map<String ,String> tokenMap= new ConcurrentHashMap<>();
    public static Map<String,String> getTokenMap(){
        return tokenMap;
    }
    public static   void add(String useremail, String token){
        tokenMap.put(token,useremail);
    }
    public static String getUseremail(HttpServletRequest req){
        return tokenMap.get(req.getHeader("token"));
    }

    public static void checkToken(HttpServletRequest token)  throws Exception{
        if(!tokenMap.containsKey(token.getHeader("token"))){
            throw new Exception("token不存在");
        }
    }
}
