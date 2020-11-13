package net.atos.demo.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.atos.demo.persistence.domain.Cat;
import net.atos.demo.service.CatService;

//@Controller
@RestController // converts to json
public class CatController {
	
	private CatService service;

	public CatController(CatService service) {
		super();
		this.service = service;
	}
	
	@RequestMapping(method = RequestMethod.GET, path ="/hello")
	public String test() {
		return "Hello World";
				
	}
	
	@PostMapping("/create")
	public ResponseEntity<Cat> createCat(@RequestBody Cat cat) {
		 return new ResponseEntity<Cat>(this.service.createCat(cat), HttpStatus.CREATED);
	}
	
	@GetMapping("/read")
	public ResponseEntity<List<Cat>> readCats() {
		return ResponseEntity.ok(this.service.getCats());
		 }
	
	@GetMapping("/read/{id}")
	public ResponseEntity<Cat>readCat(@PathVariable Long id) {
		return ResponseEntity.ok(this.service.getCatByID(id));
		}
	
	//Enum -> enumerated values
	@PutMapping("/update/{id}")
	public ResponseEntity<Cat> updateCat(@PathVariable Long id, @RequestBody Cat newData) {
		return new ResponseEntity<Cat>(this.service.UpdateCatById(id, newData), HttpStatus.ACCEPTED);
		}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<? > deleteCat(@PathVariable Long id) {
		//return this.service.deleteCatById(id);
		boolean deleted = this.service.deleteCatById(id);
		
		if (deleted) {
			return ResponseEntity.ok(deleted);
		} else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);			
			
		}
	}
}
