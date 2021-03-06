package ucb.edu.bo.sis.ventaropa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import ucb.edu.bo.sis.ventaropa.bl.JwtUserDetailsService;
import ucb.edu.bo.sis.ventaropa.filter.JwtRequestFilter;

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    private JwtUserDetailsService jwtUserDetailsService;
    private JwtRequestFilter jwtRequestFilter;
    final String apiVersion = "/v2";

    @Autowired
    public SecurityConfigurer(JwtUserDetailsService jwtUserDetailsService,JwtRequestFilter jwtRequestFilter) {
        this.jwtUserDetailsService = jwtUserDetailsService;
        this.jwtRequestFilter = jwtRequestFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(jwtUserDetailsService);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, apiVersion + "/administrador/login").permitAll()
                .antMatchers(HttpMethod.POST, apiVersion + "/administrador/login/proveedor").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion +"/colours/**").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion + "/categories").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion + "/products").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion + "/sizes").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion + "/products/image/**").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion + "/products/**").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion + "/products/details").permitAll()
                .antMatchers(HttpMethod.GET, apiVersion + "/products/details/**").permitAll()
                .antMatchers(HttpMethod.POST, apiVersion + "/users").permitAll()
                .antMatchers(HttpMethod.POST, apiVersion + "/login/user").permitAll()
                .antMatchers(apiVersion+"/auth/**",
                        "/v2/api-docs/**",
                        "/swagger-ui/**",
                        "/swagger-resources/**",
                        "/configuration/**").permitAll()
                .anyRequest().authenticated().
                and().sessionManagement().
                sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean()throws Exception{
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
}
