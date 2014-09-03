package com.tw.conference.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;



public class ConferenceManager {

	private List<Talk> talks = new ArrayList<Talk>();
	private TalkLengthComparator lengthComparator = new TalkLengthComparator();
	
	public ConferenceManager(List<Talk> talks) {
		this.talks = talks;
		Collections.sort(this.talks, this.lengthComparator);
	}
	
	public Session createSession(int beginAt, int finishAt) {
		Session session = new Session(beginAt, finishAt);
		
		Iterator<Talk> talksIterator = this.talks.iterator();
		while (talksIterator.hasNext()) {
			Talk talk = talksIterator.next();
			
			if (session.getRemainingMinutes() > 0) {
				if (session.getRemainingMinutes() - talk.getLength() >= 0) {
					session.add(talk);
					talksIterator.remove();
				} else {
					continue;
				}
			}
		}

		return session;
	}
	
	public Session createSession(int beginAt, int mightFinishAfter, int mustFinishUpTo) {
		Session session = new Session(beginAt, mightFinishAfter, mustFinishUpTo);
		
		// TODO remove duplication
		Iterator<Talk> talksIterator = this.talks.iterator();
		while (talksIterator.hasNext()) {
			Talk talk = talksIterator.next();
			
			if (session.getRemainingMinutes() > 0) {
				if (session.getRemainingMinutes() - talk.getLength() >= 0) {
					session.add(talk);
					talksIterator.remove();
				} else {
					continue;
				}
			}
		}

		return session;
	}
	 
}
