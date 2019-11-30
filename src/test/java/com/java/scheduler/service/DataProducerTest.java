package com.java.scheduler.service;

import java.io.File;
import java.util.Collections;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;

import com.java.scheduler.pojo.Conference;
import com.java.scheduler.pojo.Talk;
import com.java.scheduler.pojo.Track;


public class DataProducerTest 
{
	private static DataProducer dataProducer;
	
	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();
	
	@BeforeClass
	public static void setUp() 
	{
		System.setProperty("log4j.configurationFile","log4j2-text.properties");
		dataProducer = new DataProducer();
	}
	
	
	@Test
	public void testWriteOutput() throws Exception 
	{
		final File tempFile = tempFolder.newFile("output.txt");
		
		final Conference conference = new Conference();
		final Track track = new Track();
		final Talk talk = new Talk("Hello World", false, 60);
		
		track.addTalk(talk);
		
		conference.setTracks(Collections.singletonList(track));
		
		dataProducer.writeOutput(conference);		
		
		Assert.assertTrue(tempFile.exists());		
	}

}
