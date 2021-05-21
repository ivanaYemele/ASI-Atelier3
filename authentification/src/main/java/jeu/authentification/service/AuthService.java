package jeu.authentification.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;



@Service
public class AuthService {
	
	@Autowired
	RestTemplate restTemplate;

	
	//Gestion de la connexion de l'utilisateur
	public int login(String name, String mdp) throws IOException {
		//On récupère les information de l'utilisateur puis on vérifie si elles sont correctes
		/*User user = userService.getConnected(name,mdp);
		int id = user.getId();
		return id;*/

		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <Integer> entity = new HttpEntity<Integer>(headers);
	      
	    return restTemplate.exchange("http://localhost:8082/users/" + name +"/"+ mdp, HttpMethod.POST, entity, int.class).getBody();
	}
	
}

