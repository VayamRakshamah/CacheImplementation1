package ExtraAlgoTests;

import ExtraAlgos.BinarySearchWithSort;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BinarySearchWithSortTests {


    @Test
    public void runBenchmarks() throws Exception {
        Options options = new OptionsBuilder()
                .include(this.getClass().getName() + ".*")
                .mode(Mode.AverageTime)
                .warmupTime(TimeValue.seconds(1))
                .warmupIterations(0)
                .threads(1)
                .measurementIterations(1)
                .forks(1)
                .shouldFailOnError(true)
                .shouldDoGC(true)
                .build();

        new Runner(options).run();
    }


    @Test
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void IterativeBinarySearchTest(){
        int[] sortedArr = {5,6,7,8,9,10,12,14};
        BinarySearchWithSort binarySearch = new BinarySearchWithSort(sortedArr);
        assertEquals(2,binarySearch.IterativeBinarySearch(7));
    }

    @Test
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void RecursiveBinarySearchTest(){
        int[] sortedArr = {5,6,7,8,9,10,12,14};
        BinarySearchWithSort binarySearch = new BinarySearchWithSort(sortedArr);
        assertEquals(2,binarySearch.RecursiveBinarySearch(sortedArr,7,0,sortedArr.length-1));
    }
}
