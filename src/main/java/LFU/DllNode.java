package LFU;

public class DllNode {

    //previous pointer of the node
    DllNode prev;
    //next pointer of the node
    DllNode next;
    //Cache field of string type
    String key;
    //Cache value //TODO
    int value;
    //frequency count of current node
    int frequency;

    //Constructor
    public DllNode(String key) {
        this.key = key;
        this.value=-1; //TODO
        this.frequency=1;
    }
}
