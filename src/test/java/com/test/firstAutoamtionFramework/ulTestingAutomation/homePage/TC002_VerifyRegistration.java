package com.test.firstAutoamtionFramework.ulTestingAutomation.homePage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.firstAutoamtionFramework.ulTestingAutomation.testBase.TestBase;
import com.test.firstAutoamtionFramework.ulTestingAutomation.uiActions.Homepage;

public class TC002_VerifyRegistration extends TestBase {
	Homepage homepage;
	String firstName = "test";
	String lastName = "testlast";
	String emailAddress = "automations@gmail.com";
	String password = "password";

	@BeforeTest
	public void setUp() {
		init();

	}

	@Test
	public void verifyRegistration() throws InterruptedException {
		homepage = new Homepage(driver);
		homepage.registerUser(firstName, lastName, emailAddress, password);

		// Assert.assertEquals(arg0, homepage.getRegistrationSuccessMessage());

	}

	@AfterClass
	public void endTest() {
		driver.close();
		

	}

}
