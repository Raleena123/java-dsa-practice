import java.util.Arrays;

// Grows when full and shrinks when the stack becomes sparsely occupied.
public class UnboundedArrayStack {
    private int[] data = new int[2];
    private int size = 0;

    public void push(int value) {
        if (size == data.length) {
            data = Arrays.copyOf(data, data.length * 2);
        }
        data[size++] = value;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");

        int value = data[--size];
        data[size] = 0;

        if (data.length > 2 && size <= data.length / 4) {
            data = Arrays.copyOf(data, Math.max(2, data.length / 2));
        }
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty");
        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public int capacity() {
        return data.length;
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();

        for (int i = 1; i <= 8; i++) stack.push(i);
        System.out.println("Size: " + stack.size());
        System.out.println("Capacity after push: " + stack.capacity());

        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }
        System.out.println("Capacity after pop: " + stack.capacity());
    }
}
