package jeu.transaction.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import jeu.transaction.model.Card;
import jeu.transaction.model.User;
import jeu.transaction.service.TransaService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class TransaRestCtr {
	
	@Autowired
	private TransaService transacService;
	RestTemplate restTemplate = new RestTemplate();

	
	//On récupère la somme restante au joueur
	//En fonction de son argent restant, l'utilisateur peut ou non acheter une carte
	@RequestMapping("/buy/{iduser}/{idcard}") 
	public void checkMoney(@PathVariable Integer iduser, @PathVariable Integer idcard) {
		User user  = restTemplate.getForObject("http://localhost:8082/users/" + iduser,User.class);
		Card card  = restTemplate.getForObject("http://localhost:8083/cards/" + idcard,Card.class);
		
		double umoney = user.getMoney();
		if (umoney >= card.getPrice()) {
			transacService.buyCard(user,card);
			System.out.println("You have a new card");
		}
		else {
			System.out.println("You don't have enough money to buy this card!");
		}
	}

	@RequestMapping("/sell/{iduser}/{idcard}") 
	public void sellCard(@PathVariable Integer iduser, @PathVariable Integer idcard) {
		User user  = restTemplate.getForObject("http://localhost:8082/users/" + iduser,User.class);
		Card card  = restTemplate.getForObject("http://localhost:8083/cards/" + idcard,Card.class);
		transacService.SellCard(user, card);
		System.out.println("Card sold");
		
	}
	

	
	
	
}