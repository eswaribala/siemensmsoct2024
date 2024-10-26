package com.siemens.oauth2gatewaydemo.controllers;

import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.WebSession;
import reactor.core.publisher.Mono;

@RestController
public class OAuth2Controller {

    @GetMapping("/token")
    public Mono<String> generateJWTToken(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient){
        return Mono.just(authorizedClient.getAccessToken().getTokenValue());
    }

    @GetMapping("/")
    public Mono<String> generateSessionForToken(WebSession session){

            return Mono.just(session.getId());
    }

}
