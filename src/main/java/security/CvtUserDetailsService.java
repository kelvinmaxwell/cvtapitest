package security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import api.cvt.app.model.User;
import api.cvt.app.repository.UserRepository;
import api.cvt.app.service.UserService;
import lombok.Data;
@Component
public class CvtUserDetailsService implements UserDetailsService   {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return userRepository.findByEmail(username)
				.map(CvtUserDetails::new).orElseThrow(()-> new UsernameNotFoundException("No user found"));
	}

}
