package Task2;

public class Ex2 {
    public static void main(String[] args) {
        int size = 100;
        int min = 0;
        int max = 100;
        int[] arr = Main.getRandomArr(size, max, min);
        Main.print(arr);
        quickSort(arr);
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
