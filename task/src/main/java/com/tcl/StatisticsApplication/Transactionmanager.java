package com.tcl.StatisticsApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
//@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)
public class Transactionmanager {
    // List to store the transaction in a list
    List<Transaction> transactionsList = new ArrayList();
    // assigning the sixty second gap for the requirement
   private static final Long Sixty_seconds =  60 * 1000l;
    //Method called in the Transaction controller to add transaction in list
   //@Transactional(propagation = Propagation.REQUIRED,readOnly = false) tried transaction
    public Transaction add(Transaction transaction){
        transaction.setAmount(Math.round(transaction.getAmount() * 100.0) / 100.0) ;
        transactionsList.add(transaction);
        return transaction;
    }

    // Temporary method to display the list count
    public String getsample()
    {
        int count=0;
        count=transactionsList.size();
        return new Integer(count).toString();
    }


    public Map<String, Number> getStatistics(){
        long epoch = System.currentTimeMillis();
        Map statistics = new HashMap<String, Number>();
        Double sum = transactionsList.stream().filter(transaction -> transaction.getTimestamp()>epoch-Sixty_seconds).mapToDouble(transaction -> transaction.getAmount()).sum();
        OptionalDouble average = transactionsList.stream().filter(transaction -> transaction.getTimestamp()>epoch-Sixty_seconds).mapToDouble(transaction -> transaction.getAmount()).average();
        OptionalDouble max = transactionsList.stream().filter(transaction -> transaction.getTimestamp()>epoch-Sixty_seconds).mapToDouble(transaction -> transaction.getAmount()).max();
        OptionalDouble min = transactionsList.stream().filter(transaction -> transaction.getTimestamp()>epoch-Sixty_seconds).mapToDouble(transaction -> transaction.getAmount()).min();
        Integer count = Math.toIntExact(transactionsList.stream().filter(transaction -> transaction.getTimestamp() > epoch - Sixty_seconds).count());
        statistics.put("total", sum);
        statistics.put("average", average.isPresent() ? average.getAsDouble() : 0.0);
        statistics.put("max", max.isPresent() ? max.getAsDouble(): 0.0);
        statistics.put("min", min.isPresent() ? min.getAsDouble() : 0.0);
        statistics.put("count", count);
        return  statistics;
    }



}
