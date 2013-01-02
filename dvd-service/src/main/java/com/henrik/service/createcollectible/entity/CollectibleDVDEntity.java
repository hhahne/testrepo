package com.henrik.service.createcollectible.entity;


public class CollectibleDVDEntity extends CollectibleEntity {

	private int runningLength;
	
	public CollectibleDVDEntity(String name, String description) {
		super(name, description);
	}

	public int getRunningLength() {
		return runningLength;
	}

	public void setRunningLength(int runningLength) {
		this.runningLength = runningLength;
	}

	
	
}
