package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Participation;
import sopra.formation.repository.IParticipationRepository;

@Repository
@Transactional
public class ParticipationRepositoryJpa implements IParticipationRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Participation> findAll() {

		TypedQuery<Participation> query = em.createQuery("from Participation", Participation.class);

		return query.getResultList();

	}

	@Override
	@Transactional(readOnly = true)
	public Participation find(Long id) {

		return em.find(Participation.class, id);
	}

	@Override
	public Participation save(Participation obj) {

		return em.merge(obj);
	}

	@Override
	public void delete(Participation obj) {
		em.remove(em.merge(obj));

	}

}
