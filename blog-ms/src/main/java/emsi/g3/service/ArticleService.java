package emsi.g3.service;

import java.util.List;
import java.util.Optional;

import emsi.g3.model.Article;

public interface ArticleService {

    List<Article> getAllArticles();

    Optional<Article> getArticleById(Long id);

    //Recupérer les articles commentés
    List<Article> getCommentedArticles();

    Article addArticle(Article article);

    Article updateArticle(Long id, Article article);

    void deleteArticle(Long id);

    List<Article> findByIdU(long idU);
    //Recupérer les articles d'un utilisateur
    // List<Article> getUsersArticle(Utilisateur u);


}
