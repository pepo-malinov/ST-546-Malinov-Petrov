package uni.fmi.st.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import uni.fmi.st.models.User;

public class UserJPAManager extends JPAManager<User> {
	

	public UserJPAManager() {
		super(User.class);
	}

	public User findUser(final String email, final String password) {
		final String sql = "SELECT u FROM " + User.class.getName() + " u WHERE u.email= :email"
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

	public boolean userExists(final String email) {
		final String sql = "SELECT COUNT(u) FROM " + User.class.getName()
						+ " u WHERE u.email= :email";
		final EntityManager entityManager = getEntityManager();
		final TypedQuery<Long> query = entityManager
				.createQuery(sql, Long.class);
		query.setParameter("email", email);
		boolean result = query.getSingleResult() > 0;
		return result;
	}

}
