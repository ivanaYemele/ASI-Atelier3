package jeu.user.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


import jeu.user.model.User;
import jeu.user.service.UserService;


@RestController
public class UserRestCtr {

	@Autowired
	private UserService userService ;
	
	RestTemplate restTemplate = new RestTemplate ();
	
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
	
	
	@RequestMapping(method=RequestMethod.GET,value="connexion/{name}/{mdp}")
	public int login( @PathVariable String name , @PathVariable String mdp ) {
		//On récupère les information de l'utilisateur puis on vérifie si elles sont correcte		
		User user = userService.getConnected(name,mdp);
		int id = user.getId();
		return id;
	}
	


	
}

