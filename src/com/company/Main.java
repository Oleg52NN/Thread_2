package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

import static java.lang.Thread.sleep;

public class Main {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        int maxThread = Runtime.getRuntime().availableProcessors();
        final ExecutorService threadPool = Executors.newFixedThreadPool(maxThread);
        List<Callable<Integer>> thread = new ArrayList<>();
        final Future<Integer> task[] = new Future[maxThread];
        List <String> name  = Arrays.asList(
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
            thread.add(new MyCallable(name.get(i), 10 - i));
            task[i] = threadPool.submit(thread.get(i));
        }

        for (int i = 0; i < maxThread; i++) {
            Integer resultOfTask = task[i].get();
            System.out.println(name.get(i) + " выполнил " + resultOfTask + " действий");
        }
        Integer result = threadPool.invokeAny(thread);
        System.out.println(result + " действий");
        threadPool.shutdown();


    }
}
