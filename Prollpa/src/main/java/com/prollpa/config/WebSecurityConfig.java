package com.prollpa.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.BaseLdapPathContextSource;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.config.ldap.LdapBindAuthenticationManagerFactory;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.beans.factory.annotation.Autowired;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

//  @Bean
//  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    http
//      .authorizeHttpRequests((authorize) -> authorize
//        .anyRequest().fullyAuthenticated()
//      )
//      .formLogin(Customizer.withDefaults());
//
//    return http.build();
//  }

//	@Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http
//            .csrf().disable() // Disable CSRF for simplicity in JSON API
//            .authorizeHttpRequests(auth -> auth
//                .requestMatchers("/auth/**").permitAll() // Allow login endpoint
//                .anyRequest().authenticated() // Secure all other endpoints
//            )
//            .httpBasic().disable() // Disable HTTP Basic authentication
//            .formLogin().disable(); // Disable HTML login page
//
//        return http.build();
//    }
	//enable swagger http://localhost:8080/swagger-ui/index.html#/
	 @Bean
	    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	        http
	            .csrf().disable() // Disable CSRF for simplicity in JSON API
	            .authorizeHttpRequests(auth -> auth
	                .requestMatchers(
	                    "/auth/**", // Allow login endpoints
	                    "/swagger-ui/**", // Allow Swagger UI
	                    "/v3/api-docs/**" ,
	                    "/test1",
	                    "/**"// Allow OpenAPI specs
	                ).permitAll()
	                .anyRequest().authenticated() // Secure all other endpoints
	            )
	            .httpBasic().disable() // Disable HTTP Basic authentication
	            .formLogin().disable();/*
	            .rememberMe()
                .key("uniqueAndSecret") // A unique key for cookie encryption
                .tokenValiditySeconds(86400) // Expiry time of cookies (1 day)
            .and()
            .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // Create session only when needed
                .invalidSessionUrl("/auth/login") // Redirect to login if session is invalid
            ;// Disable form-based authentication*/

	        return http.build();
	    }
  @Bean
  public LdapTemplate ldapTemplate() {
	  return new LdapTemplate(contentSource());
  }
  
  @Bean
  public LdapContextSource contentSource() {
	  LdapContextSource ldapContentSource=new LdapContextSource();
	  ldapContentSource.setUrl("ldap://localhost:10389");
      ldapContentSource.setUserDn("uid=admin,ou=system");
	  ldapContentSource.setPassword("secret");
	  return ldapContentSource;
  }
//  @Bean
//  public UserDetailsService userDetailsService() {
//      // Create the authorities populator for the LDAP authentication
//      LdapAuthoritiesPopulator authoritiesPopulator = new DefaultLdapAuthoritiesPopulator(ldapContextSource, "ou=groups");
//      // You can customize the group lookup if needed
//      return new org.springframework.security.ldap.userdetails.LdapUserDetailsService(ldapContextSource, authoritiesPopulator);
//  }
  
  @Bean 
  AuthenticationManager authManager(BaseLdapPathContextSource source) {
	  LdapBindAuthenticationManagerFactory factory=new LdapBindAuthenticationManagerFactory(source);
	  factory.setUserDnPatterns("uid={0}");
	  return factory.createAuthenticationManager();
  }
 

}

