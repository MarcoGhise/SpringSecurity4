package it.blog.spring4security.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.filter.GenericFilterBean;

public class MyCustomFilter extends GenericFilterBean  {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		
		/*
		 * Check the "return" parameter 
		 */
	    if (request.getParameter("return")!=null)
		    ((HttpServletRequest)request).getSession().setAttribute("return", request.getParameter("return"));

	    filterChain.doFilter(request, response);
	}

}
