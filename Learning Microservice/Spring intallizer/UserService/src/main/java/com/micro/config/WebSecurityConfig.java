	package com.micro.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

//		httpSecurity.authorizeHttpRequests().anyRequest().authenticated().and().oauth2ResourceServer().jwt();

		httpSecurity.authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated())
				.oauth2ResourceServer((oauth2) -> oauth2.jwt(Customizer.withDefaults()));
		return httpSecurity.build();

	}

    @Bean
    public ClientRegistrationRepository clientRegistrationRepository() {
        return new InMemoryClientRegistrationRepository(clientRegistration());
    }

    private ClientRegistration clientRegistration() {
        return ClientRegistration.withRegistrationId("okta")
            .clientId("0oabfxd4tuFZR8SkJ5d7")
            .clientSecret("g4iIOUTdKPqEJXGlRnR3tQ6w2amBQDCet0bEFUgT-K5Hi0Sj03_BtyRz7KdjWOnc")
            .clientAuthenticationMethod(ClientAuthenticationMethod.CLIENT_SECRET_BASIC)
            .authorizationGrantType(AuthorizationGrantType.CLIENT_CREDENTIALS)
            .scope("internal")
            .authorizationUri("https://dev-06833922.okta.com/oauth2/default/v1/authorize")
            .tokenUri("https://dev-06833922.okta.com/oauth2/default/v1/token")
            .userInfoUri("https://dev-06833922.okta.com/oauth2/default/v1/userinfo")
            .build();
    }

}
