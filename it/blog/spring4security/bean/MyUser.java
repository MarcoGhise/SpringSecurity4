package it.blog.spring4security.bean;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class MyUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3798122616154485067L;
	private final String firstName;
	
	public MyUser(String username, String password, String firstName, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked,
			Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		this.firstName = firstName;
		
	}

	public String getFirstName() {
		return firstName;
	}


}
