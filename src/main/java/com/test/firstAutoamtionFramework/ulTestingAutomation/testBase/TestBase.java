package com.test.firstAutoamtionFramework.ulTestingAutomation.testBase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	//String url = "http://automationpractice.com/index.php";
	String url = "file:///E:/Dev%20Tools/Project%20Applications/POMWithPageFactoryFramework-master/project/demoSite.htm";
	String browser = "firefox";

	public void init() {
		selectBrowser(browser);
		getUrl(url);
		String log4jConfPath = "log4j.properties";
		PropertyConfigurator.configure(log4jConfPath);

	}

	public void getUrl(String url) {
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.get(url);

	}

	public void selectBrowser(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("Created browser object: " + browser);

		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Created browser object: " + browser);
		}
	}

}
