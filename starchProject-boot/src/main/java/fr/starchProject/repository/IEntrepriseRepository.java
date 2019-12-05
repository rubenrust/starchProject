package fr.starchProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Entreprise;


public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long>{
	
	@Query("select e from Entreprise e left join e.collaborateurs u where u.id = :id")
	Entreprise findEntrepriseByUtilisateurId(@Param("id") Long id);
}
