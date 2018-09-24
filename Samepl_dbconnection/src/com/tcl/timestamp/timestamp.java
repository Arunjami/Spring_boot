package com.tcl.timestamp;

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class timestamp {
    public static void main(String[] args) {
        long epoch = System.currentTimeMillis();
        Date date = new Date(epoch);
        long epoch2=1537421711707L;
        Date date1=new Date(epoch2);
        ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
        long epochInMillis = utc.toEpochSecond() * 1000;
        System.out.println("Epoch : " + epoch+" Epoch2 : " + epoch2+" Date: "+date+" Utc:"+epochInMillis);
        long milliseconds = date.getTime() - date1.getTime();
        int seconds = (int) milliseconds / 1000;

        // calculate hours minutes and seconds
        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        seconds = (seconds % 3600) % 60;
        System.out.println("Difference: ");
        System.out.println(" Hours: " + hours);
        System.out.println(" Minutes: " + minutes);
        System.out.println(" Seconds: " + seconds);


    }
}
