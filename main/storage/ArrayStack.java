package storage;

public class ArrayStack<T> {

    private Object[] data;
    private int manyItems;

    public ArrayStack() {
        manyItems = 0;
        data = new Object[0];
    }

    public T push(T item) {
        try {
            Object[] newData = new Object[getLength() + 1];
            System.arraycopy(data, 0, newData, 0, getLength());
            newData[getLength()] = item;
            data = newData;
    
            manyItems++;
            return item;
            
        } catch (Exception e) {
            System.out.println("Exception in line 24 of Storage.ArrayStack.java");
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        try {
            Object[] newData = new Object[getLength() - 1];
            T dataToPop = (T) data[getLength() - 1];
    
            if (getLength() > 0) 
                System.arraycopy(data, 0, newData, 0, getLength() - 1);
            data = newData;
            manyItems--;
            return dataToPop;

        } catch (Exception e) {
            System.out.println("Exception in line 42 of Storage.ArrayStack.java");
            return null;
        }
    }

    public int getLength() {
        return manyItems;
    }

    public String toString() {
        String str = "<";
        for (int i = 0; i < getLength(); i++) {

            if (i == getLength() - 1) str += data[i];
            else str += data[i] + ", ";
            
        }
        str += ">";
        return str;
    }
}
