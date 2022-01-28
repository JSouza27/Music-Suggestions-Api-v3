package br.com.musicsuggestions.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers(HttpMethod.POST, "/api/v3/user/register").permitAll()
            .antMatchers(HttpMethod.GET, "/api/v3/user/list").authenticated()
            .antMatchers(HttpMethod.GET, "/api/v3/user/search={id}").authenticated()
            .antMatchers(HttpMethod.DELETE, "/api/v3/user/delete={id}").authenticated()
            .antMatchers(HttpMethod.PUT, "/api/v3/user/update={id}").authenticated()
            .antMatchers(HttpMethod.GET, "/api/v3/historic/").authenticated()
            .antMatchers(HttpMethod.GET, "/api/v3/historic/{userId}").authenticated()
            .antMatchers(HttpMethod.GET, "/api/v3/spotify/authorization").authenticated()
            .antMatchers(HttpMethod.GET, "/api/v3/playlist").authenticated();
    }
}
