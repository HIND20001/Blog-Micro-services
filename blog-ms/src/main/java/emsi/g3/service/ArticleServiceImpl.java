package emsi.g3.service;

import java.util.List;
import java.util.Optional;


import emsi.g3.model.Article;
import emsi.g3.repository.ArticleRepository;
import emsi.g3.required.UserRequired;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	ArticleRepository articleRepository;
	@Autowired
	UserRequired userRequired;
	@Override
	public List<Article> getAllArticles() {
		// TODO Auto-generated method stub
		return articleRepository.findAll();
	}

	@Override
	public Optional<Article> getArticleById(Long id) {
		// TODO Auto-generated method stub
		return Optional.ofNullable(articleRepository.getById(id));
	}

	@Override
	public List<Article> getCommentedArticles() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Article addArticle(Article article) {
		if (userRequired.findById(article.getIdU()) != null){
			return articleRepository.save(article);
		}else return null;
	}

	@Override
	public Article updateArticle(Long id,Article article) {
		// TODO Auto-generated method stub
		Article oldArticle= articleRepository.findById(id).orElse(null);
		  oldArticle.setTitre(article.getTitre());
		  oldArticle.setIdU(article.getIdU());
		  oldArticle.setCategorie(article.getCategorie());
		  oldArticle.setContenu(article.getContenu());
		  oldArticle.setClaps(article.getClaps());
		  oldArticle.setComments(article.getComments());
		  articleRepository.save(oldArticle);
		 return oldArticle;

	}

	@Override
	public void deleteArticle(Long id) {
      articleRepository.delete(articleRepository.getById(id));
	}

	@Override
	public List<Article> findByIdU(long idU) {
		if (userRequired.findById(idU) != null){
			return articleRepository.findByIdU(idU);
		}else return null;
	}


	/*@Override
	public List<Article> getUsersArticle(Utilisateur u) {
		return u.getPosts();
	}*/

}
