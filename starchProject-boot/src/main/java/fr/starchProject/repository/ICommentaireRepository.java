package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.starchProject.model.Commentaire;

public interface ICommentaireRepository extends JpaRepository<Commentaire, Long> {

}
