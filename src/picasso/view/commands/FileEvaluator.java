package picasso.view.commands;

import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;

/**
 * @author Abdelrahman AboEitta
 *
 */
public class FileEvaluator extends FileCommand<Pixmap> {

	public FileEvaluator() {
		super(JFileChooser.OPEN_DIALOG);
	}

	@Override
	public void execute(Pixmap target) {
	}

}
