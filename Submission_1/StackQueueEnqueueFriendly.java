import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueueEnqueueFriendly {

    private Deque<Integer> mainStack = new ArrayDeque<>();
    private Deque<Integer> helperStack = new ArrayDeque<>();

    // Add an element to the queue
    public void enqueue(int value) {
        mainStack.push(value);
    }

    // Remove the oldest element from the queue
    public int dequeue() {
        if (mainStack.isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }

        // Move all elements except the oldest one
        while (mainStack.size() > 1) {
            helperStack.push(mainStack.pop());
        }

        // Remove the oldest element
        int value = mainStack.pop();

        // Move the other elements back
        while (!helperStack.isEmpty()) {
            mainStack.push(helperStack.pop());
        }

        return value;
    }

    public boolean isEmpty() {
        return mainStack.isEmpty();
    }

    public int size() {
        return mainStack.size();
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();

        queue.enqueue(5);
        queue.enqueue(7);
        queue.enqueue(9);

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
    }
}
