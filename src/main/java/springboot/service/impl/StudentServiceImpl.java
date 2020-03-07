package springboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import springboot.dao.db1.Student;
import springboot.mapper.db1.StudentMapper;
import springboot.mapper.db2.StudentSecondMapper;
import springboot.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private StudentSecondMapper studentSecondMapper;


    @Override
    public List<Student> getAllStudents() {
        List<Student> list=new ArrayList<>();
        List<Student> dbOneStudents = studentMapper.selectList(new QueryWrapper<>());
        List<Student> dbSecondStudents =studentSecondMapper.selectList(new QueryWrapper<>());
        list.addAll(dbOneStudents);
        list.addAll(dbSecondStudents);
        return   list;
    }

    @Override
    public void deleteStudent() {
        int dbOne = studentMapper.delete(new QueryWrapper<Student>().lambda().eq(Student::getSId, "05"));
        int dbSecond = studentSecondMapper.delete(new QueryWrapper<Student>().lambda().eq(Student::getSId, "09"));
        int i=1/0;

    }
}
