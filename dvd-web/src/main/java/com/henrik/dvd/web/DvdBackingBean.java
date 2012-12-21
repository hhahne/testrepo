package com.henrik.dvd.web;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("dvdBean")
@Scope("request")
public class DvdBackingBean {

	public String printMessage() {
		return "Hei from backing bean";
	}
	
}
