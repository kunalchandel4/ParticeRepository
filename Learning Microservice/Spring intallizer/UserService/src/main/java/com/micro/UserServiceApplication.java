package com.micro;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProvider;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.DefaultOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.web.client.RestTemplate;

import com.micro.entities.RestTemplateInterceptor;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class UserServiceApplication {

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
	@Autowired
	private OAuth2AuthorizedClientRepository oAuth2AuthorizedClientRepository;

	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {

		 RestTemplate restTemplate = new RestTemplate();

	        List<ClientHttpRequestInterceptor> interceptors=new ArrayList<>();

	        interceptors.add(new RestTemplateInterceptor(manager(
	                clientRegistrationRepository,
	                oAuth2AuthorizedClientRepository
	        )));

	        restTemplate.setInterceptors(interceptors);


	        return restTemplate;
	}

	// declare OAuth2AuthorizedClientManager
	@Bean
	public OAuth2AuthorizedClientManager manager(ClientRegistrationRepository repo,
			OAuth2AuthorizedClientRepository auth2AuthorizedClientRepository) {

		OAuth2AuthorizedClientProvider provider = OAuth2AuthorizedClientProviderBuilder.builder().clientCredentials()
				.build();
		DefaultOAuth2AuthorizedClientManager defaultOAuth2AuthorizedClientManager = new DefaultOAuth2AuthorizedClientManager(
				clientRegistrationRepository, auth2AuthorizedClientRepository);
		defaultOAuth2AuthorizedClientManager.setAuthorizedClientProvider(provider);
		return defaultOAuth2AuthorizedClientManager;

	}

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}

}
