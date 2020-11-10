package net.atos.demo.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.atos.demo.persistence.domain.Cat;

@Repository
public interface CatRepo extends JpaRepository<Cat, Long> {
	

}
