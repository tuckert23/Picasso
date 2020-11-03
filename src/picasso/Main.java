package picasso;

import java.awt.Dimension;

import picasso.view.Frame;

/**
 * Starting point for Picasso.
 * 
 * @author Robert Duvall (rcd@cs.duke.edu)
 */
public class Main {
	public static final Dimension SIZE = new Dimension(600, 600);

	public static void main(String[] args) {
		Frame frame = new Frame(SIZE);
		frame.setVisible(true);
	}
}
