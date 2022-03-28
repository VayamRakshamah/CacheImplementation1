package LRUTests;

import LRU.LRUCache;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class LRUCacheTests {

    @Test
    public void capacityTest(){
        LRUCache cache = new LRUCache();
        assertEquals(100000,cache.getCapacity());
    }

    @Test
    public void getTest(){
        LRUCache cache = new LRUCache();
        cache.put("a");
        cache.put("b");
        assertEquals("This string exists in Cache : a",cache.get("a"));
        assertEquals("This string does not exist in Cache : c",cache.get("c"));
    }

    @Test
    public void putTest(){
        LRUCache cache = new LRUCache();
        cache.put("a");
        assertTrue(cache.getMap().containsKey("a"));
    }
}
