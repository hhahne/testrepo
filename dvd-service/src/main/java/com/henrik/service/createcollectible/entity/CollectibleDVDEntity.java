package com.henrik.service.createcollectible.entity;


public class CollectibleDVDEntity extends CollectibleEntity {

	private int runningLength;
	
	public CollectibleDVDEntity(String name, String description) {
		super(name, description);
	}
	
	public CollectibleDVDEntity(String name, String description, int runningLength) 
	{
		this(name, description);
		this.runningLength = runningLength;
	}

	public int getRunningLength() {
		return runningLength;
	}


	
	
}
