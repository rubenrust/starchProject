package fr.starchProject.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.starchProject.model.Entreprise;


public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long>{
	
}
