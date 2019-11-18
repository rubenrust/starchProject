package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Evenement;
import sopra.formation.repository.IEvenementRepository;

@Repository
@Transactional
public class EvenementRepositoryJpa implements IEvenementRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Evenement> findAll() {

		TypedQuery<Evenement> query = em.createQuery("from Evenement", Evenement.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Evenement find(Long id) {

		return em.find(Evenement.class, id);
	}

	@Override
	public Evenement save(Evenement obj) {

		return em.merge(obj);
	}

	@Override
	public void delete(Evenement obj) {

		em.remove(em.merge(obj));

	}

}
