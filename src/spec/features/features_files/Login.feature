@login
Feature: Je souhaite tester la page de la connexion de l application Swag labs
  ETQ utilisateur je souhaite tester la page de la connexion de l application Swag Labs

	Background: (open browser)
		Given open browser
		
  @connexion-CasPassant
  Scenario: Je souhaite tester la page de la connexion avec un cas passant
    
    When Je saisi le username
    When Je saisi le password
    When Je clique sur le bouton login
    Then Je me redirige vers la page Home "Good afternoon slim2025"
    And bouton déconnexion s affiche
    

    @connexion-CasNonPassant-Email-invalide
  	Scenario: Je souhaite tester la page de la connexion avec un cas non passant email invalide
    
    When Je saisi le username invalide qacartTodo
    And Je saisi le password
    And Je clique sur le bouton login
    Then Le message d erreur s affiche "Please Insert a correct Email format"  

   
    @connexion-CasNonPassant-password-invalide
    Scenario: Je souhaite tester la page de la connexion avec un cas non passant password invalide
    
    When Je saisi le username
    And Je saisi le password invalide
    And Je clique sur le bouton login
    Then message erreur s affiche "The email and password combination is not correct, please fill a correct email and password" 
    
    
    
    