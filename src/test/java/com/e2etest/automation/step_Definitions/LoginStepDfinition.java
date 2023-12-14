package com.e2etest.automation.step_Definitions;

import org.junit.Assert;

import com.e2etest.automation.page_Objects.LoginPage;
import com.e2etest.automation.utils.ConfigFileReader;
import com.e2etest.automation.utils.SeleniumUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class LoginStepDfinition {
	
	public ConfigFileReader configFileReader;
	private SeleniumUtils seleniumUtils;
	public LoginPage loginPage;
	
	
	//constructor
	public LoginStepDfinition () {
	loginPage= new LoginPage();
	configFileReader=new ConfigFileReader();
	seleniumUtils=new SeleniumUtils();
		
	}
	
	
	@Given("open browser")
	public void openbrowser(){
		loginPage.connectToApp();
	}
	

	@When ("Je saisi le username")
	public void Jesaisileusername() {
		loginPage.fillUsername();
	}

	
	@When ("Je saisi le password")
	public void Jesaisilepassword() {
	loginPage.fillPassword();
	}
	
	
	@When ("Je clique sur le bouton login")
		public void Jecliquesurleboutonlogin()
		{
			loginPage.clickBtnLogin();
		}
	
	@Then ("Je me redirige vers la page Home {string}")
		public void JemeredirigeverslapageHome (String titlePageAcceuil) {
		   loginPage.validTitre();
	}
	
	@And ("bouton déconnexion s affiche")
		public void boutondéconnexionsaffiche()
	{
		loginPage.BtnLogoutIsDisplayed();
	}
	

	
	@Then ("Le message d erreur s affiche {string}")
	public void Lemessagederreursaffiche (String msgEror) {
	String msg=LoginPage.msgError.getText();
	Assert.assertEquals(msg, msgEror);
	}
	
	@When ("Je saisi le username invalide qacartTodo")
	public void JesaisileusernameinvalideqacartTodo () {
		loginPage.loginNP();
	}

	@And ("Je saisi le password invalide")
	public void Jesaisilepasswordinvalide () {
		loginPage.passwordNP();
	}
	@Then ("message erreur s affiche {string}")
	public void messageerreursaffiche (String msgErrorPassword) {
	String msg=LoginPage.msgErrorPassword.getText();
	Assert.assertEquals(msg, msgErrorPassword);
	}	
	
}
