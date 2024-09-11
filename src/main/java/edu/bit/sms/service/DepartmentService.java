package edu.bit.sms.service;

import edu.bit.sms.repository.DepartmentRepository;
import edu.bit.sms.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }
    public Department getDepartmentById(Long id){
        return departmentRepository.findById(id).orElse(null);
    }
    public Department createDepartment(Department department){
        return  departmentRepository.save(department);
    }
    public Department updateDepartment(Department department){
        return departmentRepository.save(department);
    }
    public void deleteDepartment(Long id){
        departmentRepository.deleteById(id);
    }
}

