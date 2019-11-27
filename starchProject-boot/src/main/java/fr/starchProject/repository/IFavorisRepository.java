package fr.starchProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Favoris;

public interface IFavorisRepository extends JpaRepository<Favoris, Long>{

	@Query("select uf from Utilisateur u join u.favoris uf where u.id = :id")
	Favoris findByUtilisateurId(@Param("id") Long id);
}
