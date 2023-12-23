package emsi.g3.required;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class categorieVO {
    private Long id;
    private String nom;
    private String description;
}
