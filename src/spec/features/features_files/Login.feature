@login
Feature: Je souhaite tester la page de la connexion de l application Swag labs
  ETQ utilisateur je souhaite tester la page de la connexion de l application Swag Labs

	Background: (open browser)
		Given open browser
		
  @connexion-CasPassant
  Scenario: Login with valid credentials
    When I enter the email and password
    And I click the login button
    Then Page Title should be "Dashboard"
    When User click on Log out link
    Then Title of the page should be "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
 

     
     