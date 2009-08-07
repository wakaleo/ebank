package org.ebank.web;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.*;

public class TestWebDriverDepositStoryUI {

	private WebDriver driver;
	
	@Before
	public void setUp() {
		driver = new HtmlUnitDriver();
	}
	
	@Test
	public void testDepositingCashShouldAddToBalance() {		
		driver.get("http://localhost:9090/ebank-web");
		WebElement element = driver.findElement(By.name("depositAmount"));
		element.sendKeys("100");
		element.submit();
		assertThat(driver.getPageSource(), containsString("Current Balance: $100"));
	}

}	

