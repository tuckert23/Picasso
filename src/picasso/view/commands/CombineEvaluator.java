package picasso.view.commands;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import picasso.model.Pixmap;
import picasso.util.Command;
import picasso.parser.ExpressionTreeGenerator;
import picasso.parser.language.ExpressionTreeNode;

/**
 * Allows the user to combine two expressions stored in history, and evaluates the result.
 * An initial implementation -- lots of refactoring can be done.
 * 
 * @author August Donovan
 */

public class CombineEvaluator implements Command<Pixmap> {
	
	private int id1;
	private int id2;
	private String input1;
	private String input2;
	private final String[] OPERATIONS = {" + ", " - ", " / ", " % ", " * "}; 
	private ExpressionTreeNode node;
	private Random rand = new Random();
	public static final double DOMAIN_MIN = -1;
	public static final double DOMAIN_MAX = 1;
	
	HistoryWriter hist = new HistoryWriter();
	
	private void getIDs() {
		//Helper function to get requested IDs from user
		
		JOptionPane.showMessageDialog(null, "Combine two functions from history using their function IDs", "Combine from History", JOptionPane.INFORMATION_MESSAGE);
		
		//get first input
		input1 = JOptionPane.showInputDialog(null, "Enter first function ID", "Combine from History", JOptionPane.QUESTION_MESSAGE);
		try {
			id1 = Integer.parseInt(input1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid function ID from history", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
		
		//get second input
		input2 = JOptionPane.showInputDialog(null, "Enter second function ID", "Combine from History", JOptionPane.QUESTION_MESSAGE);
		try {
			id2 = Integer.parseInt(input1);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Invalid function ID from history", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
		
		JOptionPane.showMessageDialog(null, "Combining your functions . . .", "Combine from History", JOptionPane.INFORMATION_MESSAGE);
		
		// swap to ints
		id1 = Integer.parseInt(input1);
		id2 = Integer.parseInt(input2);
	}
	
	public String getExpression(int id) {
		// Helper function to get specified IDs from history file
		String defaultFileName = "expressions/history.exp";
		String expression = "";
		BufferedReader reader;
		int i = 1;
		
		try {
			reader = new BufferedReader(new FileReader(hist.defaultFileName));
			while (i <= id) {
				expression = reader.readLine();
				i++;
			}
			reader.close();
			//clean up the line from file
			String slicedExpression[] = expression.split(": ");
			expression = slicedExpression[1];
		}
		
		catch (FileNotFoundException e0) {
			
		}
		catch (IOException e1) {
			
		}
		
		catch (Exception e2) {
			JOptionPane.showMessageDialog(null, "Invalid function ID from history", "ERROR!", JOptionPane.ERROR_MESSAGE);
		}
		
		return expression;
	}

	private double imageToDomainScale(int value, int bounds) {
		double range = DOMAIN_MAX - DOMAIN_MIN;
		return ((double) value / bounds) * range + DOMAIN_MIN;
	}
	
	public void execute(Pixmap target) {
		// combines the functions in an interesting way
		
		
		String exp1;
		String exp2;
		int randIndex = rand.nextInt(OPERATIONS.length);
		String randOperator = OPERATIONS[randIndex];
		
		getIDs();
		
		exp1 = getExpression(id1);
		exp2 = getExpression(id2);
		String combinedExpression = "(" + exp1 + ")" + randOperator + "(" + exp2 + ")";
		
		Dimension size = target.getSize();
		
		System.out.println(exp1);
		System.out.println(exp2);
		System.out.println(combinedExpression);
		
		ExpressionTreeGenerator expTreeGen = new ExpressionTreeGenerator();
		node = expTreeGen.makeExpression(combinedExpression);
		
		for (int imageY = 0; imageY < size.height; imageY++) {
			
			double evalY = imageToDomainScale(imageY, size.height);
			
			for (int imageX = 0; imageX < size.width; imageX++) {
					double evalX = imageToDomainScale(imageX, size.width);
					Color pixelColor = node.evaluate(evalX, evalY).toJavaColor();
					target.setColor(imageX, imageY, pixelColor);
		     		}
			}
	}
}