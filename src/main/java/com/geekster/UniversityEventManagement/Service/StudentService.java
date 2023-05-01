package com.geekster.UniversityEventManagement.Service;

import com.geekster.UniversityEventManagement.Model.Department;
import com.geekster.UniversityEventManagement.Model.Student;
import com.geekster.UniversityEventManagement.Repositary.StudentDao;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentRepository;

    public String addStudent(@Valid List<Student> list) {
        Iterable<Student> studentList = studentRepository.saveAll(list);
        if (studentList != null){
            return "Student list gets added...!!!";
        }
        return "Could not added student list";
    }

    public Iterable<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getById(Integer id) {
        return studentRepository.findByStudentId(id);
    }

    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Transactional
    public void updateDepartmentById(Department department, Integer id) {
        studentRepository.updateDepartmentByStudentId(department.toString(), id);
    }
}
