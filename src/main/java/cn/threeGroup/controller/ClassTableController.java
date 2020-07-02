package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.dao.ClassTableMapper;
import cn.threeGroup.serivce.ClassTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClassTableController  extends BaseController{
    @Autowired
    private ClassTableService classTableService;

    @ResponseBody
    @RequestMapping(value = "/initGradeName",method = RequestMethod.GET)
    public ResultMsg allGradeName(){
        List<String> list = classTableService.allGradeName();
        System.out.println(json(list));
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<list.size();i++){
            map.put(list.get(i),classTableService.allClassName(list.get(i)));
            System.out.println(json(classTableService.allClassName(list.get(i))));
        }
        return ResultMsg.success().add("obj",map);
    }

}
