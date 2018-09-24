package com.tcl.StatisticsApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    //sixty second interval converted into milliseconds
    private static final Long Sixty_Secounds = 5* 60 * 1000l;
    //for mapping the transaction manager with transaction controller
    @Autowired
    Transactionmanager transactionService;
    //mapping with the Transaction path ans assigning POST method
    @RequestMapping(value = "/transactions", method = RequestMethod.POST)
    public ResponseEntity<String> transaction(@RequestBody Transaction transaction){
        long epoch = System.currentTimeMillis();//function to find epoch of current time
        if(transaction.getTimestamp() < epoch - Sixty_Secounds){
            //Sending the code 204 for more than 60 seconds
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            //adding the code for transaction code into the list and returning code 201
            transactionService.add(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
    }
}
