package ExtraAlgos;

public class BinarySearchWithSort {

    int[] sortedArr;
    int low;
    int high;

    public BinarySearchWithSort(int[] sortedArr) {
        this.sortedArr = sortedArr;
        this.low=0;
        this.high=sortedArr.length-1;
        MergeSortImpl merge = new MergeSortImpl();
        merge.mergeSort(sortedArr,0,sortedArr.length-1);
    }

    public int IterativeBinarySearch(int key) {

        MergeSortImpl merge = new MergeSortImpl();
        merge.mergeSort(sortedArr,0,sortedArr.length-1);

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
            return RecursiveBinarySearch(sortedArr, key, low, middle - 1);
        } else {
            return RecursiveBinarySearch(sortedArr, key, middle + 1, high);
        }
    }
}
