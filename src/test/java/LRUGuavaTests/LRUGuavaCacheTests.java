package LRUGuavaTests;

import com.google.common.cache.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

public class LRUGuavaCacheTests {

    @Test
    public void whenCacheMiss_thenValueIsComputed() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key;
            }
        };

        LoadingCache<String, String> cache;
        //Cache capacity defined to be 100000
        cache = CacheBuilder.newBuilder().maximumSize(100000).build(loader);

        assertEquals(0, cache.size());
        //getUnchecked caches and loads if the value does not exist
        assertEquals("hello", cache.getUnchecked("hello"));
        assertEquals(1, cache.size());
    }

    @Test
    public void putMethodCheck() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key;
            }
        };

        LoadingCache<String, String> cache;
        //Cache capacity defined to be 100000
        cache = CacheBuilder.newBuilder().maximumSize(100000).build(loader);

        assertEquals(0, cache.size());
        //getUnchecked caches and loads if the value does not exist
        cache.put("hello","hello");
        assertEquals(1, cache.size());
    }


    @Test
    //when entry not used for 5 seconds then evict it
    public void whenEntryIdle_thenEviction()
            throws InterruptedException {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key;
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumSize(100000)
                .expireAfterAccess(5, TimeUnit.SECONDS)
                .build(loader);

        cache.getUnchecked("hello");
        assertEquals(1, cache.size());

        cache.getUnchecked("hello");
        Thread.sleep(6000);

        cache.getUnchecked("test");
        assertEquals(1, cache.size());
        assertNull(cache.getIfPresent("hello"));
    }


    @Test
    public void whenEntryRemovedFromCache_thenNotify() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(final String key) {
                return key;
            }
        };

        RemovalListener<String, String> listener;
        listener = new RemovalListener<String, String>() {
            @Override
            public void onRemoval(RemovalNotification<String, String> n){
                if (n.wasEvicted()) {
                    String cause = n.getCause().name();
                    assertEquals(RemovalCause.SIZE.toString(),cause);
                }
            }
        };

        LoadingCache<String, String> cache;
        cache = CacheBuilder.newBuilder()
                .maximumSize(3)
                .removalListener(listener)
                .build(loader);

        cache.getUnchecked("first");
        cache.getUnchecked("second");
        cache.getUnchecked("third");
        cache.getUnchecked("last");
        assertEquals(3, cache.size());
    }


    @Test
    public void CacheStats() {
        CacheLoader<String, String> loader;
        loader = new CacheLoader<String, String>() {
            @Override
            public String load(String key) {
                return key;
            }
        };

        LoadingCache<String, String> cache;
        //Cache capacity defined to be 100000
        cache = CacheBuilder.newBuilder().maximumSize(100000).recordStats().build(loader);

        assertEquals(0, cache.size());
        //getUnchecked caches and loads if the value does not exist
        assertEquals("hello", cache.getUnchecked("hello"));
        assertEquals(1, cache.size());

        //Create CacheStats obj to call its methods
        CacheStats stats = cache.stats();
        assertEquals(0.0,stats.hitRate());
        assertEquals(1.0,stats.missRate());
    }


}
