package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.starchProject.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository <Utilisateur,Long> {

}
