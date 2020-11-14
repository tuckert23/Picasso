package picasso.view.commands;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;
import picasso.util.FileCommand;
import picasso.view.Frame;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class FileEvaluator extends FileCommand<Pixmap> {

	String expression = "";
	ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
	
	public FileEvaluator() {
		super(JFileChooser.OPEN_DIALOG);
	}

	@Override
	public void execute(Pixmap target) {
		String fileName = getFileName();
		if (fileName != null) {
			try {
				File myFile = new File(fileName);
				Scanner myReader = new Scanner(myFile);
				while (myReader.hasNextLine()) {
					expression = myReader.nextLine();
				}
				myReader.close();
				Frame.expressionField.setText(expression);
			} catch (FileNotFoundException e) {
				System.out.println("An error occurred.");
				e.printStackTrace();
			}
		}
	}
}
