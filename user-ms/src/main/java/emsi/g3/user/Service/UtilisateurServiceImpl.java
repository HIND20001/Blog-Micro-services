package emsi.g3.user.Service;

import java.util.List;
import java.util.Optional;

import emsi.g3.user.Models.Utilisateur;
import emsi.g3.user.Repository.UtilisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UtilisateurServiceImpl implements UtilisateurService {
@Autowired
UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> getAllUsers() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}

	@Override
	public Optional<Utilisateur> getUserById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(utilisateurRepository.getById(id));
	}
	@Override
	public Optional<Utilisateur> findByemail(String email){

		return Optional.ofNullable(utilisateurRepository.findByemail( email));
	}

	@Override
	public Utilisateur addUser(Utilisateur user) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(user);
	}

	@Override
	public Utilisateur updateUser(Long id,Utilisateur user) {
		Utilisateur olduser=utilisateurRepository.findById(id).orElse(null);
		olduser.setNom(user.getNom());
		olduser.setPrenom(user.getPrenom());
		olduser.setEmail(user.getEmail());
		olduser.setLogin(user.getLogin());
		olduser.setPassword(user.getPassword());
		olduser.setTel(user.getTel());
		olduser.setDdn(user.getDdn());
		//olduser.setComments(user.getComments());
	//	olduser.setPosts(user.getPosts());
		utilisateurRepository.save(olduser);
		return olduser;
	}

	@Override
	public void deleteUser(Long id) {
utilisateurRepository.delete(utilisateurRepository.getById(id));		
	}

}
