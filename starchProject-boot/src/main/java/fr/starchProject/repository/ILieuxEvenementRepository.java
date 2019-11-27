package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.starchProject.model.LieuxEvenement;

public interface ILieuxEvenementRepository extends JpaRepository<LieuxEvenement, Long> {

}
