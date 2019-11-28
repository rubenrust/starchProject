package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Evenement;

public interface IEvenementRepository extends JpaRepository<Evenement, Long> {

	@Query("select e from Evenement e join e.entreprise en where en.id = :id")
	List<Evenement> findAllByEntreprise(@Param("id") Long id);
	
	@Query("select p.evenement from Participation p where p.utilisateur.id = :id")
	List<Evenement> findAllByUtilisateurId(@Param("id") Long id);
	
	@Query("select e from Evenement e join e.groupe eg where eg.id = :id")
	List<Evenement> findAllByGroupeId(@Param("id") Long id);

}
