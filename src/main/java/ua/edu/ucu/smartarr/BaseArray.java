package ua.edu.ucu.smartarr;

// Base array for decorators
public class BaseArray implements SmartArray {
    public Object[] arr;

    public BaseArray(Object[] arr) {
        this.arr = arr;
    }

    @Override
    public Object[] toArray() {
        return arr;
    }

    @Override
    public String operationDescription() {
        return "Base Array";
    }

    @Override
    public int size() {
        return arr.length;
    }
}
