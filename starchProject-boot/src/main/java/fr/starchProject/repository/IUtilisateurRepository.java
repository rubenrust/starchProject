package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository <Utilisateur,Long> {

	@Query("select p.utilisateur from Participation p where p.evenement.id = :id and p.type = 'Interesse'")
	List<Utilisateur> findAllByEvenementAndInteresse(@Param("id") Long id);
	
	@Query("select p.utilisateur from Participation p where p.evenement.id = :id and p.type != 'Interesse'")
	List<Utilisateur> findAllByEvenementAndParticipant(@Param("id") Long id);
	
	@Query("select g.utilisateur from Gestion g where g.groupe.id = :id")
	List<Utilisateur> findAllByGroupeId(@Param("id") Long id);
	
	@Query("select u from Utilisateur u where u.identifiant = :identifiant ")
	Utilisateur findByIdentifiant(@Param("identifiant") String identifiant);
}
