package LFUTests;

import LFU.LFUCache;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LFUCacheTests {

    @Test
    public void capacityTest(){
        LFUCache cache = new LFUCache();
        assertEquals(100000,cache.getCAPACITY());
    }

    @Test
    public void getTest(){
        LFUCache cache = new LFUCache();
        cache.put("a");
        cache.put("b");
        assertEquals("a :Key exists in cache",cache.get("a"));
        assertEquals("c :Key does not exist",cache.get("c"));
    }

    @Test
    public void putTest(){
        LFUCache cache = new LFUCache();
        cache.put("a");
        assertTrue(cache.getCache().containsKey("a"));
    }
}
