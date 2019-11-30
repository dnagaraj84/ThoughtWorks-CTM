/**
 * 
 */
package com.java.scheduler.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

import com.java.scheduler.pojo.Talk;
import com.java.scheduler.util.Constants;

/**
 * The class which consumes data from file for processing.
 * 
 * @author Nags
 */
public class DataConsumer implements IDataConsumer
{

	final static Logger logger = Logger.getLogger(DataConsumer.class);

	@Override
	public List<Talk> consumeData()
	{
		final List<Talk> talks = new ArrayList<>();

		try 
		{
			final InputStream inputStream = DataConsumer.class.getResourceAsStream(Constants.INPUT_FILENAME);
			final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
			
			String line = null;
			
            while ((line = reader.readLine()) != null) 
            {
                final Pattern pattern = Pattern.compile("([^0-9]*)([0-9]*min|lightning)");
                
                final Matcher patternMatcher = pattern.matcher(line);
                
                while(patternMatcher.find())
                {
                    String title = patternMatcher.group(1).trim();
                    String timeString = patternMatcher.group(2);
                    
                    if(timeString.equals(Constants.LIGHTING))
                    {
                    	talks.add(new Talk(title, true, 5));
                    }
                    else
                    {
                    	int minutes = Integer.valueOf(timeString.replace("min", ""));
                    			
                    	talks.add(new Talk(title, false, minutes));
                    }
                }
            }
		} 
		catch (FileNotFoundException e)
		{
			logger.error("Error occurred unable to locate the file.");
		} 
		catch (IOException e)
		{
			logger.error("Error occurred while accessing the file.");
		}

		return talks;
	}

}
