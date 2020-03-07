package springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import springboot.dao.db1.Student;
import springboot.service.StudentService;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootanddaoApplicationTests {
    @Autowired
    private StudentService studentService;


    @Test
    public void testGetStudents(){
        List<Student> allStudents = studentService.getAllStudents();
        for (Student student:allStudents) {
            System.out.println(student);
        }
    }


    @Test
    public void testDeleteStudents(){
       studentService.deleteStudent();
    }
}
