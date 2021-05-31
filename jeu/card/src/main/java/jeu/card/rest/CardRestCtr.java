package jeu.card.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import jeu.card.model.Card;
import jeu.card.service.CardService;



@RestController
public class CardRestCtr {
	
	@Autowired
	private CardService cardService;
	
		// ajout de carte dans le jeu
		@RequestMapping(method=RequestMethod.POST, value="/newcard")
		public void newCard(@RequestBody Card card) {
			cardService.createCard(card);
		}
		
		//Retourne une carte à partir de l'id
		@RequestMapping("/cards/{idcard}") 
		public Card getCard(@PathVariable Integer idcard) {
			Card c = cardService.getCard(idcard);
			return c;
		}
	
	
}
