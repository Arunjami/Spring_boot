package com.tcl.example;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
@Controller
public class login_controller {
    @RequestMapping("/form")
    public String form(){
        return"form";
    }
    @RequestMapping(value="/save", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute User_details user){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("User_display");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
