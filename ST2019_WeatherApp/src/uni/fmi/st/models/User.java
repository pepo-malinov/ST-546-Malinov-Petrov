package uni.fmi.st.models;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 2L;
	private String username;
	private String password;
	private String email;

	public User() {

	}

	/**
	 * Constructor
	 * 
	 * @param username Valid not {@code NULL} and empty user name.
	 * @param password Valid not {@code NULL} and empty user password.
	 * @param email    Valid not {@code NULL} and empty user email.
	 */
	public User(final String username, final String password, final String email) {
		this.username = username;
		this.password = password;
		this.email = email;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(final String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(final String password) {
		this.password = password;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

}
