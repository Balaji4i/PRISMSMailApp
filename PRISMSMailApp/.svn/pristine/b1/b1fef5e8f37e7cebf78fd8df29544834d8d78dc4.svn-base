/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jobs;

import com.jobs.SendMail;
import com.reports.SyncReceiptAccount;
import org.quartz.CronExpression;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

/**
 *
 * @author Ibrahim
 */
public class JobScheduler {

   
   
    
    public void DueDateTrigger(Boolean stop) {
        try {
            JobDetail jb = JobBuilder.newJob(DueDateMail.class)
                    .withIdentity("jb", "gp").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "gp")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 5 ? * * *"))
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0,15,30,45 14,15,16 ? * * *"))
                    .build();

            Scheduler scheduler1 = new StdSchedulerFactory().getScheduler();
            if (stop) {
                scheduler1.shutdown();
            }
            scheduler1.start();
            scheduler1.scheduleJob(jb, trigger1); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
