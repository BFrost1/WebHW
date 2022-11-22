package web.filters;

import java.io.IOException;
import java.util.Objects;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterReg implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (Objects.nonNull(((HttpServletRequest) request).getSession().getAttribute("user"))) {
			((HttpServletResponse) response).sendRedirect("/web/account");
		}else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}
}
