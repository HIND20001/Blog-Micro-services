package emsi.g3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import emsi.g3.model.Categorie;
import emsi.g3.service.CategorieService;
@RestController
@RequestMapping("/blog/categories")
public class CategorieControlleur {
	@Autowired
	private final CategorieService categorieService;
	public CategorieControlleur(CategorieService categorieService) {
		this.categorieService = categorieService;
	}
	@GetMapping
	List<Categorie> getAllCategories(){
		return categorieService.getAllCategories();
	}
    @GetMapping("/{id}")
    ResponseEntity<Categorie> getCatById(@PathVariable Long id){
		return categorieService.getCategorieById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
    	
    }
    @PostMapping
    ResponseEntity<Categorie> addCategorie(@RequestBody Categorie categorie){
    Categorie createdUser=categorieService.addCategorie(categorie);
    return new ResponseEntity<>(createdUser,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    ResponseEntity<Categorie> updateCategorie(@PathVariable Long id,@RequestBody Categorie categorie){
    	Categorie updated=categorieService.updateCategorie(id,categorie);
    	return updated!=null?
    			ResponseEntity.ok(updated):
    				ResponseEntity.noContent().build();
    			
    }
    @DeleteMapping("/{id}")
    ResponseEntity<Void>  deleteCategorie(@PathVariable Long id){
    	categorieService.deleteCategorie(id);
    	return ResponseEntity.noContent().build();
    }
    
    
    
}
