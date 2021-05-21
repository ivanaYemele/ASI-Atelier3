package jeu.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TransaService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CardService cardService;

	//Le joeur peut acheter sa carte
	public void buyCard(User u, Card card) {
		double usrmoney = u.getMoney();
		double cardprice = card.getPrice();
		//on réalise la transaction
		double achat = usrmoney - cardprice;
		
		//on met à jour la somme d'argent restante du joueur
		u.setMoney(achat);
		userService.updateMoney(u);
		
		
	}

	public void SellCard(User u, Card card) {
		double usrmoney = u.getMoney();
		double cardprice = card.getPrice();
		double marge = 0.5;
		//on réalise la transaction
		double vente = usrmoney + cardprice + marge;
		
		//on met à jour la somme d'argent du joueur
		u.setMoney(vente);	
		userService.updateMoney(u);
	}

}
