/**
 * 
 */
package com.java.scheduler.service;

import java.io.IOException;

import com.java.scheduler.pojo.Conference;

/**
 * The DataProducer Interface.
 * 
 * @author Nags
 *
 */
public interface IDataProducer 
{
	/**
	 * Method writes the result data to output file.
	 * 
	 * @param conference The {@code Conference} containing records. Must not be {@code null}.
	 * 
	 * @throws IOException Anything goes wrong if accessing the file.
	 */
	void writeOutput(Conference conference);
}
