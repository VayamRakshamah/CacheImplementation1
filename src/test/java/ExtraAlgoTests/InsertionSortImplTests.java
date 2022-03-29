package ExtraAlgoTests;

import ExtraAlgos.InsertionSortImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InsertionSortImplTests {

    @Test
    public void checkIfSorted(){
        InsertionSortImpl insertionSort = new InsertionSortImpl();
        int[] arrsorted = {23,45,67,89,112,234,654,745};
        int[] arrUnSorted = {745,89,23,234,45,654,67,112};

        insertionSort.sort(arrUnSorted);

        assertEquals(Arrays.toString(arrsorted),Arrays.toString(arrUnSorted));
    }
}
