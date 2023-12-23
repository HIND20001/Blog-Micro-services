package emsi.g3.service;

import java.util.List;
import java.util.Optional;

import emsi.g3.model.Categorie;

public interface CategorieService {
	 List<Categorie> getAllCategories();
	 Optional<Categorie> getCategorieById(Long id);
	 Categorie addCategorie(Categorie categorie);
	 void deleteCategorie(Long id);
	Categorie updateCategorie(Long id,Categorie categorie);
	
}
