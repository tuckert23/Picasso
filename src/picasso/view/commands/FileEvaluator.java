package picasso.view.commands;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class FileEvaluator extends FileCommand<Pixmap> {

	Evaluater evaluate = new Evaluater();

	public FileEvaluator() {
		super(JFileChooser.OPEN_DIALOG);
	}

	@Override
	public void execute(Pixmap target) {
		String fileName = getFileName();
		if (fileName != null) {
			target.readExpression(fileName);
			evaluate.execute(target);
		}
	}
}