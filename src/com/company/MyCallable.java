package com.company;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;

public class MyCallable extends Thread implements Callable<String> {
    private int max;

    public MyCallable(String thread_name, int max) {
        setName(thread_name);
        this.max = max;
    }

    void setMax(int max) {
        this.max = max;
    }

    int getMax() {
        return this.max;
    }

    @Override
    public String call() throws Exception {
        int counter = 1;
        int sum = 0;
        int erste = 0;
        if (max == 10) {
            try {
                for (int i = 0; i < 10; i++) {
                    if (counter != 2) {
                        System.out.printf("Поток %s с идентификатором %s сейчас работает и передает всем привет в %d раз! \n", getName(), getId(), counter);
                    } else {
                        System.out.printf("Поток %s с идентификатором %s сейчас работает и передает всем привет во %d раз! \n", getName(), getId(), counter);
                    }
                    counter++; //System.out.println(Thread.currentThread().getName());
                    Thread.sleep(100 * getMax());
                }
            } catch (InterruptedException err) {

            } finally {
                System.out.printf("Поток %s с идентификатором %s работу завершил\n", getName(), getId());

            }
            return Integer.toString(counter);
        } else {

            while (sum <= 5000) {
                sum = sum + (int) (Math.random() * 100);
                counter++;
                if (sum > 5000) {
                    String s = String.format("Поток %s с идентификатором %s работу завершил. Количество действий: %d", getName(), getId(), counter);
                    return s;
                }

            }
            return null;
        }
    }
}
