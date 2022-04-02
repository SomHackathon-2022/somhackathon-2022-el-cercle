package cat.tecnocampus.elcercle.configuration.security;

import cat.tecnocampus.elcercle.configuration.security.jwt.JwtConfig;
import cat.tecnocampus.elcercle.configuration.security.jwt.JwtTokenVerifierFilter;
import cat.tecnocampus.elcercle.configuration.security.jwt.JwtUsernamePasswordAuthenticationFilter;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;
    private DataSource dataSource;

    private static final String USERS_QUERY = "select correu, password, enabled from OFC_USERS where correu = ?";
    private static final String AUTHORITIES_QUERY = "select username, role from authorities where username = ?";

    private final JwtConfig jwtConfig;

    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder, DataSource dataSource, JwtConfig jwtConfig) {
        this.passwordEncoder = passwordEncoder;
        this.dataSource = dataSource;
        this.jwtConfig = jwtConfig;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers( "/", "index", "*", "**", "***", "/images/**", "/fonts/**", "*.html", "*.ico", "*.png", "*.css", "/css/**", "/js/**", "/login", "/productes/ultims", "/productes/**", "/membres/**").permitAll()
                .antMatchers(HttpMethod.POST, "/membres/*", "/productes/*").permitAll() //.permitAll() //.hasRole("ADMIN")
                .antMatchers("/membres").hasRole("ROL_ADMINISTRADOR")
                .anyRequest()
                .authenticated()

                .and()
                .addFilter(new JwtUsernamePasswordAuthenticationFilter(authenticationManager(), jwtConfig))
                .addFilterAfter(new JwtTokenVerifierFilter(jwtConfig), JwtUsernamePasswordAuthenticationFilter.class)

                .csrf().disable()
                .cors().and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    //Configure authentication manager
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery(USERS_QUERY)
                .authoritiesByUsernameQuery(AUTHORITIES_QUERY)
                .passwordEncoder(passwordEncoder);
    }
}
