package com.mukeshsoft.schedular;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class JobSchedular {
	@Scheduled(fixedDelay = 1000)
	public void jobUsingFixedDelay()
	{
		
	}
	
	@Scheduled(fixedRate = 5000)
	public void jobUsingFixedRate()
	{
		
	}
	@Scheduled(initialDelay = 1000,fixedDelay = 1000)
	public void jobUsingInitialDelay()
	{
		
	}
	@Scheduled(cron ="*/5 * * * * *" )
	public void jobUsingCronExpression()
	{
		
	}

}
