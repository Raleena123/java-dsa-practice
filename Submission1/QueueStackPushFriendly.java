import java.util.ArrayDeque;
import java.util.Queue;

public class QueueStackPushFriendly {

    private Queue<Integer> queue = new ArrayDeque<>();

    // Add an element to the stack
    public void push(int value) {
        queue.add(value);
    }

    // Remove the top element
    public int pop() {

        if (queue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int size = queue.size();

        // Move all elements except the last one
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }

        return queue.remove();
    }

    // Get the top element
    public int peek() {

        if (queue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        int size = queue.size();

        // Move all elements except the last one
        for (int i = 0; i < size - 1; i++) {
            queue.add(queue.remove());
        }

        int top = queue.remove();

        // Put the top element back
        queue.add(top);

        return top;
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {

        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.peek());
    }
}
