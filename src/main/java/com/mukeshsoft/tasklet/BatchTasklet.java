package com.mukeshsoft.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mukeshsoft.service.UserService;
@Service
public class BatchTasklet implements Tasklet {
@Autowired
private UserService userService;
	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println(chunkContext.getStepContext().getJobParameters().get("jobName").toString());
		userService.getAllUsers();
		Thread.sleep(5000);
		return RepeatStatus.FINISHED;
	}

}
