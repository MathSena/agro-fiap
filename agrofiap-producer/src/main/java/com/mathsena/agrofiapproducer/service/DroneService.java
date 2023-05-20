package com.mathsena.agrofiapproducer.service;

import com.mathsena.agrofiapproducer.job.DroneSimulationJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Service;

@Service
public class DroneService {

    public void createDroneSimulation(int droneId){
        try {

            JobDetail job = JobBuilder.newJob(DroneSimulationJob.class)
                    .withIdentity("droneJob" + droneId)
                    .build();
            job.getJobDataMap().put("droneId", droneId);

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                            .withIntervalInSeconds(10)
                            .repeatForever())
                    .build();

            SchedulerFactory schFactory = new StdSchedulerFactory();
            Scheduler sch = schFactory.getScheduler();
            sch.start();
            sch.scheduleJob(job, trigger);

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}