import java.util.ArrayDeque;
import java.util.Deque;

public class StackQueueEnqueueFriendly {

    private Deque<Integer> stack = new ArrayDeque<>();

    // Add an element to the queue
    public void enqueue(int value) {
        stack.push(value);
    }

    // Remove the first element
    public int dequeue() {

        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Deque<Integer> helper = new ArrayDeque<>();

        // Move elements to helper stack
        while (stack.size() > 1) {
            helper.push(stack.pop());
        }

        int front = stack.pop();

        // Move elements back
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }

        return front;
    }

    // Get the first element
    public int peek() {

        if (stack.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        Deque<Integer> helper = new ArrayDeque<>();

        // Move elements to helper stack
        while (stack.size() > 1) {
            helper.push(stack.pop());
        }

        int front = stack.pop();

        // Put the front element back
        helper.push(front);

        // Restore original stack
        while (!helper.isEmpty()) {
            stack.push(helper.pop());
        }

        return front;
    }

    // Check whether queue is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {

        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());
    }
}
