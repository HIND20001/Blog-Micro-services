package emsi.g3.service;

import java.util.List;
import java.util.Optional;

import emsi.g3.model.Commentaire;

public interface CommentaireService {
	 List<Commentaire> getAllCommentaires();
	 Optional<Commentaire> getCommentaireById(Long id);
	 Commentaire addCommentaire(Commentaire commentaire);
	 Commentaire updateCommentaire(Long id,Commentaire commentaire);
	 void deleteCommentaire(Long id);
}
