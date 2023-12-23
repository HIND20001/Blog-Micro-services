package emsi.g3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emsi.g3.model.Commentaire;
import emsi.g3.repository.CommentaireRepository;
@Service
public class CommentaireServiceImpl implements CommentaireService{
@Autowired
	private CommentaireRepository commentaireRepository;
	@Override
	public List<Commentaire> getAllCommentaires() {
		return commentaireRepository.findAll();
	}

	@Override
	public Optional<Commentaire> getCommentaireById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(commentaireRepository.getById(id));
	}

	@Override
	public Commentaire addCommentaire(Commentaire commentaire) {
		// TODO Auto-generated method stub
		return commentaireRepository.save(commentaire);
	}

	@Override
	public Commentaire updateCommentaire(Long id,Commentaire commentaire) {
		Commentaire oldCommentaire=commentaireRepository.getById(id);
		oldCommentaire.setMessage(commentaire.getMessage());
		//oldCommentaire.setProprietaire(commentaire.getProprietaire());
		oldCommentaire.setArticle(commentaire.getArticle());
		commentaireRepository.save(oldCommentaire);
		return oldCommentaire;
	}

	@Override
	public void deleteCommentaire(Long id) {
commentaireRepository.delete(commentaireRepository.getById(id));		
	}

}
