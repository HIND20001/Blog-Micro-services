package projet.blog.Blog_authms.Entities;

import org.junit.jupiter.api.Test;
import projet.blog.Blog_authms.entities.Utilisateur;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static projet.blog.Blog_authms.entities.Role.ADMIN;
import static projet.blog.Blog_authms.entities.Role.USER;


public class utilisateurTest {
    @Test
    public void testUserProperties() {

        Utilisateur user = new Utilisateur(1L,"maysae1","p@$$word" ,"jabbar","mayssae","jabbar.mayssae@gmail.com" ,USER);
        assertEquals(1L, user.getId());
        assertEquals("jabbar", user.getNom());
        assertEquals("mayssae", user.getPrenom());
        assertEquals("jabbar.mayssae@gmail.com", user.getEmail());
        assertEquals("maysae1", user.getUsername());

        assertEquals("p@$$word", user.getPassword());
        assertEquals(USER, user.getRole());
    }
}
