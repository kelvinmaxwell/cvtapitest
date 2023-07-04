package security;

import org.aspectj.weaver.bcel.BcelAccessForInlineMunger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	private static final String[] SECURED_URLs= {"/api/employees/**"};
	private static final String[] UNSECURED_URLs= {"/api/employees/getEmployees","/api/employees/getEmployee/{id}","/api/users/**"};
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		
		
		return new BCryptPasswordEncoder();
	}
	@Bean
    public UserDetailsService userDetailsService(){
        return new CvtUserDetailsService();
    }
    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	
		return http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(UNSECURED_URLs).permitAll().and()
                .authorizeHttpRequests().requestMatchers(SECURED_URLs)
                .hasAuthority("ADMIN").anyRequest()
                .authenticated().and().httpBasic().and().build();
	}
	

}
