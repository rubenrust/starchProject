package fr.starchProject.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.starchProject.model.Entreprise;


public interface IEntrepriseRepository extends JpaRepository<Entreprise, Long>{
	
	
	
	
	@Query("from Entreprise")
	List<Entreprise> findAllEntreprise();
	
	@Query("select e from Entreprise e where e.id =: id")
	Entreprise findByid(@Param("id") Long id);
	
	
//	@Query("select ")
//	Entreprise findAllbyEntreprise(@Param("id") Long id);

	@Query("select distinct f from Filiere f left join fetch f.referent r where f.id = :id")
	Entreprise findWithGroupe(@Param("id") Long id);  //a mettre en commentaire après
	
//	@Query("select distinct f from Filiere f left join fetch f.referent r where f.id = :id")
//	Entreprise findWithUtilisateur(@Param("id") Long id);


}
