package com.mukeshsoft.controller;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/batch")
public class BatchController {
private JobLauncher launcher;
@Qualifier("manualJob")
private Job job;
@Autowired
public BatchController(JobLauncher launcher, Job job) {
	super();
	this.launcher = launcher;
	this.job = job;
}

@GetMapping("/{jobName}")
public void executeBatch(@PathVariable String jobName)
{
	JobParameters jobParameters=new JobParametersBuilder().addString("jobName", jobName).addLong("time", System.currentTimeMillis()).toJobParameters();
	try {
		launcher.run(job, jobParameters).getExitStatus().getExitCode();
	} catch (JobExecutionAlreadyRunningException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JobRestartException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JobInstanceAlreadyCompleteException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (JobParametersInvalidException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
