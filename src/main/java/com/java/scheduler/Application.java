package com.java.scheduler;

import java.util.List;

import org.apache.log4j.Logger;

import com.java.scheduler.pojo.Conference;
import com.java.scheduler.pojo.Talk;
import com.java.scheduler.service.DataProcesser;
import com.java.scheduler.service.IDataProcesser;

public class Application 
{
	static final Logger logger = Logger.getLogger(Application.class);
	
	public static void main(String[] args)
    {
		logger.debug("Processing starts.");
        
		IDataProcesser dataProcesser = new DataProcesser();
		
		final List<Talk> talks = dataProcesser.fetchData();
		
		final Conference conference = dataProcesser.processData(talks);
		
		dataProcesser.writeOutput(conference);
		
		logger.debug("Processing completed.");
    }
}
