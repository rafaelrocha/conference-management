package com.tw.conference.cmd;

public class PrintConsole implements PrintHandler {

	@Override
	public void print(String output) {
		System.out.println(output);
	}

}
