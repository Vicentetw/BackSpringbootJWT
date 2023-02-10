/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myApi.SpringBoot.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.myApi.SpringBoot.Security.Service.UserDetailsServiceImpl;
import com.myApi.SpringBoot.Security.jwt.JwtEntryPoint;
import com.myApi.SpringBoot.Security.jwt.JwtTokenFilter;
import java.util.Arrays;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
  prePostEnabled = true, 
  securedEnabled = true, 
  jsr250Enabled = true)

public class MainSecurity extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsServiceImpl userDetailsServicesImpl;

    @Autowired
    JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter() {
        return new JwtTokenFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
     @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServicesImpl).passwordEncoder(passwordEncoder());
    }
@Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
    
   /* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                //.authorizeRequests()
                // .antMatchers("**").permitAll()
                //http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/modifica").permitAll()
                .antMatchers(HttpMethod.GET, "/educacion/all").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .antMatchers(HttpMethod.HEAD, "/**").permitAll()
                .antMatchers(HttpMethod.DELETE, "/**").hasAnyAuthority("ROLE_ADMIN")
                //.antMatchers(HttpMethod.POST, "/educacion").access("hasRole('ADMIN')")
                .antMatchers(HttpMethod.POST, "/**").permitAll()
                .antMatchers(HttpMethod.POST, "/modifica-experiencia").permitAll()
                .antMatchers(HttpMethod.POST, "/modifica").permitAll()
                 .antMatchers(HttpMethod.PUT, "/modifica/educacion").access("hasRole('ADMIN')")
                .antMatchers(HttpMethod.PUT, "/modifica/update").permitAll()
                 .antMatchers(HttpMethod.PUT, "/**").permitAll()
                 .antMatchers(HttpMethod.PUT, "/educacion").permitAll()
                .antMatchers(HttpMethod.PUT, "/modifica/educacion").permitAll()
                
                .anyRequest().authenticated()
                .and()
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

    }
*/
// Apply JWT
    

    
   

 /*   @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("*");
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE"));
        config.setAllowedHeaders(Arrays.asList("*"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
    */
    /*
@Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers("**").permitAll()
                .antMatchers(HttpMethod.POST, "/auth/login").permitAll()
                .antMatchers(HttpMethod.HEAD, "/**").permitAll()
                .anyRequest().authenticated()
                .antMatchers(HttpMethod.PUT, "/modifica/educacion").access("hasRole('ADMIN')")
                .antMatchers(HttpMethod.POST, "/modifica/educacion").access("hasRole('ADMIN')")
                
                .anyRequest().authenticated()
                .and()
                .cors()
                .configurationSource(corsConfigurationSource())
                .and()
                .exceptionHandling() .authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement() .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }
    */
    
    
@Override
    protected void configure(HttpSecurity http) throws Exception {
        
        http.cors().and().csrf().disable()
                .headers().xssProtection().disable()
                .frameOptions().sameOrigin()
       .addHeaderWriter(
        new XFrameOptionsHeaderWriter(
           XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN))
                .and()
                .authorizeRequests()
               // .antMatchers("/modifica/**").hasRole("ADMIN")
                .antMatchers(HttpMethod.POST, "/auth/login/**").permitAll()
                .antMatchers("/modifica/**").permitAll()
                .antMatchers("/auth/**").permitAll()
                .antMatchers("/auth/login").permitAll()
                .antMatchers(HttpMethod.GET, "/**").permitAll()
                .antMatchers(HttpMethod.GET, "/modifica").permitAll()
                .antMatchers(HttpMethod.GET, "/experiencia/**").permitAll()
                .antMatchers(HttpMethod.GET, "/modifica-experiencia/**").permitAll()
                .antMatchers(HttpMethod.POST, "/modifica/**").permitAll()
                .antMatchers(HttpMethod.GET, "/educacion/all").permitAll()
                .antMatchers(HttpMethod.DELETE, "/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
        
    }


    
}
