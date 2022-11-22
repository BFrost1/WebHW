package web.controllers;

import web.model.User;
import web.service.ValidationForms;
import web.service.database.DBWorker;
import web.service.database.UserManager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationController extends HttpServlet {

	private static final long serialVersionUID = 4402184455447304678L;

	private UserManager userManager;
	
	public RegistrationController() {
		this.userManager = new UserManager(new DBWorker());
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("WEB-INF/views/registration.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (ValidationForms.isFormValid(request)) {
			userManager.addUser(new User(request.getParameter("email"), request.getParameter("password"),
					request.getParameter("fullName"), request.getParameter("region"), request.getParameter("gender"),
					request.getParameter("comment"), Boolean.valueOf(request.getParameter("agreement"))));
			request.setAttribute("successful", "Successful registration");
		}
		doGet(request, response);
	}
}
