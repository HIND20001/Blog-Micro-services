package emsi.g3.required;

import emsi.g3.model.Categorie;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class articleVO {
    private Long id;
    private String titre;
    private String contenu;
    private int claps;
    private userVO userVO;
    private categorieVO categorieVo;
}
