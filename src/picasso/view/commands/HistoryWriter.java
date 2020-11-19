package picasso.view.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.view.Frame;

public class HistoryWriter implements Command<Pixmap> {

	private final String defaultFileName = "expressions/history.exp";
	private static int idNum = 1;
	
	public HistoryWriter() {
		countExpressions();
	}
	
	public void writeToHistory() {
		try {
			PrintWriter outHistory = new PrintWriter (new BufferedWriter(new FileWriter(defaultFileName, true)));
			outHistory.println(idNum + ": " + Frame.expressionField.getText());
			idNum++;
			outHistory.close();
		} catch (IOException e) {
			System.out.println("An IOException");
			e.printStackTrace();
		}
	}
	
	public void countExpressions() {
		BufferedReader reader;
		int lines = 1;
		try {
			reader = new BufferedReader(new FileReader(defaultFileName));
			while (reader.readLine() != null) {
				lines++;
			}
			idNum = lines++;
			System.out.println(idNum);
			reader.close();
	} catch (FileNotFoundException e1) {
	} catch (IOException e) {
	}
		
}

	@Override
	public void execute(Pixmap target) {
		writeToHistory();
	}
}
