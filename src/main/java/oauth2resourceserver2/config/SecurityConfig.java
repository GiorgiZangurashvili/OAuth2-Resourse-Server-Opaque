package oauth2resourceserver2.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Value("${introspectionUri}")
    private String introspectionUri;
    @Value("${clientId}")
    private String clientId;
    @Value("${clientSecret}")
    private String clientSecret;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .oauth2ResourceServer(
                        j -> j.opaqueToken(
                                token -> {
                                    token.introspectionUri(introspectionUri);
                                    token.introspectionClientCredentials(clientId, clientSecret);
                                }
                                )
                );

        http.authorizeHttpRequests(
                request -> request.anyRequest().authenticated()
        );

        return http.build();
    }

}
