package com.tw.conference.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import com.tw.conference.cmd.PrintHandler;

public class Session {

	private int beginAt;
	
	private int mightFinishAfter;
	
	private int mustFinishUpTo;
	
	private int length;
	
	private int remainingMinutes;
	
	private List<Talk> talks = new ArrayList<Talk>();
	
	public Session(int beginAt, int finishAt) {
		this.beginAt = beginAt;
		this.mightFinishAfter = finishAt;
		this.mustFinishUpTo = finishAt;
		this.length = (this.mustFinishUpTo - this.beginAt) * 60;
		this.remainingMinutes = this.length;
	}

	public Session(int beginAt, int mightFinishAfter, int mustFinishUpTo) {
		this.beginAt = beginAt;
		this.mightFinishAfter = mightFinishAfter;
		this.mustFinishUpTo = mustFinishUpTo;
		this.length = (this.mustFinishUpTo - this.beginAt) * 60;
		this.remainingMinutes = this.length;
	}
	
	public int getLength() {
		return this.length; 
	}
	
	public int getRemainingMinutes() {
		return this.remainingMinutes;
	}
	
	public void add(Talk talk) {
		this.talks.add(talk);
		this.remainingMinutes = this.remainingMinutes - talk.getLength();
	}
	
	public void print(PrintHandler printHandler) {
		int currentMinutes = 60 * this.beginAt; 
				
		for (Talk talk : talks) {
			int talkLength = talk.getLength();
			String talkLengthInText = "lightning";
			
			if (talkLength != 5) {
				talkLengthInText = talkLength + "min";
			}
			
			printHandler.print(
				String.format("%s %s %s", 
					convertMinutesToHourAndMinutes(currentMinutes), 
					talk.getName(), 
					talkLengthInText));
			
			currentMinutes += talk.getLength();
		}
	}
	
	private String convertMinutesToHourAndMinutes (int minutes) {
		int hours = minutes / 60;
		int convertedMinutes = minutes % 60;
		String ampm = hours < 13 ? "AM" : "PM";
		return String.format("%02d:%02d%s", hours, convertedMinutes, ampm);
	}
}
