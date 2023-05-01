package com.geekster.UniversityEventManagement.Controller;

import com.geekster.UniversityEventManagement.Model.Department;
import com.geekster.UniversityEventManagement.Model.Student;
import com.geekster.UniversityEventManagement.Service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public String addStudent(@Valid @RequestBody List<Student> list){
        return studentService.addStudent(list);
    }

    @GetMapping("/")
    public Iterable<Student> getAll(){
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable Integer id){
        return studentService.getById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id){
        studentService.deleteById(id);
    }

    @PutMapping("/department/{department}/id/{id}")
    public void updateStudentDepartment(@PathVariable String department, @PathVariable Integer id){
        studentService.updateDepartmentById(Department.valueOf(department), id);
    }
}