import java.util.ArrayDeque;
import java.util.Queue;

public class QueueStackPushFriendly {

    private Queue<Integer> mainQueue = new ArrayDeque<>();
    private Queue<Integer> helperQueue = new ArrayDeque<>();

    // Add an element
    public void push(int value) {
        mainQueue.offer(value);
    }

    // Remove the top element
    public int pop() {
        if (mainQueue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        // Move all elements except the last one
        while (mainQueue.size() > 1) {
            helperQueue.offer(mainQueue.poll());
        }

        // The last element is the top of the stack
        int value = mainQueue.poll();

        // Swap the queues
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;

        return value;
    }

    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    public int size() {
        return mainQueue.size();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Size: " + stack.size());
    }
}
