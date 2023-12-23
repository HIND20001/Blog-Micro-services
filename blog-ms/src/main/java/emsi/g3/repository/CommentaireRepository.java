package emsi.g3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import emsi.g3.model.Commentaire;
@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long>{

}
