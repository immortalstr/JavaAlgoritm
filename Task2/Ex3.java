package Task2;

import java.util.Random;
import java.util.Arrays;

public class Ex3 {

    public static void main(String[] args) {
        int size = 100;
        int min = 1;
        int max = 100;
        int[] array = getRandomArr(size, max, min);
        Arrays.sort(array);
        print(array);
        System.out.println("\n");
        System.out.println(search(array, 5, 0, array.length - 1));
    }

    protected static int[] getRandomArr(int size, int max, int min) {
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

    protected static void print(int[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.print(args[i] + " ");
        }
    }
    
    public static int search(int[] array, int value, int min, int max) {
        int middle;
        if (max < min) {
            return -1;
        } else {
            middle = (max - min) / 2 + min;
        }
        if (array[middle] < value) {
            return search(array, value, middle + 1, max);
        } else {
            if (array[middle] > value) {
                return search(array, value, min, middle - 1);
            } else {
                return middle;
            }
        }

    }
}
