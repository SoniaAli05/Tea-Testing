package com.sonia.ali.teatesting.TeaTesting;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StackSteps {

	ChromeDriver driver;
	WebElement menu;
	WebElement checkout;
	ExtentReports extent;
	ExtentTest test;

	@Before
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\Desktop\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		extent = new ExtentReports("C:\\Users\\Admin\\Desktop\\TeaTestReport.html", true);
	}

	@After
	public void teardown() throws InterruptedException {
		driver.quit();
	}

	@Given("^the correct web address$")
	public void the_correct_web_address() {
		test = extent.startTest("Verify application Title");
		test.log(LogStatus.INFO, "Browser started");
		test.log(LogStatus.PASS, "Verify Title of the page");
		driver.manage().window().maximize();
		driver.get(Constants.websiteURL);
	}

	@When("^I navigate to the 'Menu' page$")
	public void i_navigate_to_the_Menu_page() throws InterruptedException {
	
	WebElement menu = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[3]/a"));
	menu.click();
	Thread.sleep(3000);
	}

	@Then("^I can browse a list of the available products\\.$")
	public void i_can_browse_a_list_of_the_available_products() {
		assertEquals("Menu", driver.getTitle());
	}

	@When("^I click the checkout button$")
	public void i_click_the_checkout_button() {
		WebElement checkout = driver.findElement(By.xpath("//*[@id=\"wsb-nav-00000000-0000-0000-0000-000450914915\"]/ul/li[5]/a"));
		checkout.click();
		//Thread.sleep(3000);
	}

	@Then("^I am taken to the checkout page$")
	public void i_am_taken_to_the_checkout_page() {
		assertEquals(Constants.checkoutPage, driver.getCurrentUrl());
		
		

	}


}
