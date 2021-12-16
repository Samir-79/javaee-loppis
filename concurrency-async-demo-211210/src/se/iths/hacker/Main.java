package se.iths.hacker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random random = new Random();
        Vault vault = new Vault(random.nextInt(MAX_PASSWORD));
        List<Thread> threads = new ArrayList<>();

        threads.add(new HackerOneThread(vault));
        threads.add(new HackerTwoThread(vault));

        for(Thread thread: threads) {
            thread.start();
        }
    }
}
