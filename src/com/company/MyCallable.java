package com.company;

import java.util.concurrent.Callable;

public class MyCallable extends Thread implements Callable<Integer> {
    int max = 0;
    public MyCallable(String thread_name, int max) {
        setName(thread_name);
        this.max = max;
    }
    @Override
    public Integer call() throws Exception {
        int counter = 1;
        try {
            for (int i = 0; i < max; i++) {
                if (counter != 2) {
                    System.out.printf("Поток %s с идентификатором %s сейчас работает и передает всем привет в %d раз! \n", getName(), getId(), counter);
                } else {
                    System.out.printf("Поток %s с идентификатором %s сейчас работает и передает всем привет во %d раз! \n", getName(), getId(), counter);
                }
                counter ++; //System.out.println(Thread.currentThread().getName());
                Thread.sleep(2500);
            }
        } catch (InterruptedException err) {

        } finally {
            System.out.printf("Поток %s с идентификатором %s работу завершил\n", getName(), getId());
        }
        return counter - 1;
    }
}
