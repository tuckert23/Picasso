package picasso.view.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;

public class HistoryWriter implements Command<Pixmap> {

	private final String defaultFileName = "expressions/history.exp";
	private static int idNum = 1;

	public void writeToHistory() {
		try {
			PrintWriter outHistory = new PrintWriter (new BufferedWriter(new FileWriter(defaultFileName, true)));
			outHistory.println(idNum + ": " + Frame.expressionField.getText() + "\n\n");
			idNum++;
			outHistory.close();
		} catch (IOException e) {
			System.out.println("An IOException");
			e.printStackTrace();
		}
	}

	@Override
	public void execute(Pixmap target) {
		writeToHistory();
	}
}
