package net.atos.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import net.atos.demo.persistence.domain.Cat;
import net.atos.demo.persistence.repo.CatRepo;

@Service
public class CatService {

	
	// CRUD Create Read Update Delete 
	
	private CatRepo repo;

	public CatService(CatRepo repo) {
		super();
		this.repo = repo;
	} 
	
	public Cat createCat(Cat cat) {
		return this.repo.save(cat);
		}

	public Cat getCatByID(Long id) {
		return this.repo.findById(id).get();
	}
	
	public List<Cat> getCats() {
		return this.repo.findAll(); 
		}
	
	public Cat UpdateCatById(Long id, Cat newData ) {
		Cat existing = this.repo.findById(id).get();
		existing.setAge(newData.getAge());
		existing.setBreed(newData.getBreed());
		existing.setColour(newData.getColour());
		existing.setSize(newData.getSize());		
		
		
		return this.repo.save(existing);
		
	}
	
	public boolean deleteCatById(Long id) {
		this.repo.deleteById(id);				
		boolean found = this.repo.existsById(id); // Check whether the id has been deleted
		return !found;
	} 
	
	
}
