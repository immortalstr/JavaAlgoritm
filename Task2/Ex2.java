package Task2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

public class Ex2 {
    public static void main(String[] args) {
        int size = 10000;
        int min = 0;
        int max = 10000;
        int[] arr = getRandomArr(size, max, min);
        long start1 = new Date().getTime();
        bubbleSort(arr.clone());
        long end1 = new Date().getTime();
        System.out.println(end1 - start1);
        long start = new Date().getTime();
        quickSort(arr.clone());
        long end = new Date().getTime();
        System.out.println(end - start);
        long start2 = new Date().getTime();
        Arrays.sort(arr.clone());
        long end2 = new Date().getTime();
        System.out.println(end2 - start2);
    }
   protected static int[] getRandomArr(int size, int max, int min) {
        Random rnd = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt((max - min) + 1) + min;
        }
        return arr;
    }

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

    /**
     * @apiNote Перегрузка метода быстрой сортировки
     * @param array - исходный массив
     */
    public static void quickSort(int[] array){
        quickSort(array,0,array.length - 1);
    }

    /**
     * @apiNote Быстрая сортировка
     * @param array - массив
     * @param startPosition - старотовая позиция
     * @param endPosition - конечная позиция
     */
    public static void quickSort(int[] array, int startPosition, int endPosition) {
        int pivot = array[(startPosition + endPosition) / 2];
        int i = startPosition;
        int j = endPosition;
        while (i <= j) {
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                if (i < j){
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
                i++;
                j--;
            }
        }
        if (i < endPosition){
            quickSort(array,i,endPosition);
        }
        if(j > startPosition){
            quickSort(array,startPosition,j);
        }

    }

}
