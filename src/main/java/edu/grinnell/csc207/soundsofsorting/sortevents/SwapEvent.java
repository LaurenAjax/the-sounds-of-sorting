package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;
import java.util.ArrayList;

/**
 * A <code>SwapEvent</code> logs a swap between two indices of the array.
 * @param <T>
 */
public class SwapEvent<T> implements SortEvent<T> {

    private int firstIndex;
    private int secondIndex;

    /**
     * Creates a new SwapEvent
     * 
     * @param ind1 the index swapping elements
     * @param ind2 the index the other index is swapping elements with
     */
    public SwapEvent(int ind1, int ind2) {
        firstIndex = ind1;
        secondIndex = ind2;
    }
    
    @Override
    public void apply(T[] arr) {
        T tmp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = tmp;
    }

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<>();
        list.add(firstIndex);
        list.add(secondIndex);
        return list;
    }

    @Override
    public boolean isEmphasized() {
        return true;
    }
    
}
