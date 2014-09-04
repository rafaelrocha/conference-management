package com.tw.conference.domain;

import static org.fest.assertions.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class TalkTest {

	@Test
	public void shouldSetNameAndMinutesLength() {
		Talk talk = new Talk();
		
		talk.setNameAndLength("Common Ruby Errors 45min");
		
		assertThat(talk.getName()).isEqualTo("Common Ruby Errors");
		assertThat(talk.getLength()).isEqualTo(45);
	}
	
	@Test
	public void shouldSetNameAndLightningLength() {
		Talk talk = new Talk();
		
		talk.setNameAndLength("Rails for Python Developers lightning");
		
		assertThat(talk.getName()).isEqualTo("Rails for Python Developers");
		assertThat(talk.getLength()).isEqualTo(5);
	}
	
}
