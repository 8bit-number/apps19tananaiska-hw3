package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator pd;


    public SortDecorator(SmartArray smartArray, MyComparator pd) {
        super(smartArray);
        this.pd = pd;
    }

    public Object[] removeNotNeeded() {
        Object[] array = super.smartArray.toArray();
        List<Object> list = Arrays.asList(array);
        list.sort(pd);
        return list.toArray();

    }

    @Override
    public Object[] toArray() {
        return removeNotNeeded();
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }

//    public static void main(String[] args) {
////        MyComparator pd1 = (o1, o2) -> Math.min(((Integer) o1), ((Integer) o2));
//        Comparator pd1 = new Comparator();
//        SortDecorator dd = new SortDecorator(new BaseArray(new Object[]{-1, 2, 0, 1, -5, 3}), pd1);
//        System.out.println(dd.removeNotNeeded());
//
//
//    }
}

