package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Gestion;
import sopra.formation.Groupe;
import sopra.formation.Singleton;
import sopra.formation.repository.IGroupeRepository;

@Repository
@Transactional
public class GroupeRepositoryJpa implements IGroupeRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Groupe> findAll() {

		TypedQuery<Groupe> query = em.createQuery("from Groupe", Groupe.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Groupe find(Long id) {

		return em.find(Groupe.class, id);
	}

	@Override
	public Groupe save(Groupe obj) {

		return em.merge(obj);
	}

	@Override
	public void delete(Groupe obj) {
		em.remove(em.merge(obj));

	}

}
