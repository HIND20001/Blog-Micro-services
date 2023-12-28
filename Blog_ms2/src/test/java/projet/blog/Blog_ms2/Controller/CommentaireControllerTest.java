package projet.blog.Blog_ms2.Controller;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import projet.blog.Blog_ms2.entities.Commentaire;
import projet.blog.Blog_ms2.models.CommentaireResponse;
import projet.blog.Blog_ms2.services.CommentaireService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class CommentaireControllerTest {


    private int port=8082;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CommentaireService commentaireService;

    @BeforeEach
    public void setUp() {
        // Ajoutez des commentaires pour les tests
        Commentaire commentaire1 = new Commentaire();
        commentaire1.setContenu("Contenu du commentaire 1");
        commentaire1.setIdUser(1L);
        commentaire1.setIdArticle(1L);
        commentaireService.AddCommentaire(commentaire1);

        Commentaire commentaire2 = new Commentaire();
        commentaire2.setContenu("Contenu du commentaire 2");
        commentaire2.setIdUser(2L);
        commentaire2.setIdArticle(2L);
        commentaireService.AddCommentaire(commentaire2);
    }

    @Test
    public void testGetAllComments() {
        ResponseEntity<CommentaireResponse[]> response = restTemplate.getForEntity("http://localhost:" + port + "/comments", CommentaireResponse[].class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        CommentaireResponse[] commentaires = response.getBody();
        assertNotNull(commentaires);
        // Ajoutez d'autres assertions en fonction de la réponse attendue
    }

    @Test
    public void testGetCommentById() {
        long commentIdToFind = 1L; // ID du commentaire à rechercher
        ResponseEntity<CommentaireResponse> response = restTemplate.getForEntity("http://localhost:" + port + "/comments/" + commentIdToFind, CommentaireResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        CommentaireResponse commentaire = response.getBody();
        assertNotNull(commentaire);
        // Ajoutez d'autres assertions si nécessaire après avoir trouvé le commentaire
    }

    @Test
    public void testAddComment() {
        Commentaire newComment = new Commentaire();
        newComment.setContenu("Nouveau commentaire");
        newComment.setIdUser(3L);
        newComment.setIdArticle(3L);

        ResponseEntity<Void> response = restTemplate.postForEntity("http://localhost:" + port + "/comments", newComment, Void.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        // Ajoutez d'autres assertions si nécessaire après l'ajout du commentaire
    }

    @Test
    public void testDeleteComment() {
        long commentIdToDelete = 2L; // ID du commentaire à supprimer
        restTemplate.delete("http://localhost:" + port + "/comments/" + commentIdToDelete);

        // Vérifiez si le commentaire a été supprimé en effectuant une autre requête pour récupérer le commentaire
    }

    @Test
    public void testUpdateComment() {
        long commentIdToUpdate = 1L; // ID du commentaire à mettre à jour
        Commentaire updatedComment = new Commentaire();
        updatedComment.setContenu("Nouveau contenu pour le commentaire");

        ResponseEntity<CommentaireResponse> response = restTemplate.exchange(
                "http://localhost:" + port + "/comments/" + commentIdToUpdate,
                HttpMethod.PUT, new HttpEntity<>(updatedComment), CommentaireResponse.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        CommentaireResponse updated = response.getBody();
        assertNotNull(updated);
        assertEquals("Nouveau contenu pour le commentaire", updated.getContenu());

    }
}
