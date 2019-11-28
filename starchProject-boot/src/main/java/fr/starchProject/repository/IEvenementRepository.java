package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Evenement;
import fr.starchProject.model.Participation;

public interface IEvenementRepository extends JpaRepository<Evenement, Long> {

	@Query("select e from Evenement e join e.entreprise en where en.id = :id")
	List<Evenement> findAllByEntreprise(@Param("id") Long id);
	
	@Query("select p from Participation p where p.utilisateur.id = :id")
//	@Query("select e from Evenement e join e.participations p join p.utilisateur u where u.id = :id")
	List<Participation> findAllByUtilisateurId(@Param("id") Long id);
	
	@Query("select e from Evenement e join e.groupe eg where eg.id = :id")
	List<Evenement> findAllByGroupeId(@Param("id") Long id);

}
