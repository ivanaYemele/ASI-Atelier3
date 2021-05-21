package jeu.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import jeu.user.model.User;



@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	public Optional<User> findByName(String name);

	public Optional<User> findByNameAndMdp(String name, String mdp);

}
