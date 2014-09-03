package com.tw.conference.domain;

import java.util.Comparator;

public class TalkLengthComparator implements Comparator<Talk> {

	@Override
	public int compare(Talk talkOne, Talk talkTwo) {
		return talkTwo.getLength() - talkOne.getLength();
	}
	

}
