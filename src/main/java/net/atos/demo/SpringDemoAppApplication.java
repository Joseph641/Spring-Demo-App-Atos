package net.atos.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;

//import net.atos.demo.service.CatService;

@SpringBootApplication
public class SpringDemoAppApplication {

	public static void main(String[] args) {
	SpringApplication.run(SpringDemoAppApplication.class, args);
	// doesnt need below ApplicationContext start
		//demo it works
	//ApplicationContext ac = SpringApplication.run(SpringDemoAppApplication.class, args);
	//CatService service = ac.getBean(CatService.class);
	
	//service.createCat(new Cat (null, "Devon Rex" 12, "Brown", "M")));
	//System.out.println(service.getCats());
	
	}

}
