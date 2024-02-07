import java.util.Arrays;

public class MyMinHeap {
    int MAX_SIZE = 100;
    int heap[] = new int[MAX_SIZE];
    int size = 0;

    public int remove() {
        int d = heap[0];
        heap[0] = heap[--size];
        int p = 0;
        while (true) {
            int left = 2 * p + 1;
            if (left >= size)
                break; // no child
            int right = 2 * p + 2;
            if (right == size) { // one child
                if (heap[p] > heap[left])
                    swap(p, left);
                break; // no more child, nothing to do
            } else { // two childs
                int q = heap[left] < heap[right] ? left : right;
                if (heap[p] > heap[q])
                    swap(p, q);
                else
                    break;
                p = q;
            }
        } // end while
        return d;
    }

    void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;

    }

    public int peek() {
        return heap[size - 1];
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        return "MyMinHeap [MAX_SIZE=" + MAX_SIZE + ", heap=" + Arrays.toString(heap) + ", size=" + size + "]";
    }

    public void insert(int d) {
        int p = size++;
        heap[p] = d;
        int parent = (p - 1) / 2;
        while ((p > 0) && (heap[p] < heap[parent])) {
            swap(p, parent);
            p = parent;
            parent = (p - 1) / 2;
        }
    }
}