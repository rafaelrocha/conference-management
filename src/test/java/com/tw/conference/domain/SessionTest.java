package com.tw.conference.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class SessionTest {

	@Test
	public void shouldReturnRemainingMinutes() {
		Session morningSession = new Session(9, 12);
		
		assertThat(morningSession.remainingMinutes()).isEqualTo(180);
	}
	
	@Test
	public void shouldReturnRemainingMinutesConsideringDynamicEnd() {
		Session afternoonSession = new Session(13, 16, 17);
		
		assertThat(afternoonSession.remainingMinutes()).isEqualTo(240);
	}
}
