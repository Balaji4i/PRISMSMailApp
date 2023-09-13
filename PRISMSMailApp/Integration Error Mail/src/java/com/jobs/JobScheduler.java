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

    public void interfaceErrorTrigger(Boolean stop) {
        try {
            JobDetail jb = JobBuilder.newJob(SendMail.class)
                    .withIdentity("jb", "gp").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "gp")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 6,12 ? * * *"))
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
    
   public void receiptAccountingTrigger(Boolean stop) {
        try {
            
            JobDetail receiptJob = JobBuilder.newJob(SyncReceiptAccount.class)
                    .withIdentity("ReceiptJob", "ReceiptGrp").build();

            Trigger receiptTrigger = TriggerBuilder.newTrigger()
                    .withIdentity("ReceiptTrigger", "receiptGrp")
//                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(120).repeatForever())
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInHours(1).repeatForever())
                    .build(); 
            
            Scheduler receiptScheduler = new StdSchedulerFactory().getScheduler();
            if (stop) {
                receiptScheduler.shutdown();
            }
            receiptScheduler.start();
            receiptScheduler.scheduleJob(receiptJob, receiptTrigger); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
   public void pdcDueMailTrigger(Boolean stop) {
        try {
            JobDetail jbPdc = JobBuilder.newJob(PdcDueMail.class)
                    .withIdentity("jbPdc", "gpPdc").build();

            Trigger triggerPdc = TriggerBuilder.newTrigger()
                    .withIdentity("cronTriggerPdc", "gpPdc")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 6 ? * * *"))
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0,15,30,45 14,15,16 ? * * *"))
                    .build();


            Scheduler schedulerPdc = new StdSchedulerFactory().getScheduler();
            if (stop) {
                schedulerPdc.shutdown();
            }
            schedulerPdc.start();
            schedulerPdc.scheduleJob(jbPdc, triggerPdc); 

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
    public void ARDueDateTrigger(Boolean stop) {
        try {
            JobDetail jb = JobBuilder.newJob(ARDueDateMail.class)
                    .withIdentity("jb", "gp").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "gp")
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 4 ? * SUN *"))
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 18 ? * * *"))
//                      .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * 1/1 * ? *"))
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
    
    
    public void DueDateTrigger(Boolean stop) {
        try {
            JobDetail jb = JobBuilder.newJob(DueDateMail.class)
                    .withIdentity("jb", "gp").build();

            Trigger trigger1 = TriggerBuilder.newTrigger()
                    .withIdentity("cronTrigger1", "gp")
//                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 5 ? * * *"))
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 0 19 ? * * *"))
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
