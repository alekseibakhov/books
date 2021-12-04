package com.example.boot.security;

import com.example.boot.model.Roles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AndRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
// для того, чтоб использовать аннотации вместо antMatchers
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    //для разграничения доступа по ролям
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //урл резрешить всем
                .antMatchers("/").permitAll()
                // добавление ограничений по ролям и разрешениям
//                .antMatchers(HttpMethod.GET, "/library/**").hasAuthority(Permission.DEVELOPERS_READ.getPermission())
//                .antMatchers(HttpMethod.POST, "/library/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
//                .antMatchers(HttpMethod.DELETE, "/library/**").hasAuthority(Permission.DEVELOPERS_WRITE.getPermission())
                .anyRequest()
                .authenticated()
                .and()
                //форма логина добавлена на страницу, но на основе GET метода, что не безопасно
                .formLogin()
                //доступ к странице аутентификации, куда будут перенаправлены все в самом начале
                .loginPage("/auth/login").permitAll()
                // при успешной регистрации перенаправлять сюда
                .defaultSuccessUrl("/library")
                .and()
                .logout()
                // говорим, что для logout доступен только пост метод на странице
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "POST"));

                //просто примочки по удалению куки и очистки кэша с аутентификацией
//              .invalidateHttpSession(true)
//              .clearAuthentication(true)
//              .deleteCookies("JSESSIONID");

    }

    @Bean
    @Override
    // создание пользователей
    protected UserDetailsService userDetailsService() {
        return new InMemoryUserDetailsManager(
                User.builder()
                        .username("admin")
                        .password(encoder().encode("admin"))
                        //указываем, какие именно разрешения будут у юзера
                        .authorities(Roles.ADMIN.getGrantedAuthorities())
                        .build(),

                User.builder()
                        .username("user")
                        .password(encoder().encode("user"))
                        .authorities(Roles.USER.getGrantedAuthorities())
                        .build()
        );
    }

    @Bean
    protected PasswordEncoder encoder() {
        return new BCryptPasswordEncoder(12);
    }

}
