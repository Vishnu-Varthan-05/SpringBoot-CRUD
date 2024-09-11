package edu.bit.sms.controller;

import edu.bit.sms.dto.StudentDTO;
import edu.bit.sms.entity.Department;
import edu.bit.sms.entity.Student;
import edu.bit.sms.service.DepartmentService;
import edu.bit.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/dto")
    public List<StudentDTO> getAllStudentsDTO(){
        return studentService.getAllStudentsDTO();
    }
    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentById(id);
    }

    @PostMapping
    public Student createStudent(@RequestBody Student student){
        Department existingDepartment = departmentService.getDepartmentById(student.getDepartment().getId());
        if (existingDepartment != null){
            student.setDepartment(existingDepartment);
            return studentService.createStudent(student);
        }else {
            return null;
        }
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Long id, @RequestBody Student student){
        Student existingStudent = studentService.getStudentById(id);
        Department existingDepartment = departmentService.getDepartmentById(student.getDepartment().getId());
        if (existingStudent != null && existingDepartment != null){
            existingStudent.setName(student.getName());
            existingStudent.setDepartment(existingDepartment);
            return studentService.updateStudent(existingStudent);
        }else {
            return null;
        }
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }

}
