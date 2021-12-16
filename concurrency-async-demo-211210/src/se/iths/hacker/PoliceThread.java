package se.iths.hacker;

public class PoliceThread extends Thread {
    @Override
    public void run() {
        for (int i = 10; i > 0; i--) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i + " sekunder tills polisen kommer...");
        }
        System.out.println("Spelet är slut, hackers!");
        System.exit(0);
    }
}
