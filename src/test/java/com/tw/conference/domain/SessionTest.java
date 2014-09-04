package com.tw.conference.domain;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.mockito.ArgumentCaptor;
import org.testng.annotations.Test;

import com.tw.conference.cmd.PrintHandler;

public class SessionTest {

	@Test
	public void shouldReturnLengthMinutes() {
		Session morningSession = new Session(9, 12);
		
		assertThat(morningSession.getLength()).isEqualTo(180);
	}
	
	@Test
	public void shouldReturnLengthMinutesConsideringDynamicEnd() {
		Session afternoonSession = new Session(13, 16, 17);
		
		assertThat(afternoonSession.getLength()).isEqualTo(240);
	}
	
	@Test
	public void shouldPrintTheTalks() {
		List<Talk> talks = new ArrayList<Talk>();
		talks.add(new Talk("Writing Fast Tests Against Enterprise Rails 60min"));
		talks.add(new Talk("Overdoing it in Python 45min"));
		talks.add(new Talk("Lua for the Masses lightning"));
		
		ConferenceManager confManager = new ConferenceManager(talks);
		
		Session session = confManager.createSession(9, 12);
		
		ArgumentCaptor<String> argument = ArgumentCaptor.forClass(String.class);
		PrintHandler printHandlerMock = mock(PrintHandler.class);;
		
		session.print(printHandlerMock);
		
		verify(printHandlerMock, times(3)).print(argument.capture());
		
		List<String> values = argument.getAllValues();
		assertThat(values.get(0)).isEqualTo("09:00AM Writing Fast Tests Against Enterprise Rails 60min");
		assertThat(values.get(1)).isEqualTo("10:00AM Overdoing it in Python 45min");
		assertThat(values.get(2)).isEqualTo("10:45AM Lua for the Masses lightning");
	}
}
