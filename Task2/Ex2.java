package org.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class Task2 {
    public static void main(String[] args) {
        int size = 10000;
        int min = 0;
        int max = 10000;
        int[] arr = Main.getRandomArr(size, max, min);
        long start1 = new Date().getTime();
        Main.bubbleSort(arr.clone());
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
