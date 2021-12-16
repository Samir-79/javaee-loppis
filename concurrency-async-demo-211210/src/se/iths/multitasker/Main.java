package se.iths.multitasker;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        while(true) {


            System.out.println("----------------------------");

            //Skapa lista med alla tasks(som implementerar Runnable)
            List<Runnable> taskList = new ArrayList<>();

            //Lägg till varje task på listan
            taskList.add(new Task1());
            taskList.add(new Task2());
            taskList.add(new Task3());
            taskList.add(new Task4());
            taskList.add(new Task5());
            taskList.add(new Task6());

//Skapa upp ett MultiTasker-objekt
            MultiTasker multiTasker= new MultiTasker(taskList);
        multiTasker.runAllTasks();

        Thread.sleep(1000);

        }


    }

    public static class Task1 implements Runnable {
        @Override
        public void run() {
            System.out.println("Hej från task 1, räknare står på:" + count);
            count++;
        }
    }

        public static class Task2 implements Runnable {
            @Override
            public void run() {
                System.out.println("Hej från task 2, räknare står på:" + count);
                count++;
            }
        }

            public static class Task3 implements Runnable {
                @Override
                public void run() {
                    System.out.println("Hej från task 3, räknare står på:" + count);
                    count++;
                }
            }
                public static class Task4 implements Runnable {
                    @Override
                    public void run() {
                        System.out.println("Hej från task 4, räknare står på:" + count);
                        count++;
                    }
                }
                    public static class Task5 implements Runnable {
                        @Override
                        public void run() {
                            System.out.println("Hej från task 5, räknare står på:" + count);
                            count++;
                        }
                    }
                        public static class Task6 implements Runnable {
                            @Override
                            public void run() {
                                System.out.println("Hej från task 6, räknare står på:" + count);
                                count++;
                            }
                        }

                    }

//        System.out.println("I mainmetoden " + Thread.currentThread().getName());
//
//        Runnable myRunnable= new Runnable() {
//            @Override
//            public void run () {
//                System.out.println("Runnable körs....");
//            }
//        };
//
//        myRunnable.run();
//        Thread myThread = new Thread() {
//            @Override
//            public void run() {
//                System.out.println("Tråden körs....");
//                System.out.println("I nea tråden " + Thread.currentThread().getName());
//            }
//        };
//
//
//        myThread.start();






