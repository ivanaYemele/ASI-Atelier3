package jeu.card.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jeu.card.model.*;


@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

	public Optional<Card> findById(int id) ;
}
