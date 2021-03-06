package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {

	@Query("select distinct e.commentaires from Evenement e join e.commentaires ec where e.id = :id")
	List<Commentaire> findAllByEvenement(@Param("id") Long id);

}
