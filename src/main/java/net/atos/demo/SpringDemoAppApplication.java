package net.atos.demo;

//import java.util.ArrayList;
//import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

//import net.atos.demo.persistence.domain.Cat;
//import net.atos.demo.persistence.domain.Cat;
//import net.atos.demo.persistence.repo.CatRepo;
//import net.atos.demo.service.CatService;

@SpringBootApplication
public class SpringDemoAppApplication {

	public static void main(String[] args) {
	//Below is normal way of doing it
		SpringApplication.run(SpringDemoAppApplication.class, args);
	
		//below uses extra methods to show it working
		
	//	ApplicationContext ac = SpringApplication.run(SpringDemoAppApplication.class, args);
	//CatService service = ac.getBean(CatService.class);
	
	//service.createCat(new Cat(null, "Shiba Inu", 12, "Bown", "M" ));
	//System.out.println(service.getCats()); 
	
	}

}
