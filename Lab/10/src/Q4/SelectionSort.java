public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {10,34,2,56,7,67,88,42};
        for(int i : insertionSort(arr)) System.out.print(i + " ");
    }

    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length ; i ++){
            int temp = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        return arr;
    }

  
}
