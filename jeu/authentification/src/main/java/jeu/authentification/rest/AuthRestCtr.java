package jeu.authentification.rest;

import java.util.ArrayList;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import antlr.collections.List;
import jeu.authentification.model.LoginDTO;
import jeu.authentification.service.*;

@RestController
public class AuthRestCtr {
	
	@Autowired
	private AuthService authService;
	
	RestTemplate restTemplate = new RestTemplate ();

	
		//Connexion d'un utilisateur 
		@RequestMapping("/connect")
		
		public LoginDTO logi (@RequestBody LoginDTO dto) {
			LoginDTO logIn = authService.login(dto.getName(), dto.getmdp());
			return logIn;
		}
		

		

}