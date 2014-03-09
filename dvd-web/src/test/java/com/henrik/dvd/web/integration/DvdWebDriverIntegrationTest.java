package com.henrik.dvd.web.integration;

import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class DvdWebDriverIntegrationTest {

	protected WebDriver driver;
	
	@Before
	public void setUp() 
	{
//		System.setProperty("webdriver.chrome.driver", "/Users/henrikhahne/Public/chromedriver");
		driver = new HtmlUnitDriver(true);
	}
	
	@Test
	public void test() {
		driver.get("http://localhost:8090/dvd-web/default.xhtml");
		WebElement element = driver.findElement(By.id("test"));
		assertTrue(element.getText().equals("Heisann"));
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}

}
