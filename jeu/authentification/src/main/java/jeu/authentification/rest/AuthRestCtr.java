package jeu.authentification.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import asi.game.cartes.dto.LoginDTO;
import asi.game.cartes.service.AuthService;

@RestController
public class AuthRestCtr {
	
	@Autowired
	private AuthService authService;
	
		//Connexion d'un utilisateur 
		@RequestMapping("/connect")
		public int logIn(@RequestBody LoginDTO dto) {
			int id = authService.login(dto.getName(), dto.getmdp());
			
			return id;
		}
		

}