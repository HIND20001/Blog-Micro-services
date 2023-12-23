package emsi.g3.ws.requiredVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UtilisateurVO {
    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String email;
    private String tel;
    private Date ddn;
}




