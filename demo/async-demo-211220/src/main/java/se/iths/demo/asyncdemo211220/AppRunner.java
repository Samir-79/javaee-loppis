package se.iths.demo.asyncdemo211220;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.iths.demo.asyncdemo211220.model.GitHubuser;
import se.iths.demo.asyncdemo211220.service.GitHubServicce;

import java.util.concurrent.CompletableFuture;

@Component
public class AppRunner  implements CommandLineRunner {

    public final GitHubServicce gitHubService;

    public AppRunner(GitHubServicce gitHubService) {
        this.gitHubService=gitHubService;
    }
    @Override
    public void run(String... args) throws Exception {

        long start= System.currentTimeMillis();

        CompletableFuture<GitHubuser> gitHubUser1 = gitHubService.findUser("pontus-redig-alten1");
        CompletableFuture<GitHubuser> gitHubUser2 = gitHubService.findUser("pontus-redig-alten2");
        CompletableFuture<GitHubuser> gitHubUser3 = gitHubService.findUser("pontus-redig-alten3");
        CompletableFuture<GitHubuser> gitHubUser4 = gitHubService.findUser("pontus-redig-alten4");


        CompletableFuture.allOf(gitHubUser1,gitHubUser2,gitHubUser3,gitHubUser4).join();

        System.out.println("Det har gått: "+ (System.currentTimeMillis() - start) + " millisekunder.");

        System.out.println("----->" +);
    }
}
