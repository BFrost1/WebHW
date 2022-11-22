package web.controllers;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.model.User;
import web.service.database.DBWorker;
import web.service.database.UserManager;

public class AccountController extends HttpServlet {

	private static final long serialVersionUID = -2020369049507152657L;

	private UserManager userManager;
	
	public AccountController() {
		this.userManager = new UserManager(new DBWorker());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Objects.nonNull(request.getParameter("logout"))) {
			request.getSession().invalidate();
			request.getSession(true);
		}
		if(Objects.nonNull(request.getSession().getAttribute("user"))) {
			request.getRequestDispatcher("WEB-INF/views/account.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("WEB-INF/views/authorization.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(Objects.nonNull(request.getParameter("login")) && Objects.nonNull(request.getParameter("password"))) {
			User user = userManager.getUser(request.getParameter("login"), request.getParameter("password"));
			if(Objects.nonNull(user)) {
				request.getSession().setAttribute("user", user);
			}
		doGet(request, response);
		}
	}
}
