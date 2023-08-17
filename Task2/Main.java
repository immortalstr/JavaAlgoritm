package Task2;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 100;
        int min = 0;
        int max = 100;
        int[] arr = getRandomArr(size, max, min);
        print(arr);

        bubbleSort(arr);
        System.out.println("\n");
        print(arr);
    }

    /**
     * @apiNote BubbleSort
     * @param arr - array to start
     */
    protected static void bubbleSort(int[] arr) {
        boolean fin = true;
        do {
            fin = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    arr[i] += arr[i + 1];
                    arr[i + 1] = arr[i] - arr[i + 1];
                        arr[i] -= arr[i + 1];
                        fin = false;
                    }
                }
            } while(!fin);
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