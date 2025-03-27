package edu.grinnell.csc207.soundsofsorting;

import java.util.Random;

/**
 * A collection of indices into a Scale object.
 * These indices are the subject of the various sorting algorithms
 * in the program.
 */
public class NoteIndices {
    
    private Integer[] notes;
    private Boolean[] highlighted;
    
    /**
     * @param n the size of the scale object that these indices map into
     */
    public NoteIndices(int n) {
        notes = new Integer[n];
        highlighted = new Boolean[n];
    }
    
    /**
     * Reinitializes this collection of indices to map into a new scale object
     * of the given size.  The collection is also shuffled to provide an
     * initial starting point for the sorting process.
     * @param n the size of the scale object that these indices map into
     */
    public void initializeAndShuffle(int n) {
        notes = new Integer[n];
        highlighted = new Boolean[n];
        Integer arr[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        Random rand = new Random();
        for (int j = 0; j < n; j++) {
            int k = rand.nextInt(n);
            if (arr[k] == -1) {
                j--;
            } else {
                notes[j] = arr[k];
                arr[k] = -1;
            }
        }
        for (int l = 0; l < n; l++) {
            highlighted[l] = false;
        }
    }
    
    /** @return the indices of this NoteIndices object */
    public Integer[] getNotes() { 
        return notes;
    }
    
    /**
     * Highlights the given index of the note array
     * @param index the index to highlight
     */
    public void highlightNote(int index) {
        highlighted[index] = true;
    }
    
    /**
     * @param index the index to check
     * @return true if the given index is highlighted
     */
    public boolean isHighlighted(int index) {
        return highlighted[index];
    }
    
    /** Clears all highlighted indices from this collection */
    public void clearAllHighlighted() {
        for (int l = 0; l < highlighted.length; l++) {
            highlighted[l] = false;
        }
    }
}
