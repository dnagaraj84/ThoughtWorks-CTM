package com.java.scheduler.service;

import java.util.List;

import com.java.scheduler.pojo.Conference;
import com.java.scheduler.pojo.Talk;

/**
 * The DataProcesser Interface.
 * 
 * @author Nags
 *
 */
public interface IDataProcesser 
{
	List<Talk> fetchData();
	
	Conference processData(List<Talk> talks);
	
	void writeOutput(Conference conference);
}
