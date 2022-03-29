package ExtraAlgoTests;

import ExtraAlgos.BinarySearchWithSort;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchWithSortTests {
    @Test
    public void IterativeBinarySearchTest(){
        int[] sortedArr = {5,6,7,8,9,10,12,14};
        BinarySearchWithSort binarySearch = new BinarySearchWithSort(sortedArr);
        assertEquals(2,binarySearch.IterativeBinarySearch(7));
    }

    @Test
    public void RecursiveBinarySearchTest(){
        int[] sortedArr = {5,6,7,8,9,10,12,14};
        BinarySearchWithSort binarySearch = new BinarySearchWithSort(sortedArr);
        assertEquals(2,binarySearch.RecursiveBinarySearch(sortedArr,7,0,sortedArr.length-1));
    }
}
