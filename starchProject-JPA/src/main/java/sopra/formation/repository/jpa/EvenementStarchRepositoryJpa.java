package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.EvenementStarch;
import sopra.formation.repository.IEvenementStarchRepository;

@Repository
@Transactional
public class EvenementStarchRepositoryJpa implements IEvenementStarchRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<EvenementStarch> findAll() {

		TypedQuery<EvenementStarch> query = em.createQuery("from EvenementStarch", EvenementStarch.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public EvenementStarch find(Long id) {

		return em.find(EvenementStarch.class, id);
	}

	@Override
	public EvenementStarch save(EvenementStarch obj) {

		return em.merge(obj);
	}

	@Override
	public void delete(EvenementStarch obj) {

		em.remove(em.merge(obj));

	}

}
