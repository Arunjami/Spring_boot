package com.tcl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hello{
    @RequestMapping("/hello")
    public String hello(){
        return"Hello!h2 demo app the form app";
    }
}