package me.yujun.quickSort;

public class Test2 {
    private static void quickSort(int arr[]){
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int arr[], int start, int end){
        int part2 = partition(arr, start, end);

        if(start < part2 -1){
            quickSort(arr, start, part2 - 1);
        }
        if(part2 < end){
            quickSort(arr, part2, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];

        while (start <= end){   // 같다는뜻은 앞, 뒤 정렬이 완료되어서 더이상 바꿀게 없다는 뜻
            while(arr[start] < pivot) { start ++; }
            while(arr[end] > pivot) { end --; }

            if(start <= end){
               swap(arr, start, end);
               start++;
               end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;

    }

    private static void printArray(int[] arr) {
        for(int a:arr){
            System.out.print(a+", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int [] arr = {3,9,4,0,5,7,1,6,8,2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
