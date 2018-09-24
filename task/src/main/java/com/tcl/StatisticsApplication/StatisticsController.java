package com.tcl.StatisticsApplication;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class StatisticsController {
    //assigning the statistics controller with the transaction manager
    @Autowired
    Transactionmanager transactionService;

    //mapping the controller to the /statistics path with GET request mode
    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public Map statistics(){
        //Get the value from the list and and return the list
        Map<String, Number> statistic =  transactionService.getStatistics();
     //   String statistic=transactionService.getsample();
        return statistic;
    }
}