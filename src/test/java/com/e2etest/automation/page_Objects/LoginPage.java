package com.e2etest.automation.page_Objects;

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
	@FindBy(how=How.ID,using="email")
	public static WebElement username;
	
	//locater password
	@FindBy(how=How.ID,using="password")
	public static WebElement password;
	
	// locater button submit connexion
	@FindBy(how=How.ID,using="submit")
	public static WebElement btnLogin;
	
	//assert title home page
	@FindBy(xpath="//*[@id=\"root\"]/div[2]/div/div/h2")
	private static WebElement titlePage;
	
	//message error email
	@FindBy(how=How.XPATH,using="//p[@id='email-helper-text']")
	public static WebElement msgError;
	
	//message erreur password test
	@FindBy(xpath="//div[@class='MuiAlert-message']")
	public static WebElement  msgErrorPassword;
	
	// déconnexion
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	public static WebElement  btnLogout;

	
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
		username.sendKeys(configFileReader.getProperties("home.login"));
	}
	
	public void fillPassword() 
	{
		password.sendKeys(configFileReader.getProperties("home.password"));
	}
	
	public void clickBtnLogin() 
	{
		btnLogin.click();
	}
		
	public void validTitre() {
		  	     
		// Vérifier le contenu des éléments dans la sidebar
		if (titlePage.getText().equals("Good afternoon slim2025")) {
		            System.out.println("Test ok : the title is correct :"+titlePage.getText());
		 } else 
		 	   {
		           System.out.println("Test failed : the title should be :Good afternoon slim2025");
		       }
	    }
	
	
	public void BtnLogoutIsDisplayed() {
		btnLogout.isDisplayed();
	}
	
	
		
	
   	
	public void loginNP() 
	{
			username.clear();
			username.sendKeys("slim122com");
			password.sendKeys(configFileReader.getProperties("home.password"));
			btnLogin.click();
			
	}
	
	

	
	public void passwordNP() {
		
		
		password.clear();
		password.sendKeys("testllfdf789521");
		btnLogin.click();
		
	}

	
	

	

}
