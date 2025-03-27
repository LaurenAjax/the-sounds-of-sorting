package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;
import java.util.ArrayList;

/**
 * A <code>CopyEvent</code> logs a copy of a value into an index of the array.
 * @param <T>
 */
public class CopyEvent<T> implements SortEvent<T> {

    private T[] newArr;
    private int firstIndex;
    private int secondIndex;

    public CopyEvent(T[] array, int ind1, int ind2) {
        newArr = array;
        firstIndex = ind1;
        secondIndex = ind2;
    }
    
    @Override
    public void apply(T[] arr) {
        arr[firstIndex] = newArr[secondIndex];
    }

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<>();
        list.add(firstIndex);
        return list;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
    
}
