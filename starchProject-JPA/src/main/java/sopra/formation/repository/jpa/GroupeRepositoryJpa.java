package sopra.formation.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import sopra.formation.Groupe;
import sopra.formation.Singleton;
import sopra.formation.repository.IGroupeRepository;

public class GroupeRepositoryJpa implements IGroupeRepository {

	@Override
	public List<Groupe> findAll() {
		List<Groupe> list = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			TypedQuery<Groupe> query = em.createQuery("from Groupe", Groupe.class);

			list = query.getResultList();

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return list;
	}

	@Override
	public Groupe find(Long id) {
		Groupe obj = null;

		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			obj = em.find(Groupe.class, id);

			tx.commit();

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

		return obj;
	}

	@Override
	public Groupe save(Groupe obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			obj = em.merge(obj);

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		return obj;
	}

	@Override
	public void delete(Groupe obj) {
		EntityManager em = null;
		EntityTransaction tx = null;

		try {
			em = Singleton.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();

			tx.begin();

			em.remove(em.merge(obj));

			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}

	}


}
