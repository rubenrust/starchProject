package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.starchProject.model.Evenement;

@Repository
public interface IEvenementRepository extends JpaRepository<Evenement, Long>, IEvenementRepositoryCustom {

	@Query("select e.evenements from Entreprise e where e.id = :id")
	List<Evenement> findAllByEntreprise(@Param("id") Long id);
	
	@Query("select p.evenement from Participation p where p.utilisateur.id = :id")
	List<Evenement> findAllByUtilisateurId(@Param("id") Long id);
	
	@Query("select eg from Evenement e join e.groupe eg where eg.id = :id")
	List<Evenement> findAllByGroupeId(@Param("id") Long id);

}
