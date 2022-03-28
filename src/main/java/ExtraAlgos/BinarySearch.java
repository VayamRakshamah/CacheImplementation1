package ExtraAlgos;

public class BinarySearch {

    public static void main(String[] args) {
        BinarySearch bin = new BinarySearch();
        int[] arr = {12,13,14,15,18,21,24};
        int low=0;
        int high=arr.length;
        System.out.println("Key : "+15+" Index : "+bin.IterativeBinarySearch(arr,15,low,high)+" Iterative Solution");
        System.out.println("Key : "+21+" Index : "+bin.RecursiveBinarySearch(arr,21,low,high)+" Recursive Solution");
    }

    public int IterativeBinarySearch(int[] sortedArr, int key, int low, int high) {
        int index = Integer.MAX_VALUE;

        while (low <= high) {
            int mid = low  + ((high - low) / 2);
            if (sortedArr[mid] < key) {
                low = mid + 1;
            } else if (sortedArr[mid] > key) {
                high = mid - 1;
            } else if (sortedArr[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int RecursiveBinarySearch(int[] sortedArr, int key, int low, int high) {
        int middle = low  + ((high - low) / 2);

        if (high < low) {
            return -1;
        }
        if (key == sortedArr[middle]) {
            return middle;
        } else if (key < sortedArr[middle]) {
            return RecursiveBinarySearch(
                    sortedArr, key, low, middle - 1);
        } else {
            return RecursiveBinarySearch(
                    sortedArr, key, middle + 1, high);
        }
    }
}
