package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.starchProject.model.Evenement;

public interface IEvenementRepository extends JpaRepository<Evenement, Long> {

}
