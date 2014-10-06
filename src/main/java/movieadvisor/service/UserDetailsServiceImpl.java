package movieadvisor.service;

import movieadvisor.model.User;
import movieadvisor.model.UserRoleEnum;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
 

import java.util.HashSet;
import java.util.Set;
 
@Service("userDetailsServiceImpl")
public class UserDetailsServiceImpl implements UserDetailsService {
 
    @Autowired
    private UserService userService;

	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userService.getUser(email);

        Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority(UserRoleEnum.USER.name()));
 
        UserDetails userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(), 
                                                                       					 user.getPassword(), 
                                                                       					 roles);
        return userDetails;
	}
 
}