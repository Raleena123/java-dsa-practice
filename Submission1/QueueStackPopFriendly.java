import java.util.ArrayDeque;
import java.util.Queue;

// Pop is O(1); push is O(n).
public class QueueStackPopFriendly {
    private Queue<Integer> mainQueue = new ArrayDeque<>();
    private Queue<Integer> helperQueue = new ArrayDeque<>();

    public void push(int value) {
        helperQueue.offer(value);
        while (!mainQueue.isEmpty()) helperQueue.offer(mainQueue.remove());

        Queue<Integer> temp = mainQueue;
        mainQueue = helperQueue;
        helperQueue = temp;
    }

    public int pop() {
        if (mainQueue.isEmpty()) throw new IllegalStateException("Stack is empty");
        return mainQueue.remove();
    }

    public int peek() {
        if (mainQueue.isEmpty()) throw new IllegalStateException("Stack is empty");
        return mainQueue.element();
    }

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
