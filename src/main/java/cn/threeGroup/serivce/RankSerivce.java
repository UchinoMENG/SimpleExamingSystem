package cn.threeGroup.serivce;

import cn.threeGroup.model.RankClassModel;
import cn.threeGroup.model.RankYearModel;
import cn.threeGroup.Utils.TableResultMsg;
import cn.threeGroup.dao.HistoryExamMapper;
import cn.threeGroup.dao.UserInfoMapper;
import cn.threeGroup.domain.*;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RankSerivce {

    @Autowired
    private HistoryExamMapper historyExamMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;

    public List<HistoryExam> getPersonalInformation(String userEmail, String history_exam){
        HistoryExamExample historyExamExample=new HistoryExamExample();
        historyExamExample.createCriteria().andStudentEmailEqualTo(userEmail).andHistoryExamEqualTo(history_exam);
        return historyExamMapper.selectByExample(historyExamExample);
    }
    public UserInfo getUsername(String userEmail){
        UserInfoExample userinfoExample=new UserInfoExample();
        userinfoExample.createCriteria().andUseremailEqualTo(userEmail);
        return userInfoMapper.selectUsernameByExample(userinfoExample);
    }
    public TableResultMsg getClass(String userEmail, String history_exam, String keyword, Integer page , Integer limit){
        System.out.println("进入时key"+keyword);
        TableResultMsg tableResultMsg=new TableResultMsg();
        //获取页数
        Page<Object> pages =PageHelper.startPage(page,limit);

        HistoryExamExample historyExamExample2=new HistoryExamExample();
        historyExamExample2.createCriteria().andStudentEmailEqualTo(userEmail);
        List<HistoryExam> h1=historyExamMapper.selectByExample(historyExamExample2);
        String grade1 = h1.get(0).getGradename();
        String class1 = h1.get(0).getClassname();
        if(keyword.equals("")){
            tableResultMsg.setData(getClassScore2(grade1,class1,history_exam));
            Long count=pages.getTotal();
            System.out.println("count:"+count);
            tableResultMsg.setCount(count);
            return tableResultMsg;
        }else{
            tableResultMsg.setData(getSearchClassScore(grade1,class1,history_exam,keyword));
            Long count=pages.getTotal();
            tableResultMsg.setCount(count);
            return tableResultMsg;
        }
    }

    public  ArrayList<RankClassModel> getClassScore2(String grade1, String class1, String history_exam){
        HistoryExamExample history_examExample2=new HistoryExamExample();
        history_examExample2.setOrderByClause("score desc");
        history_examExample2.createCriteria().andGradenameEqualTo(grade1).andClassnameEqualTo(class1).andHistoryExamEqualTo(history_exam);
        List<HistoryExam> l=historyExamMapper.selectByExample(history_examExample2);
        ArrayList<RankClassModel> mair=new ArrayList<RankClassModel>();
        int j;
        for(int i = 1;i<=l.size();i++){
            j = i;
            mair.add(new RankClassModel(l.get(i-1).getStudentEmail(),l.get(i-1).getHistoryExam(),l.get(i-1).getClassname(),l.get(i-1).getScore(),j));
            double sign = l.get(i-1).getScore();
            while(i<l.size()&&Double.doubleToLongBits(sign)==Double.doubleToLongBits(l.get(i).getScore())){
                mair.add(new RankClassModel(l.get(i-1).getStudentEmail(),l.get(i-1).getHistoryExam(),l.get(i-1).getClassname(),l.get(i-1).getScore(),j));
                i++;
            }
        }
        return mair;
    }

    public  ArrayList<RankClassModel> getSearchClassScore(String grade1,String class1, String history_exam,String keyword){
        HistoryExamExample history_examExample3=new HistoryExamExample();
        history_examExample3.setOrderByClause("score desc");
        history_examExample3.createCriteria().andGradenameEqualTo(grade1).andClassnameEqualTo(class1).andHistoryExamEqualTo(history_exam).andStudentEmailLike("%"+keyword+"%");
        List<HistoryExam> l=historyExamMapper.selectByExample(history_examExample3);
        ArrayList<RankClassModel> mair=new ArrayList<RankClassModel>();
        for(int i=1;i<=l.size();i++){
            mair.add(new RankClassModel(l.get(i-1).getStudentEmail(),l.get(i-1).getHistoryExam(),l.get(i-1).getClassname(),l.get(i-1).getScore(),i));
        }
        return mair;
    }

    //查找年级
    public TableResultMsg getClassYear(String userEmail, String history_exam, String keyword,Integer page ,Integer limit){
        TableResultMsg tableResultMsg2=new TableResultMsg();
        //获取页数
        Page<Object> pages =PageHelper.startPage(page,limit);
        Long count=pages.getTotal();
        tableResultMsg2.setCount(count);
        HistoryExamExample historyExamExample4=new HistoryExamExample();
        historyExamExample4.createCriteria().andStudentEmailEqualTo(userEmail);
        List<HistoryExam> h1=historyExamMapper.selectByExample(historyExamExample4);
        String grade1 = h1.get(0).getGradename();
        if(keyword.equals("")){
            //正常显示
            tableResultMsg2.setData(getClassScoreYear(grade1,history_exam));
            return tableResultMsg2;
        }else{
            //关键字查找
            tableResultMsg2.setData(getSearchYearScore(grade1,history_exam,keyword));
            return tableResultMsg2;
        }
    }

    public  ArrayList<RankYearModel> getClassScoreYear(String grade1, String history_exam){
        HistoryExamExample history_examExample5=new HistoryExamExample();
        history_examExample5.setOrderByClause("score desc");
        history_examExample5.createCriteria().andGradenameEqualTo(grade1).andHistoryExamEqualTo(history_exam);
        List<HistoryExam> l=historyExamMapper.selectByExample(history_examExample5);
        ArrayList<RankYearModel> mair=new ArrayList<RankYearModel>();
        int j;
        for(int i = 1;i<=l.size();i++){
            j = i;
            mair.add(new RankYearModel(l.get(i-1).getStudentEmail(),l.get(i-1).getHistoryExam(),l.get(i-1).getGradename(),l.get(i-1).getClassname(),l.get(i-1).getScore(),j));
            double sign = l.get(i-1).getScore();
            while(i<l.size()&&Double.doubleToLongBits(sign)==Double.doubleToLongBits(l.get(i).getScore())){
                mair.add(new RankYearModel(l.get(i-1).getStudentEmail(),l.get(i-1).getHistoryExam(),l.get(i).getGradename(),l.get(i-1).getClassname(),l.get(i-1).getScore(),j));
                i++;
            }
        }
        return mair;
    }
    public  ArrayList<RankYearModel> getSearchYearScore(String grade1,String history_exam,String keyword){
        HistoryExamExample history_examExample3=new HistoryExamExample();
        history_examExample3.setOrderByClause("score desc");
        history_examExample3.createCriteria().andGradenameEqualTo(grade1).andHistoryExamEqualTo(history_exam).andStudentEmailLike("%"+keyword+"%");
        List<HistoryExam> l=historyExamMapper.selectByExample(history_examExample3);
        ArrayList<RankYearModel> mair=new ArrayList<RankYearModel>();
        for(int i=1;i<=l.size();i++){
            mair.add(new RankYearModel(l.get(i-1).getStudentEmail(),l.get(i-1).getHistoryExam(),l.get(i-1).getGradename(),l.get(i-1).getClassname(),l.get(i-1).getScore(),i));
        }
        return mair;
    }
}
