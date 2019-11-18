package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Favoris;
import sopra.formation.repository.IFavorisRepository;

@Repository
@Transactional
public class FavorisRepositoryJpa implements IFavorisRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Favoris> findAll() {

		TypedQuery<Favoris> query = em.createQuery("from Favoris", Favoris.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Favoris find(Long id) {

		return em.find(Favoris.class, id);
	}

	@Override
	public Favoris save(Favoris obj) {

		return em.merge(obj);
	}

	@Override
	public void delete(Favoris obj) {

		em.remove(em.merge(obj));

	}

}
