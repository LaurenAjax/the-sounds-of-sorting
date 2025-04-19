package edu.grinnell.csc207.soundsofsorting.sortevents;

import java.util.List;
import java.util.ArrayList;

/**
 * A <code>CompareEvent</code> logs a comparison a sort makes between two
 * indices in the array.
 * @param <T>
 */
public class CompareEvent<T extends Comparable<? super T>> implements SortEvent<T> {
    
    private int firstIndex;
    private int secondIndex;

    /**
     * Creates a new CompareEvent
     * 
     * @param ind1 the index being compared
     * @param ind2 the other index being compared
     */
    public CompareEvent(int ind1, int ind2) {
        firstIndex = ind1;
        secondIndex = ind2;
    }
    
    @Override
    public void apply(T[] arr) { }

    @Override
    public List<Integer> getAffectedIndices() {
        List<Integer> list = new ArrayList<>();
        list.add(firstIndex);
        list.add(secondIndex);
        return list;
    }

    @Override
    public boolean isEmphasized() {
        return false;
    }
    
}
