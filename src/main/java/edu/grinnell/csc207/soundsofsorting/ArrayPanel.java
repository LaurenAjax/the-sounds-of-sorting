package edu.grinnell.csc207.soundsofsorting;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;

import javax.swing.JPanel;

/**
 * A drawing panel for visualizing the contents of a @NoteIndices object.
 */
public class ArrayPanel extends JPanel {
    @SuppressWarnings("unused")
    private NoteIndices notes;
    private int width;
    private int height;
   
    /**
     * Create a new <code>ArrayPanel</code> with the given notes and dimensions.
     * @param notes the note indices 
     * @param width the width of the panel
     * @param height the height of the panel
     */
    public ArrayPanel(NoteIndices notes, int width, int height) {
        this.notes = notes;
        this.setPreferredSize(new Dimension(width, height));
        this.width = width;
        this.height = height;
        
    }

    @Override
    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, width, height);
        int length = notes.getNotes().length;
        int rectWidth = width / length;
        int rectHeight;
        double proportion;
        for (int i = 0; i < length; i++) {
            proportion = (notes.getNotes()[i] + 1) / (double) length;
            rectHeight = (int) (height * proportion);
            if (notes.isHighlighted(i)) {
                g.setColor(Color.black);
            } else if (i % 6 == 5) {
                g.setColor(Color.pink);
            } else if (i % 6 == 4) {
                g.setColor(Color.blue);
            } else if (i % 6 == 3) {
                g.setColor(Color.green);
            } else if (i % 6 == 2) {
                g.setColor(Color.yellow);
            } else if (i % 6 == 1) {
                g.setColor(Color.orange);
            } else {
                g.setColor(Color.red);
            }
            g.fillRect(i * rectWidth, height - rectHeight, rectWidth, rectHeight);
        }
    }
}