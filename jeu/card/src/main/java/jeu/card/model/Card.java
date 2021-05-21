package jeu.card.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
public class Card implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private double price;
	private int valueCard; //valeur de la carte dans le jeu : 1 2 3 (-importante à +importante)
	
	
	public Card() {
		super();
	}
	
	public Card(int id, String name, double price, int valueCard) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.valueCard = valueCard;
		
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public int getValueCard() {
		return valueCard;
	}
	
	public void setValueCard(int valueCard) {
		this.valueCard = valueCard;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
}

