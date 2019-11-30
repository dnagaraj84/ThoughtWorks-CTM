/**
 * 
 */
package com.java.scheduler.pojo;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.java.scheduler.util.Constants;

/**
 * Holds data to be represent as results.
 * 
 * @author Nags
 */
public class TalkInfo 
{
	private LocalTime startTime;
	
	private String title;
	
	private int duration;
	
	private boolean isLighting;

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}	

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}	
	
	public boolean isLighting() {
		return isLighting;
	}

	public void setLighting(boolean isLighting) {
		this.isLighting = isLighting;
	}

	@Override
	public String toString() 
	{
		final StringBuffer buffer = new StringBuffer();		
		
		buffer.append(startTime.format(DateTimeFormatter.ofPattern(Constants.pattern)));
		buffer.append(Constants.SPACE);
		buffer.append(title);
		buffer.append(Constants.SPACE);
		if(duration > 0 && !isLighting)
		{
			buffer.append(duration);
			buffer.append("min");
		}	
		else if(isLighting)
		{
			buffer.append("lightning");
		}
		buffer.append(Constants.NEW_LINE);	
		
		return buffer.toString();
	}
	
	

}
