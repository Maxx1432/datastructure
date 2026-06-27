public class MaxPQ {
    private Integer [] heap;
    private int n; //Size of max heap

    public MaxPQ(int capacity) {
        heap = new Integer[capacity + 1];
        n = 0;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }

    public static void main(String[] args) {
        MaxPQ obj = new MaxPQ(10);
        System.out.println(obj.size()); // return the size of heap
        System.out.println(obj.isEmpty()); // return true if heap is empty else false
    }
}
