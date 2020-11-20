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

/**
 * Saves an expression from the text box to a history file
 * 
 * @author Danny
 *
 */
public class HistoryWriter implements Command<Pixmap> {

	public final String defaultFileName = "expressions/history.exp";
	private static int idNum = 1;

	/**
	 * count the expressions in history file every time the program starts
	 */
	public HistoryWriter() {
		countExpressions();
	}

	/**
	 * Writes an expression to the history file
	 */
	public void writeToHistory() {
		try {
			PrintWriter outHistory = new PrintWriter(new BufferedWriter(new FileWriter(defaultFileName, true)));
			outHistory.println(idNum + ": " + Frame.expressionField.getText());
			idNum++;
			outHistory.close();
		} catch (IOException e) {
			System.out.println("An IOException");
			e.printStackTrace();
		}
	}

	/**
	 * get the number of lines in the history file
	 * 
	 * @return num of lines
	 */
	public int getNumOfLines() {
		countExpressions();
		int copyNum = idNum;
		return copyNum;
	}

	/**
	 * count the number of expressions or lines in the history file
	 */
	public void countExpressions() {
		BufferedReader reader;
		int lines = 1;
		try {
			reader = new BufferedReader(new FileReader(defaultFileName));
			while (reader.readLine() != null) {
				lines++;
			}
			idNum = lines++;
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
