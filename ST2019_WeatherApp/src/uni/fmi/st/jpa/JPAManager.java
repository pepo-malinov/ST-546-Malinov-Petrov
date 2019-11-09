package uni.fmi.st.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import uni.fmi.st.models.Post;
import uni.fmi.st.models.User;

public abstract class JPAManager<T> {
	private Class<T> type;

	public JPAManager(Class<T> type) {
		this.type = type;
	}

	EntityManager getEntityManager() {
		final EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("H2DB");
		return emf.createEntityManager();

	}

	public void remove(final Integer id) {
		EntityManager entityManager = getEntityManager();
		T reference = entityManager.getReference(type, id);
		if (null != reference) {
			entityManager.remove(reference);
		}
	}
	
	public void add(final T entity) {
		final EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	public void update(final T entity) {
		final EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
