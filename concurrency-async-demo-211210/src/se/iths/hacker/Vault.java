package se.iths.hacker;

public class Vault {

    private  int password;

    public Vault(int password) {
        this.password = password;
    }

    public boolean isCorrectPassword( int guess) {

        try{
            Thread.sleep(3);

        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this.password== guess;
    }

}
