package uni.fmi.st.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uni.fmi.st.jdbc.UserRepo;
import uni.fmi.st.jpa.UserJPAManager;
import uni.fmi.st.models.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<User> users;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		users = new ArrayList<>();
		users.add(new User("Ivan", "password", "1222@test.com"));
		users.add(new User("Pavel", "123123", "test2@test.com"));
		users.add(new User("Kostadin", "asdasd", "test3@test.com"));
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final UserJPAManager userRepo = new UserJPAManager();
		userRepo.add(users.get(0));
		final User user = userRepo.findUser("1222@test.com", "password");
		if(null != user) {
			System.out.println("User with name: "
						+ user.getUsername()+" exists!");
			
		}
		else {
			System.out.println("NOT Exists!");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		final String email = request.getParameter("email");
		final String password = request.getParameter("password");

		final PrintWriter writer = response.getWriter();
		if (null != email && null != password) {
			final User loginUser = new UserJPAManager()
									.findUser(email, password);
			if (null != loginUser) {
				final HttpSession session = request.getSession();
				session.setAttribute("currentUser", loginUser);
				writer.append("profile.jsp");
				//request.getRequestDispatcher("profile.jsp").forward(request, response);
				//response.sendRedirect("profile.jsp");
			} else {
				writer.append("Wrong username or password!");
			}
		} else {
			writer.append("Wrong request!");
		}
	}

}
