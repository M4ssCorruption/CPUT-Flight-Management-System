package za.ac.cput.flightmanagementsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity

public class FlightSystemManagerSecurity extends WebSecurityConfigurerAdapter {
    private static final String USER_ROLE = "USER";
    private static final String ADMIN_ROLE= "ADMIN";

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
        authenticationManagerBuilder
                .inMemoryAuthentication()
                .withUser("ADMIN")
                .password(encoder().encode("admin"))
                .roles(ADMIN_ROLE)
                .and()
                .withUser("USER")
                .password(encoder().encode("kruben"))
                .roles(USER_ROLE);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST,"/add").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"/find").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"/find").hasRole(ADMIN_ROLE)
                .antMatchers(HttpMethod.GET,"/all").hasRole(USER_ROLE)
                .antMatchers(HttpMethod.GET,"/all").hasRole(ADMIN_ROLE)
                .and()
                .csrf().disable()
                .formLogin().disable();
    }
    @Bean
    public PasswordEncoder encoder()
    {
        return new BCryptPasswordEncoder();
    }


}
