package jeu.authentification.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import asi.game.cartes.model.User;


@Service
public class AuthService {
	
	@Autowired
	private UserService userService;
	
	//Gestion de la connexion de l'utilisateur
	public int login(String name, String mdp) {
		//On récupère les information de l'utilisateur puis on vérifie si elles sont correctes
		User user = userService.getConnected(name,mdp);
		int id = user.getId();
		return id;
	}
}


