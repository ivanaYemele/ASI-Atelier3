package jeu.user.service;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jeu.user.model.User;

import org.springframework.web.client.RestTemplate;

import jeu.user.repository.*;



@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	

	
	//Ajout d'un nouvel utilisateur dans la BDD
	public void addUser (User user) {
		User createdUser = userRepository.save(user);
		//System.out.println(createdUser);
		System.out.println("User created");
	}
	
	
	//Récupération d'un utilisateur spécifique
	public User getUser(Integer iduser) {
		Optional<User> userOpt = userRepository.findById(iduser);
		if (userOpt.isPresent()) {
			return userOpt.get();
		}else {
			return null;
		}

	}
	
	//maj du porte-monnaie du joueur dans la bdd
	public void updateMoney(User u) {
		userRepository.save(u);
		
	}

	
	public User getConnected(String name, String mdp) {
		Optional<User> userOpt = userRepository.findByNameAndMdp(name,mdp);
		if (userOpt.isPresent()) {
			System.out.println("Connected");
			return userOpt.get();
		}else {
			System.out.println("You've entered wrong informations, try again");
			return null;
		}

	}
	

	

}