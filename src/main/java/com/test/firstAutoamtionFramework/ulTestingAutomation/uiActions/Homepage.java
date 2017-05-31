package com.test.firstAutoamtionFramework.ulTestingAutomation.uiActions;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	public static final Logger log = Logger.getLogger(Homepage.class.getName());
	WebDriver driver;

	@FindBy(xpath = "//a[@class='login']")
	WebElement signIn;

	@FindBy(xpath = "//input[@id='email']")
	WebElement loginEmailAddress;

	@FindBy(xpath = "//input[@id='passwd']")
	WebElement loginPassword;

	@FindBy(xpath = "//button[@id='SubmitLogin']")
	WebElement submitButton;

	@FindBy(xpath = "//li[contains(text(),'Authentication failed.')]")
	WebElement authenticationFailed;

	@FindBy(css="OK")
	WebElement alertAccept;
	
	@FindBy(id = "PreviewFrame")
	WebElement homePageIframe;
	
	@FindBy(xpath = "//a[@id='customer_register_link']")
	WebElement signUp;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastName;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailId;
	
	@FindBy(xpath = "//input[@id='CreatePassword']")
	WebElement createPassword;
	
	@FindBy(xpath = "//input[@value='Create']")
	WebElement createButton;
	
	@FindBy(xpath = "//*[@id='shopify-section-header']/div/div[2]/span")
	WebElement registrationMessage;
	
	/*
	 * @FindBy(xpath="//input[@id='username']") WebElement actitimeLoginEmail;
	 * 
	 * @FindBy(xpath="//input[@name='pwd']") WebElement actitimeLoginPassword;
	 * 
	 * @FindBy(xpath="//a[@id='loginButton']") WebElement loginButton;
	 * 
	 * @FindBy(xpath="//td[contains(text(),'Enter Time-Track')]") WebElement
	 * loginMessage;
	 */

	// Constructor of the Homepage class in order to avoid null pointer
	// exception
	public Homepage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void loginToApplication(String emailAddress, String password) {
		signIn.click();
		log.info("Clicked on signIn link and the object is" + signIn.toString());
		loginEmailAddress.sendKeys(emailAddress);
		log.info("Entered email id and the object is" + loginEmailAddress.toString());
		loginPassword.sendKeys(password);
		log.info("entered password and the object is" + loginPassword.toString());
		submitButton.click();
		log.info("clicked on submit button and the object is" + submitButton.toString());
		alertAccept.click();

		// For actitime practice
		/*
		 * actitimeLoginEmail.sendKeys(emailAddress);
		 * actitimeLoginPassword.sendKeys(password); loginButton.click();
		 */
	}

	public String getInvalidLoginText() {
		log.info("error message is" + authenticationFailed.getText());
		return authenticationFailed.getText();
	}
	
	public void registerUser(String firstName, String lastName, String emailAddress, String password){
		driver.switchTo().frame(homePageIframe);
		log.info("switching to homepage frame and frame object is:" +homePageIframe.toString());
		signUp.click();
		log.info("clicked on signUp link and obejct is:" +signUp.toString());
		this.firstName.clear();
		log.info("entered data to first name field and object is:" +firstName.toString());
		this.firstName.sendKeys("test");
		this.lastName.clear();
		this.lastName.sendKeys("testlast");
		log.info("entered data to last name field and object is:" +lastName.toString());
		emailId.clear();
		emailId.sendKeys("automations@gmail.com");
		log.info("entered data to email field and object is:" +emailId.toString());
		createPassword.clear();
		createPassword.sendKeys("password");
		log.info("entered data to paswword field and object is:" +createPassword.toString());
		createButton.click();
		log.info("clicked on create user button and object is:" +createButton.toString());
		}
	
	public String getRegistrationSuccessMessage(){
		log.info("registration message is:" +registrationMessage.getText());
		return registrationMessage.getText();
	}


}

/*
 * public String getActitimeLoginMessage(){ return loginMessage.getText(); } }
 */