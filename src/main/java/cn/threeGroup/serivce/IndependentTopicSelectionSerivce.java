package cn.threeGroup.serivce;

import cn.threeGroup.Utils.TableResultMsg;
import cn.threeGroup.dao.SubjectMapper;
import cn.threeGroup.dao.SubjectPinMapper;
import cn.threeGroup.domain.Subject;
import cn.threeGroup.domain.SubjectExample;
import cn.threeGroup.domain.SubjectPin;
import cn.threeGroup.domain.SubjectPinExample;
import cn.threeGroup.serivce.Inte.IndependentTopicSelectionInte;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IndependentTopicSelectionSerivce {
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private SubjectPinMapper subjectPinMapper;

    //显示单选
    public  TableResultMsg showDan(Integer page ,Integer limit){
        //获取页数
        Page<Object> pages = PageHelper.startPage(page,limit);
        SubjectExample dan=new SubjectExample();
        dan.createCriteria().andCourseTypeCodeEqualTo("1");
        List<Subject> s= subjectMapper.selectByExample(dan);
        Long count=pages.getTotal();
        TableResultMsg t=new TableResultMsg(count,s);
        return t;
    }
    //显示多选
    public  TableResultMsg showDuo(Integer page ,Integer limit){
        //获取页数
        Page<Object> pages = PageHelper.startPage(page,limit);
        SubjectExample duo=new SubjectExample();
        duo.createCriteria().andCourseTypeCodeEqualTo("2");
        List<Subject> s= subjectMapper.selectByExample(duo);
        Long count=pages.getTotal();
        TableResultMsg t=new TableResultMsg(count,s);
        return t;
    }
    //显示填空
    public  TableResultMsg showTian(Integer page ,Integer limit){
        //获取页数
        Page<Object> pages = PageHelper.startPage(page,limit);
        SubjectPinExample tain=new SubjectPinExample();
        tain.createCriteria().andPinOptionEqualTo(1);
        List<SubjectPin> s= subjectPinMapper.selectByExample(tain);
        Long count=pages.getTotal();
        TableResultMsg t=new TableResultMsg(count,s);
        return t;
    }
    //显示主观
    public  TableResultMsg showZhu(Integer page ,Integer limit){
        //获取页数
        Page<Object> pages = PageHelper.startPage(page,limit);
        SubjectPinExample tain=new SubjectPinExample();
        tain.createCriteria().andPinOptionEqualTo(2);
        List<SubjectPin> s= subjectPinMapper.selectByExample(tain);
        Long count=pages.getTotal();
        TableResultMsg t=new TableResultMsg(count,s);
        return t;
    }
}
