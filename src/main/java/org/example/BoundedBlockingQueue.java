package org.example;

import java.util.List;

public class BoundedBlockingQueue<T> {

    private final List<T> objects;
    private final Integer size;

    public BoundedBlockingQueue(List<T> objects, Integer size) {
        this.objects = objects;
        this.size = size;
    }

    public void enqueue(T object) throws InterruptedException {
        synchronized (this) {
            while (objects.size() >= size) {
                wait();
            }
            objects.add(object);
            notifyAll();
        }
    }

    public T dequeue() throws InterruptedException {
        synchronized (this) {
            while (objects.isEmpty()) {
                wait();
            }
            T object = objects.remove(0);
            notifyAll();
            return object;
        }
    }

    public int size() {
        return objects.size();
    }

}
