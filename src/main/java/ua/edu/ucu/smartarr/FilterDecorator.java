package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;

import java.util.ArrayList;
import java.util.List;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator {
    private MyPredicate pd;


    public FilterDecorator(SmartArray smartArray, MyPredicate pd) {
        super(smartArray);
        this.pd = pd;
    }

    @Override
    public Object[] toArray() {
        return filterItems();
    }

    @Override
    public String operationDescription() {
        return "Filter Decorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }

    private Object[] filterItems() {
        Object[] array = super.smartArray.toArray();
        List<Object> removed = new ArrayList<>();
        for (Object o : array) {
            if (pd.test(o)) {
                removed.add(o);
            }
        }
        return removed.toArray();

    }
}

