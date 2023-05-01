package com.geekster.UniversityEventManagement.Repositary;

import com.geekster.UniversityEventManagement.Model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface StudentDao extends CrudRepository<Student, Integer> {
    public Student findByStudentId(Integer id);

    @Modifying
    @Query(value = "Update Student set DEPARTMENT = :department where STUDENT_ID = :id", nativeQuery = true)
    public void updateDepartmentByStudentId(String department, Integer id);
}
