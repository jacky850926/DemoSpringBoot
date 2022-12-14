package tw.leonchen.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import tw.leonchen.model.AuthUserDetailsService;

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
//	儅我這麽做的時候，就不會有人管我了

	@Autowired
	private AuthUserDetailsService auDetailService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
		  .userDetailsService(auDetailService)
		  .passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		  .authorizeRequests()
		  .antMatchers(HttpMethod.GET, "/users/**").authenticated()
		  .antMatchers(HttpMethod.GET).permitAll()
		  .antMatchers(HttpMethod.POST,"/users/**").authenticated()
		  .antMatchers(HttpMethod.POST).permitAll()
		  .anyRequest().authenticated()
		  .and()
		  .rememberMe().tokenValiditySeconds(86400).key("rememberMe-key")
		  .and()
		  .csrf().disable()
		  .formLogin().loginPage("/login/page")
		  .defaultSuccessUrl("/login/welcome");
	}

}
