package com.henrik.service.interactor.createcollectible;

public class CollectibleDVDEntry extends CollectibleEntity {

	private int runningLength;
	
	public CollectibleDVDEntry(String name, String description) {
		super(name, description);
	}

	public int getRunningLength() {
		return runningLength;
	}

	public void setRunningLength(int runningLength) {
		this.runningLength = runningLength;
	}

	
	
}
