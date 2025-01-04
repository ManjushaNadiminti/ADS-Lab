import java.util.*;

class MinHeap {
    int[] arr;
    int heapsize, maxsize;
  public MinHeap(int ms) {
        maxsize = ms;
        heapsize = 0;
        arr = new int[maxsize];
    }
int parent(int i) {
        return (i - 1) / 2;
    }
int leftchild(int i) {
        return (2 * i + 1);
    }
  int rightchild(int i) {
        return (2 * i + 2);
    }
    void insertkey(int x) {
        if (heapsize == maxsize) {
            System.out.println("Cannot insert, heap is full");
            return;
       }
        int i = heapsize;
        arr[i] = x;
        heapsize++;
        while (i != 0 && arr[parent(i)] > arr[i]) {
            int temp = arr[i];
            arr[i] = arr[parent(i)];
            arr[parent(i)] = temp;
            i = parent(i);
        }
    }
    void removeMin() {
        if (heapsize <= 0) {
            System.out.println("Heap does not exist");
        } else if (heapsize == 1) {
            heapsize--;
        } else {
            arr[0] = arr[heapsize - 1];
            heapsize--;
            minHeapify(0);
        }
    }


    void minHeapify(int i) {
        int l = leftchild(i);
        int r = rightchild(i);
        int smallest = i;

        if (l < heapsize && arr[l] < arr[smallest]) {
            smallest = l;
        }

        if (r < heapsize && arr[r] < arr[smallest]) {
            smallest = r;
        }

        
        if (smallest != i) {
            int temp = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = temp;
            minHeapify(smallest);
        }
    }

    int curSize() {
        return heapsize;
        }
    int getMin() {
        if (heapsize > 0) {
            return arr[0];
        }
        return Integer.MAX_VALUE; 
    }

    public static void main(String args[]) {
        MinHeap h = new MinHeap(15);
        int elements[] = {3, 10, 12, 8, 2, 14};
        for(int e: elements) {
           h.insertkey(e);
           }
        System.out.println("The current size of heap is: " + h.curSize());
        System.out.println("The current minimum of heap is: " + h.getMin());
        h.removeMin();
        System.out.println("The current size of heap is: " + h.curSize());
        h.insertkey(1);
        h.insertkey(5);
        System.out.println("The current size of heap is: " + h.curSize());
        System.out.println("The current minimum of heap is: " + h.getMin());
    }
}
