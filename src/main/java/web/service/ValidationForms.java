package web.service;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

public class ValidationForms {
	public static final String REG_EMAIL = "^((([0-9A-Za-z]{1}[-0-9A-z\\.]{1,}[0-9A-Za-z]{1})|([0-9А-Яа-я]{1}[-0-9А-я\\.]{1,}[0-9А-Яа-я]{1}))@([-A-Za-z]{1,}\\.){1,2}[-A-Za-z]{2,})$";
	public static final String REG_PASSWORD = "^(?=.*[0-9].*[0-9].*)(?=.*[a-z].*)(?=.*[A-Z].*[A-Z].*)[0-9a-zA-Z]{8,}$";

	public static boolean isFormValid(HttpServletRequest request) {
		boolean check = true;
		if (isNoValidText(request.getParameter("email"), REG_EMAIL)) {
			request.setAttribute("email", "Successful registration");
			check = false;
		}
		if (isNoValidText(request.getParameter("password"), REG_PASSWORD)) {
			request.setAttribute("password", "Password must contain at least 8 characters, 2 digits, 2 headers only in Latin");
			check = false;
		}
		if (!Objects.equals(request.getParameter("password"), request.getParameter("rePassword"))) {
			request.setAttribute("repassword", "Password mismatch");
			check = false;
		}
		if (isNoValidText(request.getParameter("fullName"))) {
			request.setAttribute("fullname", "Empty name");
			check = false;
		}
		if (isNoValidText(request.getParameter("region"))) {
			request.setAttribute("region", "No region selected");
			check = false;
		}
		if (isNoValidText(request.getParameter("gender"))) {
			request.setAttribute("gender", "No gender selected");
			check = false;
		}
		if (isNoValidText(request.getParameter("comment"))) {
			request.setAttribute("comment", "Empty comments");
			check = false;
		}
		if (isNoValidText(request.getParameter("agreement"))) {
			request.setAttribute("agreement", "No agreement");
			check = false;
		}
		return check;
	}

	private static boolean isNoValidText(String text, String reg) {
		boolean check = false;
		if (Objects.isNull(text) || !text.matches(reg)) {
			check = true;
		}
		return check;
	}

	private static boolean isNoValidText(String text) {
		boolean check = false;
		if (Objects.isNull(text) || text.isEmpty()) {
			check = true;
		}
		return check;
	}
}
