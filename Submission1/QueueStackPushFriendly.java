import java.util.ArrayDeque;
import java.util.Queue;

// Push is O(1); pop and peek are O(n).
public class QueueStackPushFriendly {
    private final Queue<Integer> queue = new ArrayDeque<>();

    public void push(int value) {
        queue.offer(value);
    }

    public int pop() {
        if (queue.isEmpty()) throw new IllegalStateException("Stack is empty");
        int size = queue.size();
        for (int i = 1; i < size; i++) queue.offer(queue.remove());
        return queue.remove();
    }

    public int peek() {
        if (queue.isEmpty()) throw new IllegalStateException("Stack is empty");
        int size = queue.size();
        for (int i = 1; i < size; i++) queue.offer(queue.remove());
        int top = queue.remove();
        queue.offer(top);
        return top;
    }

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
