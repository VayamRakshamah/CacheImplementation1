package ExtraAlgoTests;

import static org.junit.jupiter.api.Assertions.*;
import ExtraAlgos.MergeSortImpl;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class MergeSortImplTest {

    @Test
    public void checkIfSorted(){
        MergeSortImpl merge = new MergeSortImpl();
        int[] arrsorted = {23,45,67,89,112,234,654,745};
        int[] arrUnSorted = {745,89,23,234,45,654,67,112};

        merge.mergeSort(arrUnSorted,0,arrUnSorted.length-1);

        assertEquals(Arrays.toString(arrsorted),Arrays.toString(arrUnSorted));
    }
}
