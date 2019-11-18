package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sopra.formation.Commentaire;
import sopra.formation.repository.ICommentaireRepository;

@Repository
@Transactional
public class CommentaireRepositoryJpa implements ICommentaireRepository {

	@PersistenceContext
	private EntityManager em;

	@Override
	@Transactional(readOnly = true)
	public List<Commentaire> findAll() {

		TypedQuery<Commentaire> query = em.createQuery("from Commentaire", Commentaire.class);

		return query.getResultList();
	}

	@Override
	@Transactional(readOnly = true)
	public Commentaire find(Long id) {

		return em.find(Commentaire.class, id);
	}

	@Override
	@Transactional
	public Commentaire save(Commentaire obj) {

		return em.merge(obj);
	}

	@Override
	@Transactional
	public void delete(Commentaire obj) {

		em.remove(em.merge(obj));

	}

}
