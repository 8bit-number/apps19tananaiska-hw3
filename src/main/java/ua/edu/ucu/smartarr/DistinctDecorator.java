package ua.edu.ucu.smartarr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {


    public DistinctDecorator(SmartArray smartArray) {
        super(smartArray);
    }

    @Override
    public Object[] toArray() {
        return removeDistinct();
    }


    @Override
    public String operationDescription() {
        return "Distinct decorator";
    }

    @Override
    public int size() {
        return toArray().length;
    }

    public Object[] removeDistinct() {
        Object[] array = super.smartArray.toArray();
        List<Object> list = Arrays.asList(array);
        List<Object> removed = new ArrayList<>();
//        for (int i = 0; i < array.length; i++) {
//            if (!removed.contains(list.get(i))) {
//                removed.add(list.get(i));
//            }
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (!(list.get(i).equals(list.get(j))) && (!(removed.contains(list.get(i))))) {
                    removed.add(list.get(i));
                }
            }
        }
        return removed.toArray();
    }

    //
//    public static void main(String[] args) {
//        DistinctDecorator dd = new DistinctDecorator(new BaseArray(new Object[]{1, 2, 33, 3, 3, 4}));
//        System.out.println(Arrays.toString(dd.toArray()));
//    }


//    }
}
