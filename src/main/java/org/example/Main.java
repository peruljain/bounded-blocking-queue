package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bounded Blocking Queue");

        BoundedBlockingQueue<Integer> queue = new BoundedBlockingQueue<>(new ArrayList<>(), 5);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    queue.enqueue(1);
                    queue.enqueue(2);
                    queue.enqueue(3);
                    queue.enqueue(4);
                    queue.enqueue(5);
                    queue.enqueue(6);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    System.out.println("dequeue : " + queue.dequeue());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();


    }
}