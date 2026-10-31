import java.util.ArrayDeque;
import java.util.Deque;

// Enqueue is O(1); dequeue and peek are O(n).
public class StackQueueEnqueueFriendly {
    private final Deque<Integer> stack = new ArrayDeque<>();

    public void enqueue(int value) {
        stack.push(value);
    }

    public int dequeue() {
        if (stack.isEmpty()) throw new IllegalStateException("Queue is empty");

        Deque<Integer> helper = new ArrayDeque<>();
        while (stack.size() > 1) helper.push(stack.pop());

        int front = stack.pop();

        while (!helper.isEmpty()) stack.push(helper.pop());
        return front;
    }

    public int peek() {
        if (stack.isEmpty()) throw new IllegalStateException("Queue is empty");

        Deque<Integer> helper = new ArrayDeque<>();
        while (stack.size() > 1) helper.push(stack.pop());

        int front = stack.pop();
        helper.push(front);

        while (!helper.isEmpty()) stack.push(helper.pop());
        return front;
    }

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
