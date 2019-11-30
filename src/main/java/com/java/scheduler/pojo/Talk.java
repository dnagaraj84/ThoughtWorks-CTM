package com.java.scheduler.pojo;

/**
 * Holds info on {@code Talk}.
 * 
 * @author Nags
 */
public class Talk implements Comparable<Talk>
{
	private String title;
	
	private boolean isLightingTalk = false;
	
	private int min;	

	public Talk(String title, boolean isLightingTalk, int min)
	{
		this.title = title;
		this.isLightingTalk = isLightingTalk;
		this.min = min;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}

	public boolean isLightingTalk() 
	{
		return isLightingTalk;
	}

	public void setLightingTalk(boolean isLightingTalk) 
	{
		this.isLightingTalk = isLightingTalk;
	}

	public int getMin() 
	{
		return min;
	}

	public void setMin(int min)
	{
		this.min = min;
	}
	
	

	@Override
	public String toString() 
	{
		return "Talk [title=" + title + ", isLightingTalk=" + isLightingTalk + ", min=" + min + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (isLightingTalk ? 1231 : 1237);
		result = prime * result + min;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Talk other = (Talk) obj;
		if (isLightingTalk != other.isLightingTalk)
			return false;
		if (min != other.min)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public int compareTo(Talk o) 
	{
		if(this.getMin() < o.getMin())
		{
            return 1;
        } 
		else
		{
            return -1;
        }
	}
}
