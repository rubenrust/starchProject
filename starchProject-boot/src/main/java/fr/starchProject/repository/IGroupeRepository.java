package fr.starchProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Groupe;

public interface IGroupeRepository extends JpaRepository <Groupe,Long>{
	
	@Query("select g.groupe from Gestion g  where g.utilisateur.id = :id")
	List<Groupe> findAllByUtilisateur(@Param("id") Long id);

}
