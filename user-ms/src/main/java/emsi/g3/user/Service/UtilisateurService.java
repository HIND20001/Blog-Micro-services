package emsi.g3.user.Service;

import emsi.g3.user.Models.Utilisateur;

import java.util.List;
import java.util.Optional;

//import emsi.g3.model.Article;

public interface UtilisateurService {
	List<Utilisateur> getAllUsers();
	 Optional<Utilisateur> getUserById(Long id);
	public Optional<Utilisateur> findByemail(String emai);
	 Utilisateur addUser(Utilisateur user);
	 Utilisateur updateUser(Long id,Utilisateur user);
	 void deleteUser(Long id);
	
}
