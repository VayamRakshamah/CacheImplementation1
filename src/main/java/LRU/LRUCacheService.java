package LRU;

public class LRUCacheService {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put("a");
        lruCache.put("b");
        lruCache.get("a");
        lruCache.put("c");
        lruCache.get("b");
        lruCache.put("d");
        lruCache.get("a");
        lruCache.get("c");
        lruCache.get("d");
    }
}
