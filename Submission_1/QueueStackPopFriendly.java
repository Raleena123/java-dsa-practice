import java.util.ArrayDeque;
import java.util.Queue;

public class QueueStackPopFriendly {

    private Queue<Integer> mainQueue = new ArrayDeque<>();
    private Queue<Integer> helperQueue = new ArrayDeque<>();

    // Add an element
    public void push(int value) {
        helperQueue.offer(value);

        // Move old elements behind the new element
        while (!mainQueue.isEmpty()) {
            helperQueue.offer(mainQueue.poll());
        }

        // Swap the queues
        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;
    }

    // Remove the top element
    public int pop() {
        if (mainQueue.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        return mainQueue.poll();
    }

    public boolean isEmpty() {
        return mainQueue.isEmpty();
    }

    public int size() {
        return mainQueue.size();
    }

    public static void main(String[] args) {
        QueueStackPopFriendly stack = new QueueStackPopFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Size: " + stack.size());
    }
}
