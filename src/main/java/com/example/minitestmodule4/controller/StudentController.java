package com.example.minitestmodule4.controller;

import com.example.minitestmodule4.model.Student;
import com.example.minitestmodule4.service.ClassRoomService;
import com.example.minitestmodule4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @Autowired
    ClassRoomService classRoomService;

    @GetMapping("/student")
    public ModelAndView findAll(@RequestParam(defaultValue = "0") int page) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("student", studentService.findAll(PageRequest.of(page, 3)));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView createForm() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("student", new Student());
        modelAndView.addObject("classRoom", classRoomService.findAll());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView createStudent(@ModelAttribute(value = "student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }

    @GetMapping("/edit")
    public ModelAndView editForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("student", studentService.findById(id));
        modelAndView.addObject("classRoom", classRoomService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView editStudent(@ModelAttribute(value = "student") Student student) {
        studentService.save(student);
        ModelAndView modelAndView = new ModelAndView("redirect:/student");
        return modelAndView;
    }

    @GetMapping("/delete")
    public ModelAndView deleteForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("mess", studentService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteStudent(@RequestParam long id) {
        studentService.delete(id);
        return "redirect:/student";
    }

    @PostMapping("/search")
    public ModelAndView findByName(@RequestParam String name) {
        ModelAndView modelAndView = new ModelAndView("show");
        modelAndView.addObject("student", studentService.findByName(name));
        return modelAndView;
    }

    @GetMapping("/detail")
    public ModelAndView detailForm(@RequestParam long id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("student", studentService.findById(id));
        return modelAndView;
    }
}
