package Homework.Task2;

import java.util.Random;

public class Zada4a1 {
    public static void main(String[] args) {
        int size = 100;
        int min = 0;
        int max = 100;
        int[] arr = getRandomArr(size, max, min);
        print(arr);
        System.out.println("\n");
        heapify(arr, size, min);
        sort(arr);
        print(arr);
    }

    protected static void heapify(int[] arr, int heapSize, int rootIndex) {
        int larget = rootIndex;
        int leftChild = 2 * rootIndex + 1;
        int rightChild = 2 * rootIndex + 2;

        if (leftChild < heapSize && arr[leftChild] > arr[larget]) {
            larget = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[larget])
            larget = rightChild;

        if (larget != rootIndex) {
            int temp = arr[rootIndex];
            arr[rootIndex] = arr[larget];
            arr[larget] = temp;

            heapify(arr, heapSize, larget);
        }

    }

    public static void sort(int[] arr) {
        for (int index = arr.length / 2 - 1; index >= 0; index--) {
            heapify(arr, arr.length, index);
        }
        for (int index = arr.length - 1; index >= 0; index--) {
            int temp = arr[0];
            arr[0] = arr[index];
            arr[index] = temp;

            heapify(arr, index, 0);
        }
    }

    protected static void print(int[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
    }

    protected static int[] getRandomArr(int size, int max, int min) {
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return arr;
    }
}