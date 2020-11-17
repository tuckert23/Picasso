package picasso.view.commands;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

import picasso.model.Pixmap;
import picasso.util.FileCommand;
import picasso.view.Frame;

public class HistoryWriter extends FileCommand<Pixmap> {

	public HistoryWriter() {
		super(JFileChooser.SAVE_DIALOG);
	}

	@Override
	public void execute(Pixmap target) {
		String fileName = getFileName();
		if (fileName != null) {
			try {
				FileWriter expressionWriter = new FileWriter(fileName);
				expressionWriter.write(Frame.expressionField.getText());
				expressionWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
