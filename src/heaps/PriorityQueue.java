package heaps;

import java.util.ArrayList;
import java.util.List;

/*
Max Heap implemented using priority queue
 */
public class PriorityQueue {
    private List<Integer> queue;

    public PriorityQueue(List<Integer> queue) {
        this.queue = queue;
    }

    public void heapify(int index) {
        int largest = index;
        int size = this.queue.size();
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && (this.queue.get(left) > this.queue.get(largest))) {
            largest = left;
        }
        if (right < size && (this.queue.get(right) > this.queue.get(largest))) {
            largest = right;
        }

        if (largest != index) {
            int tmp = this.queue.get(index);
            this.queue.set(index, this.queue.get(largest));
            this.queue.set(largest, tmp);
            heapify(largest);
        }
    }

    public void insert(Integer element) {
        this.queue.add(element);
        int size = this.queue.size();

        for (int i = (size / 2) -1; i >=0 ;i--) {
            this.heapify(i);
        }
    }

    public void delete(int element) {
        if (this.queue != null && !this.queue.isEmpty()) {
            if (this.queue.contains(element)) {
                int index = this.queue.indexOf(element);
                int size = this.queue.size() - 1;
                this.queue.set(index, this.queue.get(size));
                this.queue.set(size, element);
                this.queue.remove(element);
                size = this.queue.size();

                for (var i = size / 2 -1; i >=0 ; i--) {
                    this.heapify(i);
                }
            } else {
                System.err.println("Unable to find the item " + element);
            }
        } else {
            System.err.println("Queue is empty");
        }
    }

    public Integer getMax() {
        return !this.queue.isEmpty() ? this.queue.get(0) : null;
    }

    public Integer extractMax() {
        Integer root;
        if (this.queue != null && !this.queue.isEmpty()) {
            root = this.queue.get(0);
            int size = this.queue.size() - 1;
            this.queue.set(0, this.queue.get(size));
            this.queue.set(size, root);
            this.queue.remove(root);
            size = this.queue.size();

            for (var i = size / 2 - 1; i >= 0; i--) {
                heapify(i);
            }
            return root;
        } else {
            System.err.println("Queue is empty");
        }
        return null;
    }

    public void printQueue() {
        if (this.queue != null && !this.queue.isEmpty()) {
            this.queue.forEach(x -> System.out.print(x + " "));
        }
    }

    public static void main(String[] args) {
        List<Integer> queue = new ArrayList<>();
        PriorityQueue priorityQueue = new PriorityQueue(queue);
        priorityQueue.insert(10);
        priorityQueue.insert(20);
        priorityQueue.insert(30);
        priorityQueue.insert(100);
        priorityQueue.insert(40);
        priorityQueue.insert(30);
        priorityQueue.insert(50);
        priorityQueue.insert(70);
        priorityQueue.printQueue();
    }
}
