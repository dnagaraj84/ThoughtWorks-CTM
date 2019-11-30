package com.java.scheduler.service;

import java.time.LocalTime;
import java.util.ArrayList;
import static org.hamcrest.CoreMatchers.*;
import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.java.scheduler.pojo.Conference;
import com.java.scheduler.pojo.Talk;
import com.java.scheduler.pojo.Track;

public class DataProcesserTest 
{
	private static DataProcesser dataProcesser;
	
	@BeforeClass
	public static void setUp() 
	{
		dataProcesser = new DataProcesser();
	}
	
	@Test
	public void testFetchData() throws Exception 
	{
		final List<Talk> talks = dataProcesser.fetchData();
		
		Assert.assertNotNull(talks);
	}
	
	
	@Test
	public void testProcessData() throws Exception 
	{
		Talk talk1 = new Talk("Title1", false, 60);
		Talk talk2 = new Talk("Title2", false, 90);
		Talk talk3 = new Talk("Title3", false, 30);
		Talk talk4 = new Talk("Title4", false, 60);
		
		List<Talk> talks = new ArrayList<Talk>();
		
		talks.add(talk1);
		talks.add(talk2);
		talks.add(talk3);
		talks.add(talk4);
		
		final Conference conference = dataProcesser.processData(talks);
		
		List<Track> expectedTracks = conference.getTracks();
		
		Assert.assertThat(expectedTracks.size(), is(1));
		
		Track expectedTrack = expectedTracks.get(0);
		
		LocalTime nextTalkTime = expectedTrack.getNextTalk();
		
		Assert.assertThat(nextTalkTime.compareTo(LocalTime.of(17, 0)), is(0));
		Assert.assertThat(expectedTrack.getTalkInfos().size(), is(6));		
		Assert.assertThat(expectedTrack.getTalkInfos().get(0).getTitle(), is(talk2.getTitle()));
		Assert.assertThat(expectedTrack.getTalkInfos().get(5).getDuration(), is(0));
	}
}
