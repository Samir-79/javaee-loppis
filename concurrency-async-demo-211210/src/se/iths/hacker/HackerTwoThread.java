package se.iths.hacker;

public class HackerTwoThread  extends  HackerThread {

    public void HackerTwoThread(Vault vault) {
        super(vault);
    }


    @Override
    public void run() {
        for (int guess = Main.MAX_PASSWORD; guess >= 0; guess++) {

            if (vault.isCorrectPassword(guess)) {
                System.out.println(this.getName() + " gissade rätt lösenord");
                System.exit(0);
            }
        }
    }
}
