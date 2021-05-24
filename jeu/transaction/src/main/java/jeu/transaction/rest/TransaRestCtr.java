package jeu.transaction.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jeu.transaction.model.*;
import jeu.transaction.repository.*;
import jeu.transaction.rest.*;
import jeu.transaction.service.TransaService;

@RestController
public class TransaRestCtr {
	
	@Autowired
	private TransaService transacService;
	

	
	//On récupère la somme restante au joueur
	//En fonction de son argent restant, l'utilisateur peut ou non acheter une carte
	@RequestMapping("/buy/{iduser}/{idcard}") 
	public void checkMoney(@PathVariable Integer iduser, @PathVariable Integer idcard) {
		User u = userService.getUser(iduser);
		Card card = cardService.getCard(idcard);
		double umoney = u.getMoney();
		if (umoney >= card.getPrice()) {
			transacService.buyCard(u,card);
			System.out.println("You have a new card");
		}
		else {
			System.out.println("You don't have enough money to buy this card!");
		}
	}

	@RequestMapping("/sell/{iduser}/{idcard}") 
	public void sellCard(@PathVariable Integer iduser, @PathVariable Integer idcard) {
		RestTemplate restTemplate = new RestTemplate();
		String fooResourceUrl = "http://localhost:8080/user/service/UserService";
		ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
		assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));   
		
		User u = userService.getUser(iduser);
		Card card = cardService.getCard(idcard);
		transacService.SellCard(u, card);
		System.out.println("Card sold");
		
	}
	
	
	
}
