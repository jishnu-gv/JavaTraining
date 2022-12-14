package com.selenium.masterpart2;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectDropDown {
	
WebDriver driver = null;
	
	@BeforeMethod
	public void openBrowser(){
		
		System.setProperty("webdriver.chrome.driver",
				"/Users/anshul/JavaTraining/FirstSeleniumProject/drivers/chromedriver");
		 driver = new ChromeDriver();

		driver.get("https://www.facebook.com");
		driver.manage().window().maximize();

		// Apply Implicit wait
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(120));
		
		
	}
	
	@AfterMethod
	public void closeBrowser(){
		driver.quit();
	}
	
	@Test
	public void SelectDOB(){
		WebElement createaccount = driver.findElement(By.xpath("//*[@class=\"_6ltg\"]/a"));
		createaccount.click();
		
		WebElement monthDropDown = driver.findElement(By.xpath("//*[@id=\"month\"]"));
	
		//selectByIndex(int index) 
		Select select = new Select(monthDropDown);
		select.selectByIndex(1);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//selectByValue(String value) 
		select.selectByValue("11");
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//selectByVisibleText(String text) 
		select.selectByVisibleText("Dec");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		//getOptions() 
		List<WebElement>  monthValues = select.getOptions();
		for (WebElement month : monthValues) {
			System.out.println(month.getText());
		}
	}
	
	 
	
	
	
	//getFirstSelectedOption() 
	//getAllSelectedOptions() 
	//isMultiple() 
	//deselectByIndex(int index) 
	//deselectByValue(String value) 
	//deselectByVisibleText(String text) 
	//deselectAll()

}
