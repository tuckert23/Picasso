package picasso.view.commands;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

import picasso.model.Pixmap;
import picasso.util.Command;

public class ShowHistory implements Command<Pixmap> {

	private int numOfElements;
	private  JList list;
	private  JScrollPane pane;
	private  JFrame frame;
	private  JButton btnGet;
	HistoryWriter historyWriter;

	private void displayHistory() {
		frame = new JFrame("Expressions History");
		historyWriter = new HistoryWriter();
		numOfElements = historyWriter.getNumOfLines();

		String[] listOfIDs = new String[numOfElements];
		for (int i = 1; i < numOfElements; i++) {
			listOfIDs[i] = "ID: " + i;
		}

		list = new JList(listOfIDs);
		pane = new JScrollPane(list);
		btnGet = new JButton("Show Expression");

		btnGet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String selectedElem = "";
				int selectedIndices[] = list.getSelectedIndices();
				for (int index : selectedIndices) {
					selectedElem = selectedElem + "#" + getExpressionFromID(index) + "\n";
				}
				JOptionPane.showMessageDialog(frame, "You selected: \n" + selectedElem);
			}
		});
	}

	private String getExpressionFromID(int idNum) {
		String result = "";
		int index = 1;
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(historyWriter.defaultFileName));
			while (index <= idNum) {
				index++;
				result = reader.readLine();
			}
			reader.close();
		} catch (FileNotFoundException e1) {
		} catch (IOException e) {
		}
		return result;
	}

	@Override
	public void execute(Pixmap target) {
		displayHistory();
		frame.setLayout(new BorderLayout());
		frame.getContentPane().add(pane, BorderLayout.CENTER);
		frame.getContentPane().add(btnGet, BorderLayout.SOUTH);
		frame.setSize(450, 400);
		frame.setVisible(true);
	}

}
