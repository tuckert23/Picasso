package picasso.view.commands;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;

/**
 * Evaluates an expression from a file
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class FileEvaluator extends FileCommand<Pixmap> {

	Evaluater evaluate = new Evaluater();

	/**
	 * opens a dialog box to choose from
	 */
	public FileEvaluator() {
		super(JFileChooser.OPEN_DIALOG);
	}

	/**
	 * reads an expression from the file and execute it
	 */
	@Override
	public void execute(Pixmap target) {
		String fileName = getFileName();
		if (fileName != null) {
			target.readExpression(fileName);
			evaluate.execute(target);
		}
	}
}