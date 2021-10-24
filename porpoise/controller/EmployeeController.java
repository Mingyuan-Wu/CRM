package com.seanco.porpoise.controller;

import com.seanco.porpoise.entity.Employee;
import com.seanco.porpoise.service.EmployeeService;
import com.seanco.porpoise.util.SortParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeservice;

    @RequestMapping("list")
    public String listEmployees(Model model, @RequestParam(name = "sort", required = false) Integer sort){
        List<Employee> employees = employeeservice.findAll();
        if(sort!=null && sort>=1 && sort<=3) {
            employees = employeeservice.findAllSortBy(sort);
        }
        model.addAttribute( "employees", employees);
        return "list-employee";
    }
    @GetMapping("showFormForAdd")
    public String showFormForAdd(Model model){
        Employee employee = new Employee();
        model.addAttribute("employee",employee);

        return "employee-form";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("employee")Employee employee) {
        employeeservice.updateOrInsert(employee);
        return "redirect:/employees/list";

    }

    @GetMapping("showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        Employee employee =employeeservice.findById(id);
        model.addAttribute("employee",employee);

        return "employee-form";
    }

    @GetMapping("delete")
    public  String delete(@RequestParam("employeeId") int id) {
        employeeservice.deleteById(id);
        return "redirect:/employees/list";
    }

    @GetMapping("search")
    public  String search(@RequestParam("keyword") String keyword, Model model ){
        if(keyword == null || keyword.isEmpty()) {
            return "redirect:/employees/list";
        }
        List<Employee> employees = employeeservice.search(keyword);

        model.addAttribute( "employees", employees);
        model.addAttribute( "keyword", keyword);
        return "list-employee";
    }
}
