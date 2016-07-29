package it.blog.spring4security.controller;

import javax.servlet.http.HttpServletRequest;

import it.blog.spring4security.bean.MyUser;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class WebController {
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String indexPage(ModelMap model) {
		
        model.addAttribute("message", "Hello World!");
        return "index";
    }

	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage(HttpServletRequest request, ModelMap model) {
		
        return "login";
    }
   
	@RequestMapping(value = "/customlogout", method = RequestMethod.GET)
    public String logoutPage(ModelMap model) {
		
        return "logout";
    }
//    @PreAuthorize("hasRole('ROLE_SELLER')")
    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String sellerPage(ModelMap model) {
        
        model.addAttribute("message", "Customer Page...");
        return "customer";
    }
    
//    @PreAuthorize("hasAnyRole('ROLE_BUYER','ROLE_SELLER')")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    public String buyerPage(ModelMap model) {
        
        model.addAttribute("message", "Administrator Page...");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        MyUser currentUser = (MyUser)auth.getPrincipal();

        model.addAttribute("username", currentUser.getFirstName());
        return "admin";
    }
}
