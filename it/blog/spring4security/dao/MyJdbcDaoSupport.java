package it.blog.spring4security.dao;

import it.blog.spring4security.bean.MyUser;
import it.blog.spring4security.bean.MyUserPersonalData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

public class MyJdbcDaoSupport extends JdbcDaoImpl{
	
	private String userPersonalDataQuery;
	
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		List<UserDetails> users = loadUsersByUsername(username);

		if (users.size() == 0) {
			logger.debug("Query returned no results for user '" + username + "'");

			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.notFound", new Object[] { username },
					"Username {0} not found"));
		}

		UserDetails user = users.get(0); // contains no GrantedAuthority[]

		Set<GrantedAuthority> dbAuthsSet = new HashSet<GrantedAuthority>();
		
		dbAuthsSet.addAll(loadUserAuthorities(user.getUsername()));

		List<GrantedAuthority> dbAuths = new ArrayList<GrantedAuthority>(dbAuthsSet);

		addCustomAuthorities(user.getUsername(), dbAuths);

		if (dbAuths.size() == 0) {
			logger.debug("User '" + username
					+ "' has no authorities and will be treated as 'not found'");

			throw new UsernameNotFoundException(messages.getMessage(
					"JdbcDaoImpl.noAuthority", new Object[] { username },
					"User {0} has no GrantedAuthority"));
		}

		MyUserPersonalData userPersonalData = getUserDetails(username);
		
		MyUser myUser = new MyUser(username, user.getPassword(), userPersonalData.getFirstname(), user.isEnabled(), true, true, true, dbAuths);
		return myUser;
	}
	
	protected MyUserPersonalData getUserDetails(String username)
	{
		return getJdbcTemplate().query(userPersonalDataQuery, new String[] { username },
				new RowMapper<MyUserPersonalData>() {
					public MyUserPersonalData mapRow(ResultSet rs, int rowNum)
							throws SQLException {
						return new MyUserPersonalData(rs.getString(1), rs.getString(2));
					}

				}).get(0);
	}

	public String getUserPersonalDataQuery() {
		return userPersonalDataQuery;
	}

	public void setUserPersonalDataQuery(String userPersonalDataQuery) {
		this.userPersonalDataQuery = userPersonalDataQuery;
	}

	

}

