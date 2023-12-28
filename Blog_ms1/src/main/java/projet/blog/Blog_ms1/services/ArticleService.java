package projet.blog.Blog_ms1.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import projet.blog.Blog_ms1.entities.Article;
import projet.blog.Blog_ms1.entities.Utilisateur;
import projet.blog.Blog_ms1.models.ArticleResponse;
import projet.blog.Blog_ms1.repositories.ArticleRepository;

import java.util.Arrays;
import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    RestTemplate restTemplate;
    private final String URL="http://localhost:8083";

    public List<ArticleResponse> FindAll(){
         List<Article> articles=articleRepository.findAll();
        ResponseEntity<Utilisateur[]> response=restTemplate.getForEntity(this.URL+"/users/auth",
                Utilisateur[].class);
        Utilisateur[] user=response.getBody();

        return articles.stream().map((Article a)->mapToArticleResponse(a,user)).toList();
    }

    private ArticleResponse mapToArticleResponse(Article a, Utilisateur[] users) {
        Utilisateur founduser= Arrays.stream(users).filter(user->user.getId().equals(a.getAuteur()))
                .findFirst().orElse(null);
        return ArticleResponse.builder().id(a.getId()).titre(a.getTitre()).auteur(founduser).categorie(a.getCategorie())
                .contenu(a.getContenu()).build();
    }

    public ArticleResponse FindById(Long id) throws Exception{

        Article article = articleRepository.findById(id).orElseThrow(() -> new Exception("ID article not found"));
        Utilisateur auteur = restTemplate.getForObject(this.URL + "/users/auth/" + article.getAuteur(), Utilisateur.class);
        return ArticleResponse.builder().id(article.getId()).titre(article.getTitre()).auteur(auteur).categorie(article.getCategorie())
                .contenu(article.getContenu()).build(); }
    public  void AddArticle(Article article){
        articleRepository.save(article);
    }
    public ArticleResponse UpdateArticle(Article updatedArticle){
        Article oldArticle=articleRepository.findById(updatedArticle.getId()).orElse(null);

        if(oldArticle!=null){
            oldArticle.setContenu(updatedArticle.getContenu());
            oldArticle.setTitre(updatedArticle.getTitre());
            oldArticle.setClaps(updatedArticle.getClaps());
            oldArticle.setUrlphoto(updatedArticle.getUrlphoto());
            oldArticle.setCategorie(updatedArticle.getCategorie());
            articleRepository.save(oldArticle);
        }
        Utilisateur auteur = restTemplate.getForObject(this.URL + "/users/auth/C" + oldArticle.getAuteur(), Utilisateur.class);

        return ArticleResponse.builder().id(oldArticle.getId()).titre(oldArticle.getTitre()).auteur(auteur).categorie(oldArticle.getCategorie())
                .contenu(oldArticle.getContenu()).build();

    }
    public void DeleteArticle(Long id){
        Article deletedArticle=articleRepository.findById(id).orElse(null);
        if (deletedArticle!=null)
            articleRepository.delete(deletedArticle);
    }
    public Utilisateur getArticleAuteur(Long id){
        Article article=articleRepository.findById(id).orElse(null);
        Utilisateur auteur = restTemplate.getForObject(this.URL + "/users/auth/" + article.getAuteur(), Utilisateur.class);
        return auteur;
    }
}
