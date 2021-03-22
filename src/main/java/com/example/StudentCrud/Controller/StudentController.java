package com.example.StudentCrud.Controller;

import com.example.StudentCrud.Domain.Student;
import com.example.StudentCrud.Service.StudentService;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService service;

    @GetMapping("/Index")
    public String viewListPage(Model model) {
        List<Student> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        System.out.print("Get /Index ");
        return "Index";
    }
    @GetMapping("/Home")
    public ModelAndView startPage(Model model){

    ModelAndView modelAndView= new ModelAndView();
    modelAndView.setViewName("Home");
        return modelAndView;
    }
    @RequestMapping(value="/trainer", method=RequestMethod.GET)
    public String Start(Model model) {
        List<Student> liststudent = service.listAll();
        model.addAttribute("liststudent", liststudent);
        return "Index";
    }
    @RequestMapping(value="/customer", method=RequestMethod.GET)
    public String Start2(Model model){


        return "Test";
    }

    @GetMapping("/CreateUser")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "CreateUser";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("student") Student std) {
        service.save(std);
        return "redirect:/Index";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("CreateUser");
        Student std = service.get(id);
        mav.addObject("student", std);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/Index";
    }
}
