package projet.blog.Blog_ms2.Entities;

import org.junit.jupiter.api.Test;
import projet.blog.Blog_ms2.entities.Utilisateur;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class utilisateurTest {
    @Test
    public void testUserProperties() {
        Utilisateur user = new Utilisateur(1L,"ouchfi","hind","hind.ouchfi@gmail.com","hind1","p@$$word" );
        assertEquals(1L, user.getId());
        assertEquals("ouchfi", user.getNom());
        assertEquals("hind", user.getPrenom());
        assertEquals("hind.ouchfi@gmail.com", user.getEmail());
        assertEquals("hind1", user.getUsername());

        assertEquals("p@$$word", user.getPassword());
    }
}
