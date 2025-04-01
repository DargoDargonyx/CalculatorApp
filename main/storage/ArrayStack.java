package storage;

public class ArrayStack<T> {

    private Object[] data;
    private int manyItems;

    public ArrayStack() {
        manyItems = 0;
        data = new Object[0];
    }

    public T push(T item) {
        Object[] newData = new Object[getLength() + 1];
        System.arraycopy(data, 0, newData, 0, getLength());
        newData[getLength()] = item;
        data = newData;

        manyItems++;
        return item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        Object[] newData = new Object[getLength()];
        T dataToPop = (T) data[getLength()];

        if (getLength() > 0) 
            System.arraycopy(data, 0, newData, 0, getLength() - 1);
        data = newData;
        return dataToPop;
    }

    public int getLength() {
        return manyItems;
    }

    public String toString() {
        String str = "<";
        for (int i = 0; i < getLength(); i++) {
            if (i == getLength() - 1) {
                str += data[i];
            }
            else str += data[i] + ", ";
        }
        str += ">";
        return str;
    }
}
