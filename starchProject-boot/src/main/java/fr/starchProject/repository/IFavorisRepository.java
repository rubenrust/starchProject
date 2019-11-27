package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.starchProject.model.Favoris;

public interface IFavorisRepository extends JpaRepository<Favoris, Long>{

}
