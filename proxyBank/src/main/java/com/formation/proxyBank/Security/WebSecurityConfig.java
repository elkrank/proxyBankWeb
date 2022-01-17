package com.formation.proxyBank.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
		// securedEnabled = true,
		// jsr250Enabled = true,
		prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthEntryPointJwt unauthorizedHandler;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthTokenFilter authenticationJwtTokenFilter() {
		return new AuthTokenFilter();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().authorizeRequests()
				.antMatchers("/conseillers").hasAnyRole("ADMIN", "DIRECTEUR")
				.antMatchers("/conseillers/comptes/*/transfer/?numerocompteBeneficiaire")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/agences").hasRole("ADMIN")
				.antMatchers("/agences/*").hasRole("ADMIN").antMatchers("/admin").hasRole("ADMIN")
				.antMatchers("/admin/*").hasRole("ADMIN").antMatchers("/directeurs").hasRole("ADMIN")
				.antMatchers("/directeurs/*").hasRole("ADMIN").antMatchers("/clients")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/clients/*")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/comptes")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/comptes/*")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/comptes-epargne")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/comptes-epargne/*")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/cartes")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/cartes/*")
				.hasAnyRole("ADMIN", "DIRECTEUR", "CONSEILLER").antMatchers("/agences/*/ajouterEmploye/?idEmploye")
				.hasAnyRole("ADMIN", "DIRECTEUR").antMatchers("/agences/*/employes").hasAnyRole("ADMIN", "DIRECTEUR")
				.antMatchers("/agences/*/audit").hasAnyRole("ADMIN", "DIRECTEUR").anyRequest().permitAll();
		// .antMatchers("/proxyBank/clients/*").hasRole("CONSEILLER");

		http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/v2/api-docs", "/configuration/ui", "/swagger-resources/**",
				"/configuration/security", "/swagger-ui.html", "/webjars/**");
	}
}
