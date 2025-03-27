package storage;

public class ArrayStack<T> {

    private Object[] data;
    private int manyItems;

    public ArrayStack() {
        manyItems = 0;
    }

    public T pop(int index) {
        Object[] newData = new Object[manyItems];

        if (index < manyItems) {
            System.arraycopy(data, 0, newData, index, index);
            System.arraycopy(data, index + 1, newData, manyItems);
        }
    }
}
