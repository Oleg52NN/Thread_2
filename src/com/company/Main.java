package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;


public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int maxThread = Runtime.getRuntime().availableProcessors();
        final ExecutorService threadPool = Executors.newFixedThreadPool(maxThread);
        List<Callable<String>> thread = new ArrayList<>();
        final Future<String> task[] = new Future[maxThread];
        List<String> name = Arrays.asList(
                "Thread One",
                "Thread Two",
                "Thread Three",
                "Thread Four",
                "Thread Five",
                "Thread Six",
                "Thread Seven",
                "Thread Eight",
                "Thread Nine",
                "Thread Ten"
        );
        //final Integer resultOfTask[] = new Integer[maxThread];
        for (int i = 0; i < maxThread; i++) {
            thread.add(new MyCallable(name.get(i), 10));
            task[i] = threadPool.submit(thread.get(i));
        }

        for (int i = 0; i < maxThread; i++) {
            String resultOfTask = task[i].get();
            System.out.println(name.get(i) + " выполнил " + (Integer.parseInt(resultOfTask) - 1) + " действий");
        }
        for (int i = 0; i < maxThread; i++) {
            ((MyCallable) thread.get(i)).setMax(10 + i + maxThread);
        }
        System.out.println("\n Вторая подзадача \n");
        String result = threadPool.invokeAny(thread);
        threadPool.shutdownNow();
        System.out.println(result);


    }
}
