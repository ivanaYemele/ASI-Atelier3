package jeu.authentification.service;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import jeu.authentification.model.LoginDTO;





@Service
public class AuthService {
	
	RestTemplate restTemplate = new RestTemplate ();

	//Gestion de la connexion de l'utilisateur
	public LoginDTO login(String name, String mdp) {
		LoginDTO log = new LoginDTO ();
		log.setName(name);
		log.setmdp(mdp);
		return log ; 	

}
}


