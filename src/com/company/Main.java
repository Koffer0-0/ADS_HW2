package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Heap heap = new Heap(true);
        heap.insert(6);
        heap.insert(10);
        heap.insert(21);
        heap.insert(56);
        heap.insert(23);
        System.out.println("Show min: " + heap.getMin());
        System.out.println("Show length: " + heap.size());
        System.out.println("Remove min: " + heap.extractMin());
        System.out.println("Show: " + heap);

    }
}

class Heap <T extends Comparable<T>>{
    private static final int DEFAULT_CAPACITY = 5;
    private int size;
    private T[] heap;
    private boolean min;

    public Heap() {
        min = true;
        size = 0;
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public Heap(boolean min) {
        heap = (T[]) new Comparable[DEFAULT_CAPACITY];
        size = 0;
        this.min = min;
    }

    public boolean empty() {
        return size() == 0;
    }

    public int size() {
        return size;
    }


    public T getMin() {
        if (empty());
        return heap[0];
    }

    public T extractMin(){
        if (empty()) return null;

        T result = getMin();

        swap(1, size);
        heap[size] = null;
        size--;
        return result;
    }

    public void insert(T data) {
        heap[size++] = data;
    }

    private void swap(int child, int parent) {
        T temp = heap[child];
        heap[child] = heap[parent];
        heap[parent] = temp;
    }

    private void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
    }

    @Override
    public String toString() {
        return "Heap {" +
                "size = " + size +
                ", heap = " + Arrays.toString(heap) +
                ", min = " + min +
                '}';
    }
}