package se.iths.multitasker;

import java.util.ArrayList;
import java.util.List;

public class MultiTasker {

    private List<Runnable> tasks;

    //När instansierar objekt, skickar vi en lista på taksks som implementerar runnable
    public MultiTasker(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    public void runAllTasks() {
        // Skapa upp en lista av threads, lika stor som listan av tasks vi skickat in
        List<Thread> threads = new ArrayList<>(tasks.size());

          //För varje task, skapa upp en ny tråd och lägg till på en listan av trådar
        for (Runnable task : tasks) {
            Thread thread = new Thread(task);
            threads.add(thread);


        }

        // Starta varje tråd i listan
        for (Thread thread : threads) {
            thread.start();
        }
    }


}
