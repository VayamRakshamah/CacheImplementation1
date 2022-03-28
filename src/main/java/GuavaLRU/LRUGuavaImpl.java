package GuavaLRU;

import com.google.common.cache.*;

import java.util.concurrent.TimeUnit;

public class LRUGuavaImpl {
    public static void main(String[] args) {

        CacheLoader<CacheNode,String> loader = new CacheLoader<CacheNode, String>() {
            @Override
            public String load(CacheNode cacheNode) throws Exception {
                return cacheNode.data;
            }
        };

        Weigher<CacheNode,String> weighByLength = new Weigher<CacheNode, String>() {
            @Override
            public int weigh(CacheNode cacheNode, String s) {
                return s.length();
            }
        };

        LoadingCache<CacheNode,String> cache =
                CacheBuilder.newBuilder().concurrencyLevel(1)
                        .maximumSize(100000)
                        .recordStats()
                        .build(loader);


        System.out.println("Cache Size : "+cache.size());

        CacheNode node1 = new CacheNode("String1");
        System.out.println(cache.getUnchecked(node1));
        CacheNode node2 = new CacheNode("String2");
        System.out.println(cache.getUnchecked(node2));
        CacheNode node3 = new CacheNode("String3");
        System.out.println(cache.getUnchecked(node3));
        CacheNode node4 = new CacheNode("String4");
        System.out.println(cache.getUnchecked(node4));

        System.out.println("Cache Size : "+cache.size());

        CacheStats stats = cache.stats();
        System.out.println(stats.hitRate());
        System.out.println(stats.missRate());
        System.out.println(stats.loadExceptionRate());
        System.out.println(stats.averageLoadPenalty());

    }
}
