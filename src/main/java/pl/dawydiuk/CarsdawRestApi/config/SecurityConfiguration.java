package pl.dawydiuk.CarsdawRestApi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import pl.dawydiuk.CarsdawRestApi.security.JsonObjectAuthorizationFilter;
import pl.dawydiuk.CarsdawRestApi.security.JwtAuthorizationFilter;
import pl.dawydiuk.CarsdawRestApi.security.RestAuthenticationFailureHandler;
import pl.dawydiuk.CarsdawRestApi.security.RestAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER");
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .addFilter(jsonObjectAuthorizationFilter())
                .addFilter(new JwtAuthorizationFilter(authenticationManager(), userDetailsService(), "sdhfhfs%^$^$^)jhdsfhsdHHHwww98w"))
                .exceptionHandling()// dodaje odpowiedni błąd 401 UNAUTORIZED
                .authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));
    }


    public JsonObjectAuthorizationFilter jsonObjectAuthorizationFilter() throws Exception {
        JsonObjectAuthorizationFilter jsonObjectAuthorizationFilter = new JsonObjectAuthorizationFilter(new ObjectMapper());
        jsonObjectAuthorizationFilter.setAuthenticationFailureHandler(new RestAuthenticationFailureHandler());
        jsonObjectAuthorizationFilter.setAuthenticationSuccessHandler(new RestAuthenticationSuccessHandler());
        jsonObjectAuthorizationFilter.setAuthenticationManager(super.authenticationManager());
        return jsonObjectAuthorizationFilter;
    }
}
