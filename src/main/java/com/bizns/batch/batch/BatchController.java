package com.bizns.batch.batch;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class BatchController {
//    @Autowired
//    JobLauncher jobLauncher;
//
//    @Autowired
//    Job processJob;
//
//    @RequestMapping("/invokejob")
//    public String handle() throws Exception {
//
//        JobParameters jobParameters = new JobParametersBuilder().addLong("time", System.currentTimeMillis())
//            .toJobParameters();
//        jobLauncher.run(processJob, jobParameters);
//
//        return "Batch job has been invoked";
//    }
//
//}
