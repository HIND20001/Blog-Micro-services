package emsi.g3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import emsi.g3.model.Categorie;
import emsi.g3.repository.CategorieRepository;
@Service
public class CategorieServiceImpl implements CategorieService{
@Autowired
CategorieRepository categorieRepository;
	
@Override
public List<Categorie> getAllCategories() {
	// TODO Auto-generated method stub
	return categorieRepository.findAll();
}

@Override
public Optional<Categorie> getCategorieById(Long id) {
	// TODO Auto-generated method stub
	return Optional.ofNullable(categorieRepository.getById(id));
}

@Override
public Categorie addCategorie(Categorie categorie) {
	// TODO Auto-generated method stub
	return categorieRepository.save(categorie);
}

@Override
public Categorie updateCategorie(Long id,Categorie categorie) {
	Categorie oldCategorie=categorieRepository.getById(id);
	oldCategorie.setNom(categorie.getNom());
	oldCategorie.setDescription(categorie.getDescription());
	categorieRepository.save(oldCategorie);
	return oldCategorie;
}

@Override
public void deleteCategorie(Long id) {
categorieRepository.delete(categorieRepository.getById(id));	
}

}
