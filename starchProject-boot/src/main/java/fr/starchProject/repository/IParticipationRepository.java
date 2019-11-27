package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.starchProject.model.Participation;

public interface IParticipationRepository extends JpaRepository <Participation,Long> {

}
