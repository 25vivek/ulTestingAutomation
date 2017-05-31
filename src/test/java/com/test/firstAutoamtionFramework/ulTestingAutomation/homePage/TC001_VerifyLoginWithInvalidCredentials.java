package com.test.firstAutoamtionFramework.ulTestingAutomation.homePage;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.test.firstAutoamtionFramework.ulTestingAutomation.testBase.TestBase;
import com.test.firstAutoamtionFramework.ulTestingAutomation.uiActions.Homepage;

public class TC001_VerifyLoginWithInvalidCredentials extends TestBase {
	public static final Logger log = Logger.getLogger(TC001_VerifyLoginWithInvalidCredentials.class.getName());

	Homepage homepage;

	@BeforeTest
	public void setUp() {
		init();

	}

	@Test
	public void verifyLoginWithInvalidCredentials() {

		log.info("********************Starting VerifyLoginWithInvalidCredentials test*******************");
		homepage = new Homepage(driver);
		homepage.loginToApplication("test@automation.com", "password123");
		Assert.assertEquals(homepage.getInvalidLoginText(), "Authentication failed.");
		log.info("********************Ending VerifyLoginWithInvalidCredentials test*******************");
	}

	@AfterClass
	public void endTest() {
		driver.close();
	}
}
