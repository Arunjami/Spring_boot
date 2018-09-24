package com.tcl.StatisticsApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeApp {
    @RequestMapping("/hello")
    public String hello(){
        return "Hello This the task app!";
    }
}