package com.example.thymeleafdemo.controller;

import com.example.thymeleafdemo.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    List<Employee> employees;

    @PostConstruct
    public void loadData(){
        // create employees
        Employee e1 = new Employee(1,"ivan","draganov","draganov@gmail.com");
        Employee e2 = new Employee(2,"dushman","chukanov","chukanov@gmail.com");
        Employee e3 = new Employee(3,"petkan","krivanov","krivanov@gmail.com");

        // create list
        employees = new ArrayList<>();
        // add employees to the list
        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

    }


    @GetMapping("/list")
    public String listEmployees(Model model){

        // add to Spring MVC model
        model.addAttribute("employees",employees);

        return "list-employees";
    }
}
