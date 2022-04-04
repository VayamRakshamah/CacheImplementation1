package ExtraAlgoTests;

import static org.junit.jupiter.api.Assertions.*;
import ExtraAlgos.MergeSortImpl;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class MergeSortImplTest {

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
    public void checkIfSorted(){
        MergeSortImpl merge = new MergeSortImpl();
        int[] arrsorted = {23,45,67,89,112,234,654,745};
        int[] arrUnSorted = {745,89,23,234,45,654,67,112};

        merge.mergeSort(arrUnSorted,0,arrUnSorted.length-1);

        assertEquals(Arrays.toString(arrsorted),Arrays.toString(arrUnSorted));
    }
}
