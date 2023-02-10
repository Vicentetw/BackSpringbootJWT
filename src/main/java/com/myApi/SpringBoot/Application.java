package com.myApi.SpringBoot;

import java.util.Arrays;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class Application {

   @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    
    @Bean
    public CorsFilter corsFilter() {
      CorsConfiguration corsConfiguration = new CorsConfiguration();
      corsConfiguration.setAllowCredentials(true);
      corsConfiguration.setAllowedOrigins(Arrays.asList("https://perrotta-vicente.web.app"));
      corsConfiguration.setAllowedHeaders(Arrays.asList("Origin",
      "Access-Control-Allow-Origin", "Content-Type", "Accept", "Authorization",
      "Origin, Accept", "X-Request-With", "Access-Control-Request-Method",
      "Access-Control-Request-Headers"));
      corsConfiguration.setExposedHeaders(Arrays.asList("Origin",
      "Content-type", "Accept", "Authorization", "Access-Control-Allow-Origin",
      "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
      corsConfiguration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST",
      "DELETE", "OPTIONS")); 
      UrlBasedCorsConfigurationSource  urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
      urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
      return new CorsFilter(urlBasedCorsConfigurationSource);
    }
   
    /* @Bean
  public CorsFilter corsFilter() {
    CorsConfiguration corsConfiguration = new CorsConfiguration();
    corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
    corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST"));
    corsConfiguration.setAllowCredentials(true);

    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", corsConfiguration);

    return new CorsFilter(source);
  }*/
}
