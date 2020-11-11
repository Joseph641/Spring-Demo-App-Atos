package net.atos.demo.rest;

import java.util.List;

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
	public Cat createCat(@RequestBody Cat cat) {
		 return this.service.createCat(cat);
	}
	
	@GetMapping("/read")
	public List<Cat> readCats() {
		return this.service.getCats();
		 }
	
	@GetMapping("/read/{id}")
	public Cat readCat(@PathVariable Long id) {
		return this.service.getCatByID(id);
		}
	
	@PutMapping("/update/{id}")
	public Cat updateCat(@PathVariable Long id, @RequestBody Cat newData) {
		
		return this.service.UpdateCatById(id, newData);
		
				
	}
	
	@DeleteMapping("/delete/{id}")
	public boolean deleteCat(@PathVariable Long id) {
		return this.service.deleteCatById(id);
	}
}
