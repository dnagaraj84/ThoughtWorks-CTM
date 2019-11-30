/**
 * 
 */
package com.java.scheduler.service;

import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.java.scheduler.pojo.Conference;
import com.java.scheduler.util.Constants;

/**
 * The class which writes data to output file.
 * 
 * @author Nags
 */
public class DataProducer implements IDataProducer
{
	/**
	 * Logger class.
	 */
	final static Logger logger = Logger.getLogger(DataProducer.class);
		
	@Override
	public void writeOutput(final Conference conference)
	{
		final String fileName = Constants.OUTPUT_FILENAME;
		
		try (final FileWriter file = new FileWriter(fileName)) 
		{
            file.write(conference.toString());
        }
		catch (final IOException e) 
		{
			logger.error("Error occurred while writing into the file.");
        }		
	}

}
