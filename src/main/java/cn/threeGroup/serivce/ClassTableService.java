package cn.threeGroup.serivce;

import cn.threeGroup.dao.ClassTableMapper;
import cn.threeGroup.domain.ClassTable;
import cn.threeGroup.domain.ClassTableExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTableService {
    @Autowired
    private ClassTableMapper classTableMapper;
    //查看这个学生是否在这个班级表中
    public List<ClassTable> getClassTable(ClassTable classTable){
        ClassTableExample classTableExample = new ClassTableExample();
        ClassTableExample.Criteria criteria = classTableExample.createCriteria();
        criteria.andClassNameEqualTo(classTable.getClassName()).andGradeNameEqualTo(classTable.getGradeName())
                .andUserEmailEqualTo(classTable.getUserEmail());
        return classTableMapper.selectByExample(classTableExample);
    }
    //添加班级
    public int insertClassTable(ClassTable classTable){
        System.out.println("整天添加班级");
         return classTableMapper.insert(classTable);
    }

    public List<ClassTable> allClassOfGrade(String className,String gradeName){
        ClassTableExample classTableExample = new ClassTableExample();
        classTableExample.createCriteria().andGradeNameEqualTo(gradeName).andClassNameEqualTo(className);
        return classTableMapper.selectByExample(classTableExample);
    }

    //得到学生的emiail
    public List<ClassTable> getStudentEmail(ClassTable classTable){
        ClassTableExample classTableExample = new ClassTableExample();
        ClassTableExample.Criteria criteria = classTableExample.createCriteria();
        criteria.andGradeNameEqualTo(classTable.getGradeName()).andClassNameEqualTo(classTable.getClassName());
        return classTableMapper.selectByExample(classTableExample);
    }

    public List<String> allGradeName(){
        return classTableMapper.allGradeName();
    }
    public List<String> allClassName(String gradeName){
        return classTableMapper.allClassName(gradeName);
    }
}
