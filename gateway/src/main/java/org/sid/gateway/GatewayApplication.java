package org.sid.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class GatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayApplication.class, args);
	}

	//@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r->r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))//quand il ya une requete http est envoye vers la gateway avec le path /customers/** envoie la requete vers un service qui s'appelle CUSTOMER-SERVICE dans ce moment gateway va contacter eureka discovery va demander le nom et recupere l adresse
				.route(r->r.path("/products/**").uri("lb://INVENTORY-SERVICE"))// lb : load balancer : equilibrage du charge
				.build();
//				.route(r -> r.path("/customers/**").uri("http://localhost:8081/customers/"))
//				.route(r -> r.path("/products/**").uri("http://localhost:8082/products/"))
	}
	//configuration dynamique
	//a chaque fois que j'envoie la requete je dois preciser le nom du microservice dans l'url
	@Bean
	public DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc,
															   DiscoveryLocatorProperties dlp){
		return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
	}
}
