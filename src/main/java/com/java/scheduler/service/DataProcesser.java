/**
 * 
 */
package com.java.scheduler.service;

import java.time.LocalTime;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.java.scheduler.pojo.Conference;
import com.java.scheduler.pojo.Talk;
import com.java.scheduler.pojo.Track;
import com.java.scheduler.util.Constants;

/**
 * The class which process the data to create a schedule.
 * 
 * @author Nag
 */
public class DataProcesser implements IDataProcesser
{
	final static Logger logger = Logger.getLogger(DataProcesser.class);	
	final static Talk lunchTime = new Talk("Lunch", false, 60);
	final static Talk networkTalk = new Talk("Networking Event", false, 0);	
	
	@Override
	public List<Talk> fetchData()
	{
		final IDataConsumer consumer = new DataConsumer();
		
		final List<Talk> talks = consumer.consumeData();
		
		return talks;
	}
	
		
	@Override
	public Conference processData(final List<Talk> talks)
	{
		// Sort the talks based on time.		
		Collections.sort(talks);
		
		final Conference conference = new Conference();
		
		Track track = new Track();		
		
		for (Iterator<Talk> iter = talks.iterator(); iter.hasNext();) 
		{
			Talk talk = iter.next();
			
			if(isTrackFull(track, talk))
			{	
				track.setNextTalk(LocalTime.of(17, 0));
				track.addTalk(networkTalk);
				conference.addTrack(track);
				track = new Track();
			}
			
			if(validateWithLunchTime(talk, track) == false)
			{
				track.addTalk(lunchTime);
			}
			
			track.addTalk(talk);
			iter.remove();			
		}
		
		track.setNextTalk(LocalTime.of(17, 0));
		track.addTalk(networkTalk);
		conference.addTrack(track);
		
		return conference;
	}
	
	
	@Override
	public void writeOutput(Conference conference)
	{
		final IDataProducer dataProducer = new DataProducer();
		
		dataProducer.writeOutput(conference);
	}
	
	
	/**
	 * Validate the {@code Talk} with lunch time intervals.
	 * 
	 * @param talk Talk which needs to fit into the {@code Track}. Must not be {@code null}.
	 * @param track Track which maintains all the {@code Talk}. Must not be {@code null}.
	 * 
	 * @return Return true/false based on the conditions. Will never be {Code null}.
	 */
	private boolean validateWithLunchTime(final Talk talk, final Track track)
	{		
		final LocalTime nextSlot = track.getNextTalk();
		final LocalTime nextTalk = nextSlot.plusMinutes(talk.getMin());
		
		if((nextSlot.isBefore(Constants.lunchTimeStart) || nextSlot.isAfter(Constants.lunchTimeEnd) ||  nextSlot.compareTo(Constants.lunchTimeEnd) == 0) && 
				(nextTalk.isBefore(Constants.lunchTimeStart) || nextTalk.isAfter(Constants.lunchTimeEnd) || nextTalk.compareTo(Constants.lunchTimeStart) == 0 ))
		{
			return true;
		}
		
		return false;
	}

	
	/**
	 * Check if the track is full by adding and validating the track end time.
	 * 
	 * @param track Track which maintains all the {@code Talk}. Must not be {@code null}. 
	 * @param talk Talk which needs to fit into the {@code Track}. Must not be {@code null}.
	 * 
	 * @return Return true/false based on the conditions. Will never be {Code null}.
	 */
	private boolean isTrackFull(final Track track, final Talk talk)
	{
		final LocalTime nextSlot = track.getNextTalk();
		final LocalTime nextTalk = nextSlot.plusMinutes(talk.getMin());
		
		if(nextTalk.isAfter(Constants.networkEnd))
		{
			return true;
		}
		
		return false;
	}	
}
