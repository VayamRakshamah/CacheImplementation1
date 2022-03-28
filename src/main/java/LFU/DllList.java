package LFU;

public class DllList {
    //head node
    DllNode head;
    //tail node
    DllNode tail;
    //Current size of the Doubly Linked List
    int sizeOfList;

    //Constructor
    public DllList() {
        //Head and tail initialized with a dummy value "#" to distinguish them
        this.head = new DllNode("#");
        this.tail = new DllNode("#");
        //initial size of list is 0
        this.sizeOfList = 0;
        //head points to tail initially
        head.next = tail;
        //tail points to head initially
        tail.prev = head;
    }

    //Add a node to the list.
    //Here addition always happens after head to show recent usage
    //Increase the size of the list
    public void addNode(DllNode node){
        DllNode headNext = head.next;
        node.next = headNext;
        node.prev = head;
        head.next = node;
        headNext.prev = node;
        sizeOfList++;
    }

    //Remove a node from the list
    //Decrease the size of the list
    public void removeNode(DllNode node){
        DllNode nodePrev = node.prev;
        DllNode nodeNext = node.next;
        nodePrev.next = nodeNext;
        nodeNext.prev = nodePrev;
        sizeOfList--;
    }
}
