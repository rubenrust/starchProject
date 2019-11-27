package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {

}
