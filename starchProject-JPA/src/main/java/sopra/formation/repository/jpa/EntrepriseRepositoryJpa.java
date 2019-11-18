package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Entreprise;
import sopra.formation.repository.IEntreprisesRepository;

@Repository
@Transactional
public class EntrepriseRepositoryJpa implements IEntreprisesRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Entreprise> findAll() {

		TypedQuery<Entreprise> query = em.createQuery("from Entreprise", Entreprise.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Entreprise find(Long id) {

		return em.find(Entreprise.class, id);
	}

	@Override
	public Entreprise save(Entreprise obj) {

		return em.merge(obj);
	}

	@Override
	public void delete(Entreprise obj) {

		em.remove(em.merge(obj));

	}

}
