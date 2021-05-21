package jeu.transaction.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class TransaRestCtr {
	
	@Autowired
	private TransacService transacService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CardService cardService;
	
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
		User u = userService.getUser(iduser);
		Card card = cardService.getCard(idcard);
		transacService.SellCard(u, card);
		System.out.println("Card sold");
		
	}
	
	
	
}
