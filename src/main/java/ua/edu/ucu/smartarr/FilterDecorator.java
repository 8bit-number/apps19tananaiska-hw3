package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate pd;


    public FilterDecorator(SmartArray smartArray, MyPredicate pd) {
        super(smartArray);
        this.pd = pd;
    }

    public Object[] removeNotNeeded() {
        Object[] array = super.smartArray.toArray();
        List<Object> removed = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (pd.test(array[i])) {
                removed.add(array[i]);
            }
        }
        return removed.toArray();

    }

    @Override
    public Object[] toArray() {
        return removeNotNeeded();
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }

//    public static void main(String[] args) {
//        MyPredicate pd1 = t -> ((Integer) t) > 10;
//
//        FilterDecorator dd = new FilterDecorator(new BaseArray(new Object[]{1, 2, 33, 3, 3, 4}), pd1);
//        System.out.println(dd.removeNotNeeded());
//
//
//    }
}

