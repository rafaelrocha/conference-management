package com.tw.conference.domain;

import java.util.ArrayList;
import java.util.List;

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
	
}
