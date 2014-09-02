package com.tw.conference.domain;

public class Session {

	private int beginAt;
	
	private int mightFinishAfter;
	
	private int mustFinishUpTo;
	
	public Session(int beginAt, int finishAt) {
		this.beginAt = beginAt;
		this.mightFinishAfter = finishAt;
		this.mustFinishUpTo = finishAt;
	}

	public Session(int beginAt, int mightFinishAfter, int mustFinishUpTo) {
		this.beginAt = beginAt;
		this.mightFinishAfter = mightFinishAfter;
		this.mustFinishUpTo = mustFinishUpTo;
	}
	
	public int remainingMinutes() {
		return (this.mustFinishUpTo - this.beginAt) * 60; 
	}
}
