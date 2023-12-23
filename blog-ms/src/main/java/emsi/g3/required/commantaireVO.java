package emsi.g3.required;

import emsi.g3.model.Article;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class commantaireVO {
    private Long id;
    private String message;
    private userVO userVO;

    private articleVO articleVO;

}
