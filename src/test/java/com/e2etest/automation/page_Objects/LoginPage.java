package com.e2etest.automation.page_Objects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.e2etest.automation.utils.BasePage;
import com.e2etest.automation.utils.ConfigFileReader;
import com.e2etest.automation.utils.Setup;
import com.github.dockerjava.api.model.Driver;


public class LoginPage extends BasePage {
	
	
	public ConfigFileReader configFileReader;
	
	//locater email
	@FindBy(how=How.ID,using="Email")
	public static WebElement username;
	
	//locater password
	@FindBy(how=How.ID,using="Password")
	public static WebElement password;
	
	// locater button submit connexion
	@FindBy(how=How.XPATH,using="//button[type='submit']")
	public static WebElement btnLogin;
	
	// déconnexion
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	public static WebElement  btnLogout;
	
/*	//assert title home page
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/h2")
	private static WebElement titlePage;
	
	//message error email
	@FindBy(how=How.XPATH,using="//p[@id='email-helper-text']")
	public static WebElement msgError;
	
	//message erreur password
	@FindBy(xpath="//div[@class='MuiAlert-message']")
	public static WebElement  msgErrorPassword;
*/	


	
	/* initialisation des elements*/
	
	public LoginPage() {
		log.error("debut test LoginPage");
		PageFactory.initElements(Setup.getDriver(), this);
		configFileReader=new ConfigFileReader();
		log.error("fin test LoginPage");
	}
	
	
	
	/* méthode Valid user name and password */
	
	public void connectToApp() 
	{
		Setup.getDriver().get(configFileReader.getProperties("home.url"));	
	}
	
	public void fillUsername() 
	{
		username.clear();
		username.sendKeys(configFileReader.getProperties("home.login"));
	}
	
	public void fillPassword() 
	{password.clear();
		password.sendKeys(configFileReader.getProperties("home.password"));
	}
	
	public void clickBtnLogin() 
	{
		btnLogin.click();
		
	
	}
		

	
		
	

	
	

	

}
