package jeu.card.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import jeu.card.model.Card;
import jeu.card.model.*;
import jeu.card.repository.CardRepository;


@Service
public class CardService {
	
	@Autowired
	private CardRepository cardRepository;

	//Recuperation d'une carte specifique à partir dde son id
	public Card getCard(Integer id) {
		Optional<Card> cardOpt = cardRepository.findById(id);
		if (cardOpt.isPresent()) {
			return cardOpt.get();
		}else {
			return null;
		}
		
	}
	
	//Creation d'une nouvelle carte
	public void createCard (Card card) {
		Card newCard = cardRepository.save(card);
		System.out.println("Card created");
	}

	
}

