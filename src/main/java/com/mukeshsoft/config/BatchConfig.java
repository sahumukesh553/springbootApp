package com.mukeshsoft.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mukeshsoft.tasklet.BatchTasklet;

@Configuration
public class BatchConfig {
private AutowireCapableBeanFactory beanFactory;
@Autowired
public BatchConfig(AutowireCapableBeanFactory beanFactory) {
	super();
	this.beanFactory = beanFactory;
}
@Bean
public Job executeJob(JobBuilderFactory jobBuilderFactory,Step step)
{
	return jobBuilderFactory.get("manualJob").incrementer(new RunIdIncrementer()).flow(step).end().build();
}
@Bean
public Step configStep(StepBuilderFactory stepBuilderFactory)
{
	return stepBuilderFactory.get("step").tasklet(getTasklet()).build();
}
public BatchTasklet getTasklet()
{
	BatchTasklet batchTasklet=new BatchTasklet();
	beanFactory.autowireBean(batchTasklet);
	return batchTasklet;
}

}