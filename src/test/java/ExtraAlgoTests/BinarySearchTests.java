package ExtraAlgoTests;

import ExtraAlgos.BinarySearch;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BinarySearchTests {

    @Test
    public void IterativeBinarySearchTest(){
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {5,6,7,8,9,10,12,14};
        assertEquals(2,binarySearch.IterativeBinarySearch(sortedArr,7,0,sortedArr.length-1));
    }

    @Test
    public void RecursiveBinarySearchTest(){
        BinarySearch binarySearch = new BinarySearch();
        int[] sortedArr = {5,6,7,8,9,10,12,14};
        assertEquals(2,binarySearch.RecursiveBinarySearch(sortedArr,7,0,sortedArr.length-1));
    }
}
