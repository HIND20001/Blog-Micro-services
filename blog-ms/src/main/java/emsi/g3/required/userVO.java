package emsi.g3.required;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class userVO {

    private Long id;
    private String nom;
    private String prenom;
    private String login;
    private String password;
    private String email;
    private String tel;
    private Date ddn;

}
