/**
 * 
 */
package com.java.scheduler.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.java.scheduler.util.Constants;

/**
 * The POJO class for holding conference data.
 * 
 * @author Nags *
 */
public class Conference  implements Serializable
{
	//default serialVersion id
    private static final long serialVersionUID = 1L;
    
	private List<Track> tracks;

    public Conference() 
    {
        tracks = new ArrayList<Track>();
    }

    public void addTrack(Track track) 
    {
        tracks.add(track);
    }

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
    
    
	@Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("Conference Schedule:" + Constants.NEW_LINE + Constants.NEW_LINE);
        for (int i = 0; i < tracks.size(); i++) 
        {
            str.append("Track " + (i + 1) + ":" + Constants.NEW_LINE);
            str.append(tracks.get(i));
            str.append(Constants.NEW_LINE);
        }
        return str.toString();
    }
}
