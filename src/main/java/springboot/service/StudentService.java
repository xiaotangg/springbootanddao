package springboot.service;

import springboot.dao.db1.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getAllStudents();

    public void deleteStudent();
}
