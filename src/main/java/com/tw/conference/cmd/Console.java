package com.tw.conference.cmd;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.tw.conference.domain.ConferenceManager;
import com.tw.conference.domain.Session;
import com.tw.conference.domain.Talk;

public class Console {

	public static void main(String args[]) {
		String inputPath = "conference.input";
		Scanner scanner = null;
		
		try {
			scanner = new Scanner(new File(inputPath));
			
			List<Talk> talks = new ArrayList<Talk>();
			
			while (scanner.hasNextLine()) {
				talks.add(new Talk(scanner.nextLine()));
			}
			
			ConferenceManager confManager = new ConferenceManager(talks);
			
			Session trackOneMorningSession = confManager.createSession(9, 12);
			Session trackTwoMorningSession = confManager.createSession(9, 12);
			
			Session trackOneAfternoonSession = confManager.createSession(13, 16, 17);
			Session trackTwoAfternoonSession = confManager.createSession(13, 16, 17);
			
			
			PrintHandler printConsole = new PrintConsole();
			
			System.out.println("Track 1:");
			trackOneMorningSession.print(printConsole);
			System.out.println("12:00PM Lunch");
			trackOneAfternoonSession.print(printConsole);
			
			System.out.println("Track 2:");
			trackTwoMorningSession.print(printConsole);
			System.out.println("12:00PM Lunch");
			trackTwoAfternoonSession.print(printConsole);
		} catch (FileNotFoundException e) {
			System.out.format("Input file not found at %s", inputPath);
		} finally {
			if (scanner != null ) {
				scanner.close();
			}
		}
	}
}
