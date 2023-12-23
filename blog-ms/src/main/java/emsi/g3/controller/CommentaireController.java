package emsi.g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emsi.g3.model.Commentaire;
import emsi.g3.service.CommentaireService;
@RestController
@RequestMapping("/blog/comments")
public class CommentaireController {

	private final CommentaireService commentaireService;
@Autowired
	public CommentaireController(CommentaireService commentaireService) {
		this.commentaireService = commentaireService;
	}
	@GetMapping
	public List<Commentaire> getAllComments(){
		return commentaireService.getAllCommentaires();
	}
	@GetMapping("{id}")
	ResponseEntity<Commentaire> getCommentById(@PathVariable Long id){
		return commentaireService.getCommentaireById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
	@PostMapping
	ResponseEntity<Commentaire> addComment(@RequestBody Commentaire comment){
		Commentaire created=commentaireService.addCommentaire(comment);
		return new ResponseEntity<>(created,HttpStatus.CREATED);
	}
	@PutMapping("{id}")
	ResponseEntity<Commentaire> updateComment(@PathVariable Long id,@RequestBody Commentaire commentaire){
		Commentaire updated=commentaireService.updateCommentaire(id, commentaire);
		return updated!=null? ResponseEntity.ok(updated):ResponseEntity.noContent().build();
	}
	@DeleteMapping("{id}")
	
	ResponseEntity<Void> deleteComment(@PathVariable Long id){
		commentaireService.deleteCommentaire(id);
    	return ResponseEntity.noContent().build();
	}
}
