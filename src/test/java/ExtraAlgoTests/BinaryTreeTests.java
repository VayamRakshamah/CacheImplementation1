package ExtraAlgoTests;

import ExtraAlgos.BinaryTree;
import org.junit.jupiter.api.Test;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.openjdk.jmh.runner.options.TimeValue;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class BinaryTreeTests {

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
    public void treeContainsAddedElements() {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        assertTrue(bt.containsNode(6));
        assertTrue(bt.containsNode(4));
        assertFalse(bt.containsNode(1));
    }


    @Test
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void treeDoesNotContainDeletedElements() {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        assertTrue(bt.containsNode(9));
        bt.delete(9);
        assertFalse(bt.containsNode(9));
    }


    @Test
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void treeNotEmpty() {
        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        assertFalse(bt.isEmpty());
    }

    @Test
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void existingElementNotAdded() {

        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        int initialSize = bt.getSize();

        assertTrue(bt.containsNode(3));
        bt.add(3);
        assertEquals(initialSize, bt.getSize());
    }

    @Test
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void nodeNotExistReturnsFalse() {

        BinaryTree bt = new BinaryTree();
        bt.add(6);
        bt.add(4);
        bt.add(8);
        bt.add(3);
        bt.add(5);
        bt.add(7);
        bt.add(9);

        assertFalse(bt.containsNode(99));
    }


    @Test
    @Benchmark
    @OutputTimeUnit(TimeUnit.MILLISECONDS)
    public void deleteTheRoot() {

        int value = 12;
        BinaryTree bt = new BinaryTree();
        bt.add(value);

        assertTrue(bt.containsNode(value));
        bt.delete(value);
        assertFalse(bt.containsNode(value));
    }
}
