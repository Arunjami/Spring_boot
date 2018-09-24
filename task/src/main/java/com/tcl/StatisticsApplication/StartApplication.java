package com.tcl.StatisticsApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// A basic Spring starter application
//@EnableTransactionManagement enabling the whole application to be ransaction enables
@SpringBootApplication
public class StartApplication {
public static void main(String[] args) {
            SpringApplication.run(StartApplication.class, args);
        }

}
