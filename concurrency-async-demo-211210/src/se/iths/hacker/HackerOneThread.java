package se.iths.hacker;

public class HackerOneThread extends  HackerThread {

    public HackerOneThread(Vault vault) {
        super(vault);
    }

    @Override
    public void run() {
        for(int guess=0; guess < Main.MAX_PASSWORD;guess++) {

            if(vault.isCorrectPassword(guess)) {
                System.out.println(this.getName()+ " gissade rätt lösenord");
                System.exit(0);
            }
        }



    }
}
