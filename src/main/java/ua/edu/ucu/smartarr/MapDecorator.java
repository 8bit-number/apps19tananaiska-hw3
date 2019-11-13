package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.ArrayList;
import java.util.List;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction func;


    public MapDecorator(SmartArray smartArray, MyFunction func) {
        super(smartArray);
        this.func = func;
    }

    @Override
    public Object[] toArray() {
        return mapFunction();
    }

    @Override
    public String operationDescription() {
        return "Map Decorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }

    private Object[] mapFunction() {
        Object[] array = super.smartArray.toArray();
        List<Object> removed = new ArrayList<>();
        for (Object o : array) {
            removed.add(func.apply(o));
        }
        return removed.toArray();
    }
}

