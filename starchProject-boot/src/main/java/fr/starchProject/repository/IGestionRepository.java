package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Gestion;

public interface IGestionRepository extends JpaRepository <Gestion,Long>{

	
	@Query("select g from Gestion g join fetch g.groupes gg where g.id = :id")
	List<Gestion> findGestionWithGroupe(@Param("id") Long id);
}
