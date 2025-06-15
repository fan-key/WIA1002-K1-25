public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {45,7,2,8,19,3};
        for(int i : selectionSortSmallest(arr)) System.out.print(i + " ");
        System.out.println();
        for(int i : selectionSortLargest(arr)) System.out.print(i + " ");
    }

    public static int[] selectionSortSmallest(int[] arr){
        for(int i = 0 ; i < arr.length -1 ; i++){

            int min = i;
            for(int j = i + 1 ; j < arr.length ; j++ ) {
                if(arr[min] > arr[j]) min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;

        }
        return arr;
    }
    public static int[] selectionSortLargest(int[] arr){
        for(int i = 0 ; i < arr.length -1 ; i++){

            int max = i;
            for(int j = i + 1 ; j < arr.length ; j++ ) {
                if(arr[max] < arr[j]) max = j;
            }
            int temp = arr[i];
            arr[i] = arr[max];
            arr[max] = temp;

        }
        return arr;
    }
}
