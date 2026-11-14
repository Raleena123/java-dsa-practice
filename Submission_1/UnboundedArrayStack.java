public class UnboundedArrayStack {

    private int[] data = new int[2];
    private int size = 0;

    // Add an element. Double the array when it is full.
    public void push(int value) {
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

    // Remove the top element. Reduce the array when it is half empty.
    public int pop() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return -1;
        }

        size--;
        int value = data[size];
        data[size] = 0;

        if (data.length > 2 && size <= data.length / 2) {
            int[] newData = new int[data.length / 2];

            for (int i = 0; i < size; i++) {
                newData[i] = data[i];
            }

            data = newData;
        }

        return value;
    }

    public int peek() {
        if (size == 0) {
            System.out.println("Stack is empty");
            return -1;
        }

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

        // Add 8 elements to test array growth
        for (int i = 1; i <= 8; i++) {
            stack.push(i);
        }

        System.out.println("Size after push: " + stack.size());
        System.out.println("Capacity after push: " + stack.capacity());

        // Remove all elements to test array shrinking
        while (!stack.isEmpty()) {
            System.out.println("Popped: " + stack.pop());
        }

        System.out.println("Capacity after pop: " + stack.capacity());
    }
}
