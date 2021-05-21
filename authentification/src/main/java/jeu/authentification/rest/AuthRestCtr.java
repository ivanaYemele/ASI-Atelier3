package jeu.authentification.rest;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jeu.authentification.model.LoginDTO;
import jeu.authentification.service.AuthService;



@RestController
public class AuthRestCtr {
	
	@Autowired
	private AuthService authService;
	
		//Connexion d'un utilisateur 
		@RequestMapping(method=RequestMethod.POST, value="/connect")
		public int logIn(@RequestBody LoginDTO dto) throws IOException {
			int id = authService.login(dto.getName(), dto.getmdp());
			
			return id;
		}
		
		

}