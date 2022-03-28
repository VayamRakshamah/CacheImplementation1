package LFUTests;

import LFU.LFUCache;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void cacheEvictionTest(){
        LFUCache cache = new LFUCache();
        //Fill up the cache
        for(int i=0;i<cache.getCAPACITY();i++){
            cache.put(String.valueOf(Math.random()));
        }
        //Check if cache is filled
        assertEquals(100000,cache.getCurrSize());
        assertEquals(cache.getCurrSize(),cache.getCAPACITY());
        cache.put("end_val1");
        assertNotEquals(0,cache.getCacheEvictions());
        assertEquals(1,cache.getCacheEvictions());
        cache.put("end_val2");
        cache.put("end_val3");
        cache.put("end_val4");
        //Check if evictions have occurred
        assertNotEquals(0,cache.getCacheEvictions());
        //Check the number of evictions
        assertEquals(4,cache.getCacheEvictions());


    }
}
