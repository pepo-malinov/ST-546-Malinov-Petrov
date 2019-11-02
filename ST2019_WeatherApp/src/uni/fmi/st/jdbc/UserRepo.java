package uni.fmi.st.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import uni.fmi.st.models.User;

public class UserRepo {

	/**
	 * Add new user to DB
	 * 
	 * @param newUser Not {@code NULL} instance of {@link User}
	 * @return {@code TRUE} if the user is added to db.
	 */
	public boolean addUser(final User newUser) {

		final String sql = "INSERT INTO USER (USERNAME, EMAIL, PASSWORD) " + "VALUES(?,?,?)";
		Connection connection = DBManager.getInstance().getConnection();
		PreparedStatement prepareStatement = null;
		try {
			prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setString(1, newUser.getUsername());
			prepareStatement.setString(2, newUser.getEmail());
			prepareStatement.setString(3, newUser.getPassword());
			if (prepareStatement.executeUpdate() == 1) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (null != prepareStatement) {
				try {
					prepareStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			DBManager.getInstance().closeConnection();
		}
		return false;
	}

	public User findUser(final String email, final String password) {
		final String sql = "SELECT * FROM USER WHERE EMAIL=? " 
							+ "AND PASSWORD=?;";
		PreparedStatement prepareStatement = null;
		ResultSet resultSet = null;
		try {
			prepareStatement = DBManager.getInstance().getConnection().prepareStatement(sql);
			prepareStatement.setString(1, email);
			prepareStatement.setString(2, password);
			resultSet = prepareStatement.executeQuery();
			if (resultSet.next()) {
				final User user = new User();
				user.setEmail(resultSet.getString("EMAIL"));
				user.setUsername(resultSet.getString("USERNAME"));
				user.setPassword(resultSet.getString("PASSWORD"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (null != resultSet) {
					resultSet.close();
				}
				if (null != prepareStatement) {
					prepareStatement.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				DBManager.getInstance().closeConnection();
			}
		}

		return null;
	}

}
