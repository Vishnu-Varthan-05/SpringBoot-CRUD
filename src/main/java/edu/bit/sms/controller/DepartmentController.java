package edu.bit.sms.controller;

import edu.bit.sms.entity.Department;
import edu.bit.sms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id){
        return departmentService.getDepartmentById(id);
    }

    @PostMapping
    public Department addDepartment(@RequestBody Department department){
        return departmentService.createDepartment(department);
    }

    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department department){
        Department existingDepartment = departmentService.getDepartmentById(id);
        if (existingDepartment != null){
            existingDepartment.setName(department.getName());
            return departmentService.updateDepartment(existingDepartment);
        }else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentService.deleteDepartment(id);
    }
}
