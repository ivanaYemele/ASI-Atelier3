package jeu.user.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jeu.user.model.User;
import jeu.user.service.UserService;


@RestController
public class UserRestCtr {

	@Autowired
	private UserService userService;
	
	//Creation d'un utilisateur
	@RequestMapping(method=RequestMethod.POST, value="/newuser")
	public void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	//Affichage d'utilisateur à partir du nom 
	@RequestMapping("/users/{iduser}") 
	public User getUser(@PathVariable Integer iduser) {
		User u = userService.getUser(iduser);
		return u;
	}
	
	
}