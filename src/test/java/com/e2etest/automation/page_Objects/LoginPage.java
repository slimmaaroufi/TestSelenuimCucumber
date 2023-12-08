package com.e2etest.automation.page_Objects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etest.automation.utils.ConfigFileReader;
import com.e2etest.automation.utils.Setup;
import com.github.dockerjava.api.model.Driver;

public class LoginPage {

	public ConfigFileReader configFileReader;
	
	
	@FindBy(how=How.ID,using="email")
	public static WebElement username;
	
	@FindBy(how=How.ID,using="password")
	public static WebElement password;
	
	@FindBy(how=How.ID,using="submit")
	public static WebElement btnLogin;
	
	//@FindBy(how=How.XPATH,using="//h2[normalize-space()='Good Evening slim2025']")
	
	//String elementText = driver.findElement(By.cssSelector("#welcome")).getText();
	
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/h2")
	private static WebElement titlePage;
	
	
	
	@FindBy(how=How.XPATH,using="//p[@id='email-helper-text']")
	public static WebElement msgError;
	
	//p[@id='email-helper-text']
	//@FindBy(how=How.XPATH,using="//div[@class='MuiAlert-message']") 
	//public static WebElement msgErrorPassword;
	
	
	/* initialisation des elements*/
	
	public LoginPage() {
		PageFactory.initElements(Setup.getDriver(), this);
		configFileReader=new ConfigFileReader();
	}
	
	/* méthode */
	public void login() throws InterruptedException
	{
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
		username.clear();
		username.sendKeys(configFileReader.getProperties("home.login"));
		password.clear();
		password.sendKeys(configFileReader.getProperties("home.password"));
		btnLogin.click();
		Thread.sleep(2000);
	}
	
	public void validTitre() {
		  
		        
		        // Vérifier le contenu des éléments dans la sidebar
		      if (titlePage.getText().equals("Good afternoon slim2025")) {
		            System.out.println("Test ok : the title is correct :"+titlePage.getText());
		        } else {
		           System.out.println("Test failed : the title should be :Good afternoon slim2025");
		       }
	    }
	    
		
	
	
	
	public void loginNP() 
	{
			username.clear();
			username.sendKeys("slim122com");
			
			//password.clear();
			//password.sendKeys("testllfdf");
			//btnLogin.click();
	}
	
	
	
	public void connectToApp() {
		Setup.getDriver().get(configFileReader.getProperties("home.url"));
		
	}
	
	public void fillUsername() {
		username.sendKeys(configFileReader.getProperties("home.login"));
		//username.clear();
		//username.sendKeys();
	}
	
	public void fillPassword() {
		password.sendKeys(configFileReader.getProperties("home.password"));
	}
	
	public void clickBtnLogin() {
		btnLogin.click();
	}
	
	
	
}
