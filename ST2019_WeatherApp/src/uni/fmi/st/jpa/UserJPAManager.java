package uni.fmi.st.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import uni.fmi.st.models.User;

public class UserJPAManager {
	
	private EntityManager em;
	
	private EntityManager getEntityManager() {
		if(null ==em) {
			final EntityManagerFactory emf = 
					Persistence.createEntityManagerFactory("H2DB");
			return  emf.createEntityManager();
		}
		return em;
	}
	
	public void addUser(final User user) {
		final EntityManager entityManager = getEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		//entityManager.close();
	}
	
	public User findUser(final String email, final String password) {
	final String sql = "SELECT u FROM "+ User.class.getName()+" u WHERE u.email= :email"
			+ " AND u.password = :pass";
		final EntityManager entityManager = getEntityManager();
		final TypedQuery<User> query = entityManager
								.createQuery(sql, User.class);
		query.setParameter("email", email);
		query.setParameter("pass", password);
		final List<User> resultList = query.getResultList();
		if (resultList.size() == 1) {
			return resultList.get(0);
		}
		return null;
	}

}
