package jeu.authentification.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import antlr.collections.List;
import jeu.authentification.User;
import jeu.authentification.model.LoginDTO;
import jeu.authentification.service.*;
//import jeu.user.service.UserService;

@RestController
public class AuthRestCtr {
	
	@Autowired
	private AuthService authService;
	
	RestTemplate restTemplate = new RestTemplate ();

	
		//Connexion d'un utilisateur 
		@RequestMapping("/connect")
		public User user (@RequestBody LoginDTO dto) {
			LoginDTO logIn = authService.login(dto.getName(), dto.getmdp());
			
		    Map<String, String> params = new HashMap<String, String>();
		    params.put(logIn.getName(),logIn.getmdp());
		    
			final String uri = "http://localhost:8086/connexion/{name}/{mdp}";
		    User result = restTemplate.getForObject(uri, User.class, params);
		    
		    
		   // LoginDTO result = restTemplate.postForObject( "http://localhost:8086/send", logIn, LoginDTO.class);
			//User user = response.getConnected(logIn.getName(),logIn.getmdp());
			return user;
		}
		
	

		

		

}