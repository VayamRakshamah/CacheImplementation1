package GuavaLRU;

public class CacheNode {
    String data;

    public CacheNode(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "CacheNode{" +
                "data='" + data + '\'' +
                '}';
    }
}
