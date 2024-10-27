package com.luv2code.springboot.cruddemo.controller;

import com.luv2code.springboot.cruddemo.entity.Employee;
import com.luv2code.springboot.cruddemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {

        List<Employee> employees = employeeService.findAll();

        model.addAttribute("employees", employees);

        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showForm(Model model) {

        model.addAttribute("employee", new Employee());

        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showForm(@RequestParam("employeeId") int id, Model model) {

        Employee theEmployee = employeeService.findById(id);

        model.addAttribute("employee", theEmployee);

        return "employees/employee-form";
    }



    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {

        employeeService.save(employee);

        return "redirect:/employees/list";
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id, Employee employee) {

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }
}
