package se.iths.demo.asyncdemo211220.service;

import org.springframework.boot.autoconfigure.web.client.RestTemplateAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import se.iths.demo.asyncdemo211220.model.GitHubuser;

import java.util.concurrent.CompletableFuture;

@Service
public class GitHubServicce {

    private static final String URL = "https://api.github.com/users";
    private final RestTemplate restTemplate ;

    public GitHubServicce(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Async
    public CompletableFuture<GitHubuser> findUser(String user) {
        System.out.println("Hämtar info om användaren" + user+ " från Githubs API");
        GitHubuser result = restTemplate.getForObject(URL + user,GitHubuser.class);

    }
}

