package LFU;

import java.util.concurrent.ConcurrentHashMap;

public class LFUCache {

    //Total capacity of the cache
    final int CAPACITY;
    // Current size of the cache
    int currSize;
    //Minimum frequency of the entire LFU cache
    int minFrequency;
    //Number of evictions done from the cache
    int cacheEvictions;
    //Cache String and associated node in the Doubly Linked List
    ConcurrentHashMap<String, DllNode> cache;
    // frequency and list having same frequency
    ConcurrentHashMap<Integer,DllList> frequencyMap;

    //Field initialization
    public LFUCache() {
        this.CAPACITY = 100000;
        this.currSize = 0;
        this.minFrequency = 0;
        this.cache = new ConcurrentHashMap<>();
        this.frequencyMap = new ConcurrentHashMap<>();
        this.cacheEvictions=0;
    }

    public ConcurrentHashMap<String, DllNode> getCache() {
        return cache;
    }

    public ConcurrentHashMap<Integer, DllList> getFrequencyMap() {
        return frequencyMap;
    }

    public int getCAPACITY() {
        return CAPACITY;
    }

    public int getCurrSize() {
        return currSize;
    }

    public int getMinFrequency() {
        return minFrequency;
    }

    public int getCacheEvictions() {
        return cacheEvictions;
    }

    //get method to check if the key exists in the cache and prints it.
    public String get(String key){
        DllNode node  = cache.get(key);
        if(node == null){
            return key+" :Key does not exist";
        }
        //updateNode places the node at the front to make it most frequently used
        updateNode(node);
        return key+" :Key exists in cache";

    }

    public void put(String key){
        //If cache map contains the key the update its position on the Doubly Linked List
        if(cache.containsKey(key)){
            DllNode node = cache.get(key);
            updateNode(node);
        }
        else{
            //If capacity is exceeded then LFU node needs to be deleted
            currSize++;
            if(currSize>CAPACITY){
                // Get the minimum frequency list
                DllList minFrequencyList = frequencyMap.get(minFrequency);
                //Cache eviction
                cache.remove(minFrequencyList.tail.prev.key);
                minFrequencyList.removeNode(minFrequencyList.tail.prev);
                cacheEvictions++;
                currSize--;
            }
            // Node to be added to the map , therefore minFrequency set to 1
            minFrequency =1;
            DllNode newNode = new DllNode(key);

            //Get list with frequency=1 and add node to list as well as cache map
            DllList currentList = frequencyMap.getOrDefault(1,new DllList());
            currentList.addNode(newNode);
            frequencyMap.put(1,currentList);
            cache.put(key,newNode);
        }
    }

    //Update the node into the map and DLL
    public void updateNode(DllNode node){
        int currentFrequency = node.frequency;
        DllList currList = frequencyMap.get(currentFrequency);
        currList.removeNode(node);

        // if minFrequency list has no node then minFrequency increases
        if(currentFrequency == minFrequency && currList.sizeOfList == 0){
            minFrequency++;
        }

        // The frequency of this node increases
        node.frequency++;

        //Add node to its frequency appropriate list
        //If list does not exist then initialize it
        DllList newList =frequencyMap.getOrDefault(node.frequency,new DllList());
        newList.addNode(node);
        frequencyMap.put(node.frequency,newList);
    }


}
