import java.util.ArrayDeque;
import java.util.Queue;

public class QueueStackPopFriendly {

    private Queue<Integer> mainQueue = new ArrayDeque<>();
    private Queue<Integer> helperQueue = new ArrayDeque<>();

    // Add an element to the stack
    public void push(int value) {

        helperQueue.add(value);

        // Move old elements to helperQueue
        while (!mainQueue.isEmpty()) {
            helperQueue.add(mainQueue.remove());
        }

        // Swap both queues
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;
    }

    // Remove the top element
    public int pop() {

        if (mainQueue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return mainQueue.remove();
    }

    // Get the top element
    public int peek() {

        if (mainQueue.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return mainQueue.element();
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    public static void main(String[] args) {

        QueueStackPopFriendly stack = new QueueStackPopFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Pop: " + stack.pop());
        System.out.println("Top: " + stack.peek());
    }
}
