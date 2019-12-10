package fr.starchProject.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.starchProject.model.Entreprise;
import fr.starchProject.model.Evenement;
import fr.starchProject.model.Groupe;
import fr.starchProject.model.NomEvenement;
import fr.starchProject.model.TypeEvenement;

@Repository
public class IEvenementRepositoryCustomImpl implements IEvenementRepositoryCustom {
	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Evenement> search(SearchCriteria searchCriteria) {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Evenement> criteriaQuery = cb.createQuery(Evenement.class);

		Root<Evenement> e = criteriaQuery.from(Evenement.class);

		criteriaQuery.select(e); // select e from Evenement e

		Predicate p = cb.equal(cb.literal(1), 1);
		
		if(searchCriteria.getIdEntreprise() != null) {
			Join<Evenement, Entreprise> en = e.join("entreprise");
			ParameterExpression<Long> idEntreprise = cb.parameter(Long.class, "idEntreprise");
			
			cb.and(cb.equal(en.get("id"), idEntreprise));
			
			p = cb.and(p, cb.equal(en.get("id"), idEntreprise));
		}

		if (searchCriteria.getIdGroupe() != null) {
			Join<Evenement, Groupe> g = e.join("groupe");
			ParameterExpression<Long> idGroupe = cb.parameter(Long.class, "idGroupe");

			cb.and(cb.equal(g.get("id"), idGroupe)); // where groupe.id = :idGroupe
			
			p = cb.and(p, cb.equal(g.get("id"), idGroupe));

		}
		
		if(searchCriteria.getTypeEvenement() != null) {
			ParameterExpression<TypeEvenement> typeEvent = cb.parameter(TypeEvenement.class, "typeEvenement");
			
			cb.and(cb.equal(e.get("typeEvenement"), typeEvent));
			
			p = cb.and(p, cb.equal(e.get("typeEvenement"), typeEvent));
		}
		
		if(searchCriteria.getNomEvenement() != null) {
			ParameterExpression<NomEvenement> nomEvent = cb.parameter(NomEvenement.class, "nomEvenement");
			
			cb.and(cb.equal(e.get("nomEvenement"), nomEvent));
			
			p = cb.and(p, cb.equal(e.get("nomEvenement"), nomEvent));
		}
		
		criteriaQuery.where(p);

		System.out.println(criteriaQuery.toString());

		TypedQuery<Evenement> query = em.createQuery(criteriaQuery);
		
		if(searchCriteria.getIdEntreprise() != null) {
			query.setParameter("idEntreprise", searchCriteria.getIdEntreprise());
		}
		
		if (searchCriteria.getIdGroupe() != null) {
			query.setParameter("idGroupe", searchCriteria.getIdGroupe());
		}
		
		if(searchCriteria.getTypeEvenement() != null) {
			query.setParameter("typeEvenement", searchCriteria.getTypeEvenement());
		}
		
		if(searchCriteria.getNomEvenement() != null) {
			query.setParameter("nomEvenement", searchCriteria.getNomEvenement());
		}

		return query.getResultList();
	}
}
