package LFU;

import LFU.LFUCache;

public class LFUCAcheService {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache();
        lfuCache.put("a");
        lfuCache.put("b");
        lfuCache.get("a");
        lfuCache.put("c");
        lfuCache.get("b");
        lfuCache.put("d");
        lfuCache.get("a");
        lfuCache.get("c");
        lfuCache.get("d");
        System.out.println("Number of cache evictions : "+lfuCache.cacheEvictions);
    }
}
