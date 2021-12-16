package se.iths.completablefuture;

import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Process is starting...");

//        int solution = longNetWorkProcess(5);
//        System.out.println(solution);
        //System.out.println("Process is done");

        CompletableFuture.supplyAsync(() -> longNetWorkProcess(5))
                .thenApply(value -> performOperation(value))
                .thenAccept(value -> System.out.println("Received computed  value:" + value + " fronm thread: " + Thread.currentThread().getName()));

        System.out.println(Thread.currentThread().getName() + " thread is sleeping....");
        Thread.sleep(4000);
        System.out.println(Thread.currentThread().getName() + " thread is done sleeping....");
    }


    public static int longNetWorkProcess(int value) {
        System.out.println(Thread.currentThread().getName() + " thread is handling the longnetworkprocess()...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return value * 10;
    }

    public static int performOperation(int value) {
        System.out.println(Thread.currentThread().getName() + " thread is performing operations...");

        if (value > 50) {
            value += 10;
        } else {
            value += 20;
        }
        return value;
    }
}
