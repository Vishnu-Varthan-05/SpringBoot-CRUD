package edu.bit.sms.service;

import edu.bit.sms.dto.StudentDTO;
import edu.bit.sms.repository.StudentRepository;
import edu.bit.sms.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents(){
        return  studentRepository.findAll();
    }
    public List<StudentDTO> getAllStudentsDTO(){
        return studentRepository.findAll().stream().map(student -> new StudentDTO(student.getId(), student.getName()))
                .collect(Collectors.toList());
    }
    public Student getStudentById(Long id){
        return  studentRepository.findById(id).orElse(null);
    }
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }
    public Student updateStudent(Student student){
        return studentRepository.save(student);
    }
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
