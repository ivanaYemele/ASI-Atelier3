package jeu.card.repository;

package asi.game.cartes.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import asi.game.cartes.model.Card;

@Repository
public interface CardRepository extends CrudRepository<Card, Integer> {

	public Optional<Card> findById(int id) ;
}
public interface CardRepository {

}
