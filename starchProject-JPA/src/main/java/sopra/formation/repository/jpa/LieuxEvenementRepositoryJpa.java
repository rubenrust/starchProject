package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Groupe;
import sopra.formation.LieuxEvenement;
import sopra.formation.Singleton;
import sopra.formation.repository.ILieuxEvenementRepository;

@Repository
@Transactional
public class LieuxEvenementRepositoryJpa implements ILieuxEvenementRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<LieuxEvenement> findAll() {

		TypedQuery<LieuxEvenement> query = em.createQuery("from LieuxEvenement", LieuxEvenement.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public LieuxEvenement find(Long id) {

		return em.find(LieuxEvenement.class, id);
	}

	@Override
	public LieuxEvenement save(LieuxEvenement obj) {
		return em.merge(obj);
	}

	@Override
	public void delete(LieuxEvenement obj) {
		em.remove(em.merge(obj));
	}

}
