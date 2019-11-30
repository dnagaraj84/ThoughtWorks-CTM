package com.java.scheduler.service;

import static org.hamcrest.CoreMatchers.is;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.scheduler.pojo.Talk;

public class DataConsumerTest 
{
	private static DataConsumer consumer;
	
	@BeforeClass
	public static void setUp() 
	{
		consumer = new DataConsumer();
	}
	
	
	@Test
	public void testConsumeData() throws Exception 
	{
		final List<Talk> talks = consumer.consumeData();
		
		Assert.assertThat(talks.size(),is(19));
	}

}
