package com.tw.conference.domain;

public class Talk {

	private int length;
	
	private String name;
	
	public Talk() {
		
	}
	
	public Talk(String nameAndLength) {
		this.setNameAndLength(nameAndLength);
	}
	
	public void setNameAndLength(String nameAndLength) {
		int lastSpaceIndex = nameAndLength.lastIndexOf(" ");
		this.name = nameAndLength.substring(0, lastSpaceIndex);
		String length = nameAndLength.substring(lastSpaceIndex + 1);
		
		if (length.equals("lightning")) {
			this.length = 5;
		} else {
			length = length.replaceFirst("min", "");
			this.length = Integer.valueOf(length);
		}
	}
	
	public int getLength() {
		return this.length;
	}
	
	public String getName() {
		return this.name;
	};
}
