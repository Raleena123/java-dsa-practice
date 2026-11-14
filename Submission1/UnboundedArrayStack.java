import java.util.Arrays;

public class UnboundedArrayStack {

    private int[] data = new int[2];
    private int size = 0;

    // Add an element
    public void push(int value) {

        // Increase array size if full
        if (size == data.length) {
            int[] newData = new int[data.length * 2];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }
        
        data[size] = value;
        size++;
    }

    // Remove the top element
    public int pop() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        size--;

        int value = data[size];
        data[size] = 0;

        // Reduce array size when mostly empty
        if (data.length > 2 && size <= data.length / 4) {
            data = Arrays.copyOf(data, data.length / 2);
        }

        return value;
    }

    // Get the top element
    public int peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return data[size - 1];
    }

    // Check whether stack is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get number of elements
    public int size() {
        return size;
    }

    // Get array capacity
    public int capacity() {
        return data.length;
    }

    public static void main(String[] args) {

        UnboundedArrayStack stack = new UnboundedArrayStack();

        // Push 8 elements
        for (int i = 1; i <= 8; i++) {
            stack.push(i);
        }

        System.out.println("Size: " + stack.size());
        System.out.println("Capacity after push: " + stack.capacity());

        // Pop all elements
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        System.out.println("Capacity after pop: " + stack.capacity());
    }
}
