package picasso.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import picasso.model.Pixmap;
import picasso.util.ThreadedCommand;
import picasso.view.commands.*;

/**
 * Main container for the Picasso application
 *
 * @author Robert Duvall (rcd@cs.duke.edu)
 * 
 */
@SuppressWarnings("serial")
public class Frame extends JFrame {

	public static JTextField expressionField;

	public Frame(Dimension size) {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		// create GUI components
		Canvas canvas = new Canvas(this);
		canvas.setSize(size);
		expressionField = new JTextField("Write your expression here");
		expressionField.setPreferredSize(new Dimension(100, 30));
		expressionField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (expressionField.getText().equals("Write your expression here")) {
					expressionField.setText("");
				}
			}
		});

		// add commands to test here
		ButtonPanel commands = new ButtonPanel(canvas);
		commands.add("Open", new Reader());
		commands.add("Evaluate", new ThreadedCommand<Pixmap>(canvas, new Evaluater()));
		commands.add("File Evaluate", new FileEvaluator());
		commands.add("Save", new Writer());
		commands.add("Save Expression", new Writer());
		commands.add("Random Image Generator", new ThreadedCommand<Pixmap>(canvas, new RandomEvaluator()));

		// add our container to Frame and show it
		getContentPane().add(canvas, BorderLayout.CENTER);
		getContentPane().add(commands, BorderLayout.SOUTH);
		getContentPane().add(expressionField, BorderLayout.NORTH);
		pack();

	}
}
