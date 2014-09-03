package com.tw.conference.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

public class ConferenceManagerTest {

	@Test
	public void shouldCreateSession() {
		List<Talk> talks = new ArrayList<Talk>();
		talks.add(new Talk("Writing Fast Tests Against Enterprise Rails 60min"));
		talks.add(new Talk("Overdoing it in Python 45min"));
		talks.add(new Talk("Lua for the Masses 30min"));
		talks.add(new Talk("Ruby Errors from Mismatched Gem Versions 45min"));
		talks.add(new Talk("Common Ruby Errors 45min"));
		talks.add(new Talk("Rails for Python Developers lightning"));
		talks.add(new Talk("Communicating Over Distance 60min"));
		talks.add(new Talk("Accounting-Driven Development 45min"));
		talks.add(new Talk("Woah 30min"));
		talks.add(new Talk("Sit Down and Write 30min"));
		talks.add(new Talk("Pair Programming vs Noise 45min"));
		talks.add(new Talk("Rails Magic 60min"));
		talks.add(new Talk("Ruby on Rails: Why We Should Move On 60min"));
		talks.add(new Talk("Clojure Ate Scala (on my project) 45min"));
		talks.add(new Talk("Programming in the Boondocks of Seattle 30min"));
		talks.add(new Talk("Ruby vs. Clojure for Back-End Development 30min"));
		talks.add(new Talk("Ruby on Rails Legacy App Maintenance 60min"));
		talks.add(new Talk("A World Without HackerNews 30min"));
		talks.add(new Talk("User Interface CSS in Rails Apps 30min"));
		
		ConferenceManager confManager = new ConferenceManager(talks);
		
		Session trackOneMorningSession = confManager.createSession(9, 12);
		Session trackTwoMorningSession = confManager.createSession(9, 12);
		
		Session trackOneAfternoonSession = confManager.createSession(13, 16, 17);
		Session trackTwoAfternoonSession = confManager.createSession(13, 16, 17);
		
		assertThat(trackOneMorningSession.getRemainingMinutes()).isEqualTo(0);
		assertThat(trackTwoMorningSession.getRemainingMinutes()).isEqualTo(0);
		
		assertThat(trackOneAfternoonSession.getRemainingMinutes()).isEqualTo(15);
		assertThat(trackTwoAfternoonSession.getRemainingMinutes()).isEqualTo(30);
	}
}
