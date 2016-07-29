package it.blog.spring4security.handler;

import it.blog.spring4security.bean.MyUser;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		MyUser currentUser = (MyUser)authentication.getPrincipal();
		
		logger.info("Authentication Success for user:" + currentUser.getUsername());
		
		setAlwaysUseDefaultTargetUrl(true);
		setDefaultTargetUrl((String)request.getSession().getAttribute("return"));
		
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
