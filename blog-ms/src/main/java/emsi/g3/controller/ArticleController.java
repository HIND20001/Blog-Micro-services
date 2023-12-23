package emsi.g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import emsi.g3.model.Article;
import emsi.g3.service.ArticleService;
@RestController
@RequestMapping("/blog/articles")
public class ArticleController {
	 private final ArticleService articleService;

	    @Autowired
	    public ArticleController(ArticleService articleService) {
	        this.articleService = articleService;
	    }

	    @GetMapping
	    public List<Article> getAllArticles() {
	        return articleService.getAllArticles();
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Article> getArticleById(@PathVariable Long id) {
	        return articleService.getArticleById(id)
	                .map(ResponseEntity::ok)
	                .orElse(ResponseEntity.notFound().build());
	    }

	    @PostMapping
	    public ResponseEntity<Article> addArticle(@RequestBody Article article) {
	        Article createdArticle = articleService.addArticle(article);
	        return new ResponseEntity<>(createdArticle, HttpStatus.CREATED);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @RequestBody Article updatedArticle) {
	        Article updated = articleService.updateArticle(id, updatedArticle);
	        return updated != null ?
	                ResponseEntity.ok(updated) :
	                ResponseEntity.notFound().build();
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
	        articleService.deleteArticle(id);
	        return ResponseEntity.noContent().build();
	    }
}
