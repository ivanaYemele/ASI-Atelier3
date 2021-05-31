package jeu.transaction.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import jeu.transaction.model.Card;
import jeu.transaction.model.User;




@Service
public class TransaService {
	
	

	private TransaService transacService;
	RestTemplate restTemplate = new RestTemplate();
	//Le joueur peut acheter sa carte
	
	public void buyCard(User u, Card card) {
		double usrmoney = u.getMoney();
		double cardprice = card.getPrice();
		//on réalise la transaction
		double achat = usrmoney - cardprice;
		
		//on met à jour la somme d'argent restante du joueur
		u.setMoney(achat);
		restTemplate.put("http://localhost:8082/umoney/" + u.getId(), u);
		
		
	}
	


	public void SellCard(User u, Card card) {
		double usrmoney = u.getMoney();
		double cardprice = card.getPrice();
		double marge = 0.5;
		//on réalise la transaction
		double vente = usrmoney + cardprice + marge;
		
		//on met à jour la somme d'argent du joueur
		u.setMoney(vente);	
		restTemplate.put("http://localhost:8082/umoney/" + u.getId(), u);

	}
	
	
	
}