/**
 * 
 */
package com.java.scheduler.pojo;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * The {@code Track} holds info on Talks.
 * 
 * @author Nags
 */
public class Track 
{
	private List<TalkInfo> talkInfos = new ArrayList<>();
	private LocalTime nextTalk = LocalTime.of(9, 0);
	
	public List<TalkInfo> getTalkInfos() {
		return talkInfos;
	}

	public void setTalkInfos(List<TalkInfo> talkInfos) {
		this.talkInfos = talkInfos;
	}

	public void addTalk(Talk talk)
	{
		TalkInfo talkInfo = new TalkInfo();
		
		talkInfo.setStartTime(nextTalk);
		talkInfo.setDuration(talk.getMin());
		talkInfo.setTitle(talk.getTitle());
		talkInfo.setLighting(talk.isLightingTalk());
		
		talkInfos.add(talkInfo);
		
		nextTalk = nextTalk.plusMinutes(talk.getMin());
		
//		if(nextTalk.compareTo(LocalTime.NOON) == 0)
//			nextTalk = nextTalk.plusMinutes(60);
	}

	public LocalTime getNextTalk() {
		return nextTalk;
	}

	public void setNextTalk(LocalTime nextTalk) {
		this.nextTalk = nextTalk;
	}
	
	
	@Override
    public String toString() 
	{
        StringBuilder str = new StringBuilder();
        
        for (TalkInfo talkInfo : talkInfos) 
        {
            str.append(talkInfo);
        }
        
        return str.toString();
    }
}
