package fr.coursspring.activite1.repository;

import fr.coursspring.activite1.modal.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepositoryy extends CrudRepository<User, Integer> {
	
	User findByUsernameAndPassword(String username, String password);
}
