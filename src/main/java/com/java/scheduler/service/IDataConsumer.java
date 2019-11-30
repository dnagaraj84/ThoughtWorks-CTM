/**
 * 
 */
package com.java.scheduler.service;

import java.util.List;

import com.java.scheduler.pojo.Talk;

/**
 * The DataConsumer Interface.
 * 
 * @author Nags
 *
 */
public interface IDataConsumer
{
	/**
	 * The methods which reads the data from file.
	 * 
	 * @return The List of {@code Talk} 
	 */
	List<Talk> consumeData();
}
