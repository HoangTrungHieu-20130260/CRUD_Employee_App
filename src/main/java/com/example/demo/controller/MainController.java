package com.example.demo.controller;

import com.example.demo.entity.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class MainController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("")
    public String first() {
        return "redirect:index";
    }
    @GetMapping("/index")
    public String getIndexAndSaveEntity(Model model) {
        model.addAttribute("employeeList", employeeService.getAll());
        return "index";
    }
    @GetMapping("/addEmp")
    public String getAddImp(Model model) {
        Employee employee = new Employee();
        model.addAttribute("empAdd", employee);
        return "addEmp";
    }
    @PostMapping("/empAdd")
    public String empAdd(@ModelAttribute("empAdd") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:index";
    }
    @GetMapping("/employee/edit/{id}")
    public String editEmp(@PathVariable long id, Model model) {
        model.addAttribute("employee", employeeService.getByID(id));
        return "edit";
    }
    @PostMapping("/employee/{id}")
    public String updateEmployee(@PathVariable long id, @ModelAttribute("employee") Employee employee, Model model) {
        Employee employee1 = employeeService.getByID(id);
        employee1.setName(employee.getName());
        employeeService.updateEmp(employee1);
        return "redirect:/index";
    }
    @GetMapping("/employee/delete/{id}")
    public String deleteEmp(@PathVariable long id, Model model) {
        employeeService.deleteEmp(id);
        return "redirect:/index";
    }
}
