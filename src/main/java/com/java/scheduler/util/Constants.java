package com.java.scheduler.util;

import java.time.LocalTime;

public interface Constants 
{
	String INPUT_FILENAME = "/data.txt";
	String LIGHTING = "lightning";
	String NEW_LINE = System.getProperty("line.separator");
	String OUTPUT_FILENAME = "results.txt";
	String SPACE = " ";
	LocalTime networkStart = LocalTime.of(16, 0);
	LocalTime networkEnd = LocalTime.of(17, 0);
	LocalTime lunchTimeStart = LocalTime.of(12, 0);
	LocalTime lunchTimeEnd = LocalTime.of(13, 0);
	String pattern = "hh:mma";
}
