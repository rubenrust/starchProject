package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Participation;

public interface IParticipationRepository extends JpaRepository <Participation,Long> {

	@Query("select p from Participation p where p.utilisateur.id = :id")
	List<Participation> findParticipationByUtilisateur(@Param("id") Long id);

	
	
	@Query("select p from Participation p where p.utilisateur.id = :iduser and p.evenement.id = :idevent")
	Participation findParticipationByUtilisateurAndEvent(@Param("iduser") Long iduser, @Param("idevent") Long idevent );
	
}
