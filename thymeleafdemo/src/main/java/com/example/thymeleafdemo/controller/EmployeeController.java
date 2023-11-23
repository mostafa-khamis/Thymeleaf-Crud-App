package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.entity.Employee;
import com.example.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private EmployeeService employeeServices;

    public EmployeeController(EmployeeService employeeServices) {
        this.employeeServices = employeeServices;
    }
@GetMapping("/list")
    public String listEmployees(Model model){
        List<Employee> employeeList = employeeServices.findAll();
        model.addAttribute("employees",employeeList);
        return "employees/employees-list";
    }

    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        Employee employee =employeeServices.findById(id);
        model.addAttribute("employee",employee);
        return "employees/employee-form";
    }
    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee){
        employeeServices.save(employee);
        return "redirect:/employees/list";
    }
    @GetMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam("employeeId") int id){
        employeeServices.deleteById(id);
        return "redirect:/employees/list";
    }
}
