package uni.fmi.st.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Response;

import uni.fmi.st.jpa.UserJPAManager;
import uni.fmi.st.models.User;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String email = request.getParameter("email");
		final String password = request.getParameter("password");
		final String username = request.getParameter("username");

		if (null != email && null != password && null != username) {
			final User loginUser = new User(username, password, email);
			new UserJPAManager().addUser(loginUser);
			final HttpSession session = request.getSession();
			session.setAttribute("currentUser", loginUser);
			response.sendRedirect("profile.jsp");

		} else {
			response.setStatus(Response.SC_BAD_REQUEST);
			final PrintWriter writer = response.getWriter();
			writer.append("Wrong request!");
		}
	}

}
