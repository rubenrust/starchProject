package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Gestion;
import sopra.formation.Singleton;
import sopra.formation.repository.IGestionRepository;

@Repository
@Transactional

public class GestionRepositoryJpa implements IGestionRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Gestion> findAll() {

		TypedQuery<Gestion> query = em.createQuery("from Gestion", Gestion.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Gestion find(Long id) {
		return em.find(Gestion.class, id);
	}

	@Override
	public Gestion save(Gestion obj) {

		return em.merge(obj);
	}

	@Override
	public void delete(Gestion obj) {
		em.remove(em.merge(obj));
	}
}
