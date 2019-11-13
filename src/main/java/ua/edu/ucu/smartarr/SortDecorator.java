package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;

import java.util.Arrays;
import java.util.List;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator cmp;

    public SortDecorator(SmartArray smartArray, MyComparator cmp) {
        super(smartArray);
        this.cmp = cmp;
    }
    
    @Override
    public Object[] toArray() {
        return sortByFunc();
    }

    @Override
    public String operationDescription() {
        return "Sort Decorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }
    
    private Object[] sortByFunc() {
        Object[] array = super.smartArray.toArray();
        List<Object> list = Arrays.asList(array);
        list.sort(cmp);
        return list.toArray();
    }

}

