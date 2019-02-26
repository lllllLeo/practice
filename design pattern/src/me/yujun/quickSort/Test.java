package me.yujun.quickSort;

public class Test {
    private static void quickSort(int[] arr){
        quickSort(arr, 0, arr.length-1);
    }
    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end);     // part2를 기준으로 왼쪽에 작은값 / 오른쪽에 큰값 배치
        if(start < part2 -1){                       // 왼쪽값 정렬 -> 한 파티션이 시작점 바로 다음에서 시작하면 왼쪽 파티션이 하나니까 정렬할 필요가 없다. 오른쪾 파티션이 시작점에서 한 개 이상 차이가 날때 하기 위해서 -1 해줌그러면 중간에 공간하나생김 / 그럼 한번이라도 돈다.
//                                                  quickSort에도 part2 - 1 주는 이유는 part2가 오른쪽파티션 시작점이니까 part2로 주면안됨 -1로 줘야함 왼쪽파티션 end가 part-1이 되게 start ~ part-1, part ~ end
            quickSort(arr, start, part2 - 1);
        }
        if(part2 < end){                            // 오른쪽값 정렬
            quickSort(arr, part2, end);
        }
    }
    private static int partition(int[] arr, int start, int end){
        int pivot = arr[(start + end) / 2];
        System.out.println("현재 피벗은 "+pivot);
        while(start <= end){                        // 같거나 밑에 if문에 ++ / --로 인해서 start > end이면 -> 왼쪽, 오른쪽값이 이미 정렬되어있으니 돌필요가 없으니 이 반복문을 바로 빠져나감
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            /**
             * 배열 중간에 {~, 0, 5, 7, ~} 이렇고 피벗이 5이고 start 가0, end가 7일때 위의 while문을 실행 후  ++ / -- 로 빠져나가면
             * srart는 { 5 } 부분의 값이되고 end도 마찬가지로 { 5 } 자리의 값이 된다.
             * 그러면 밑의 이프문을 실행한다. swqp 하면 똑같다 어처피 그러고 start ++ / end-- 를 각각해주는데 주 이유는 swap을 하면 정렬이 완료 되었으니까 다음 값을 검사하기 위해  ++ / --를 한다.
             * (다음 부가적 이유는 start 값까지 정렬이 완료가 되었으니 start 다음으로 가야한다.)
             * 본론으로 돌아와서 start/end가 5인 상태로 들어와서 swqp을 한 후 start를 다음자리로 ++ 해준다. 그러면 빠져나와서 최상위 while문을 만나는데 start <= end가 성립하지 않는다. 저 조건에 들어가지 않는 이유는 왼쪽 / 오른쪽 배열의 정렬이
             * 이미 완료되었다는 말이다. 그러니 탈출해서 start (정렬 기준을 정하는 배열의 중간값)을 리턴해준다.
             * */
            if(start <= end){                       // 배열의 자리수인데 start가 end를 지나지 않았으면
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        System.out.println("리턴"+start);
        return start;
    }
    private static void swap(int[] arr, int start, int end){
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }
    private static void printArray(int[] arr){
        for(int data : arr){
            System.out.print(data + ", ");
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
