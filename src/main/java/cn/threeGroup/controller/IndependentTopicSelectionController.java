package cn.threeGroup.controller;

import cn.threeGroup.Utils.ResultMsg;
import cn.threeGroup.Utils.TableResultMsg;
import cn.threeGroup.domain.Subject;
import cn.threeGroup.model.TeacherPersonalWaitModel;
import cn.threeGroup.serivce.IndependentTopicSelectionSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("IndependentTopicSelection")
public class IndependentTopicSelectionController {
    @Autowired
    private IndependentTopicSelectionSerivce independentTopicSelectionSerivce;

    @ResponseBody
    @RequestMapping(value = "showDan" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public TableResultMsg showDan(Integer page ,Integer limit){
        System.out.println("showDan方法的入参：page="+page+" limit="+limit);
        TableResultMsg res= new TableResultMsg();
        try {
            res=independentTopicSelectionSerivce.showDan(page,limit);
            res.setCode(0);
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res.setCode(1);
            res.setMsg(errorInfo);
        }finally {
            //出参日志
            System.out.println("showDan方法的出参："+res);
            return res;
        }
    }
    @ResponseBody
    @RequestMapping(value = "showDuo" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public TableResultMsg showDuo(Integer page ,Integer limit){
        System.out.println("showDuo方法的入参：page="+page+" limit="+limit);
        TableResultMsg res= new TableResultMsg();
        try {
            res=independentTopicSelectionSerivce.showDuo(page,limit);
            res.setCode(0);
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res.setCode(1);
            res.setMsg(errorInfo);
        }finally {
            //出参日志
            System.out.println("showDuo方法的出参："+res);
            return res;
        }
    }
    @ResponseBody
    @RequestMapping(value = "showTian" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public TableResultMsg showTian(Integer page ,Integer limit){
        System.out.println("showTian方法的入参：page="+page+" limit="+limit);
        TableResultMsg res= new TableResultMsg();
        try {
            res=independentTopicSelectionSerivce.showTian(page,limit);
            res.setCode(0);
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res.setCode(1);
            res.setMsg(errorInfo);
        }finally {
            //出参日志
            System.out.println("showTian方法的出参："+res);
            return res;
        }
    }
    @ResponseBody
    @RequestMapping(value = "showZhu" ,method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    public TableResultMsg showZhu(Integer page ,Integer limit){
        System.out.println("showZhu方法的入参：page="+page+" limit="+limit);
        TableResultMsg res= new TableResultMsg();
        try {
            res=independentTopicSelectionSerivce.showZhu(page,limit);
            res.setCode(0);
        }catch (Exception e){
            String errorInfo=e.getMessage();
            res.setCode(1);
            res.setMsg(errorInfo);
        }finally {
            //出参日志
            System.out.println("showZhu方法的出参："+res);
            return res;
        }
    }

}
