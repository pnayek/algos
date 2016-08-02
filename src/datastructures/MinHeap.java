package datastructures;

public class MinHeap {

	private int capacity;
    private int heapSize = 0;
    private int[] a;
    
    public MinHeap(int capacity) {
        this.capacity = capacity;
        a = new int[capacity];
    }
    
    public void insert(int n) {
        a[heapSize++] = n;
        int i = heapSize - 1;
        int pi = parent(i);
        while (i >= 0 && pi >= 0 && a[i] < a[pi]) {
            int temp = a[i];
            a[i] = a[pi];
            a[pi] = temp;
            i = pi;
            pi = parent(i);
        }
    }
    
    public void delete(int n) {
        int i = search(0, n);
        if (i >= 0) {
            a[i] = a[--heapSize];
            heapify(i);
        }
    }
    
    public void printMin() {
        if (heapSize > 0)
            System.out.println(a[0]);
    }
    
    private int parent(int i) {
        if (i <= 0) return -1;
        return (i - 1) / 2;
    }
    
    private int left(int i) {
        if (i < 0) return -1;
        int left = 2 * i + 1;
        return left < heapSize ? left : -1; 
    }
    
    private int right(int i) {
        if (i < 0) return -1;
        int right = 2 * (i + 1);
        return right < heapSize ? right : -1;
    }
    
    private int search(int rootIndex, int n) {
        if (rootIndex < 0) return -1;
        if (a[rootIndex] > n) return -1;
        if (a[rootIndex] == n) return rootIndex;
        int leftIndex = left(rootIndex);
        int lefti = search(leftIndex, n);
        if (lefti >= 0) return lefti;
        int rightIndex = right(rootIndex);
        return search(rightIndex, n);
    }
    
    private void heapify(int i) {
        if (i < 0 || i >= heapSize/2) return;
        int leftIndex = left(i);
        int smallestIndex = a[leftIndex] < a[i] ? leftIndex : i;
        int rightIndex = right(i);
        if (rightIndex >= 0)
        	smallestIndex = a[rightIndex] < a[smallestIndex] ? rightIndex : smallestIndex;
        if (smallestIndex == i) return;
        int temp = a[i];
        a[i] = a[smallestIndex];
        a[smallestIndex] = temp;
        heapify(smallestIndex);
    }
}
