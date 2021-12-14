package com.formation.proxyBank.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.formation.proxyBank.Security.RoleEnum;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
        .authorizeRequests()
        	.antMatchers("/proxyBank").permitAll()
        	.antMatchers("/proxyBank/conseillers/**").hasAnyRole("ADMIN","DIRECTEUR")
        	.antMatchers("/proxyBank/conseillers/comptes/*/transfer/?numerocompteBeneficiaire").hasAnyRole("ADMIN","DIRECTEUR","CONSEILLER")
        	.antMatchers("/proxyBank/agences").hasRole("ADMIN")
        	.antMatchers("/proxyBank/agences/*").hasRole("ADMIN")
        	.antMatchers("/proxyBank/agences/*/ajouterEmploye/?idEmploye").hasAnyRole("ADMIN", "DIRECTEUR")
        	.antMatchers("/proxyBank/agences/*/employes").hasAnyRole("ADMIN", "DIRECTEUR")
        	.antMatchers("/proxyBank/agences/*/audit").hasAnyRole("ADMIN", "DIRECTEUR")
        .anyRequest().authenticated();

    http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
}
