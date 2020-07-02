package com.threeGroup.mybatis;

import cn.threeGroup.controller.BaseController;
import cn.threeGroup.dao.*;
import cn.threeGroup.domain.ErrorTopic;
import cn.threeGroup.domain.ErrorTopicExample;
import cn.threeGroup.domain.SubjectExample;
import cn.threeGroup.serivce.ErrorTopicService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/ApplicationContext.xml"})
public class mybatisTest extends BaseController {
    @Autowired
    private IdentityMapper identityMapper;
    @Autowired
    private SubjectPinMapper subjectPinMapper;
    @Autowired
    private SubjectMapper subjectMapper;
    @Autowired
    private ErrorTopicMapper errorTopicMapper;
    @Test
    public void test1(){
        System.out.println(identityMapper.selectByPrimaryKey(1).getIdentity());
    }
    @Test
    public void test2(){
        System.out.println(subjectPinMapper.selectByPrimaryKey(1l)==null?0:1);
    }
    @Test
    public void test3(){
        SubjectExample subjectExample = new SubjectExample();
        subjectExample.createCriteria().andSubjectDifficultlyEqualTo(1L).andSubjectTypeCodeEqualTo("语文").andCourseTypeCodeEqualTo("1");
        System.out.println(json(subjectMapper.selectByExample(subjectExample)));
        System.out.println(subjectMapper.selectByExample(subjectExample));
    }
    @Test
    public void test4(){
        ErrorTopicExample errorTopicExample = new ErrorTopicExample();
        errorTopicExample.createCriteria().andIdEqualTo(21L).andExaminationNameEqualTo("lplplplpoooppp")
                .andStudentIdEqualTo("147852369@145.com").andCourseNameEqualTo("语文");
        System.out.println(errorTopicMapper.selectByExample(errorTopicExample));
    }

    @Test
    public void test5(){
        System.out.println('1'<='2');
    }
}
