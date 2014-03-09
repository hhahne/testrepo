package com.henrik.service.createcollectible.model;

public class CollectibleDVDRequest extends CollectibleRequest {
	private int runningLength;

	
	public CollectibleDVDRequest(String name, String description, int runningLength) {
		this.name = name;
		this.description = description;
		this.runningLength = runningLength;
	}
	public int getRunningLength() {
		return runningLength;
	}

	public void setRunningLength(int runningLength) {
		this.runningLength = runningLength;
	}
	
	
}
