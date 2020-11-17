package picasso.parser.language;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles reading the available built-in special tokens (like string, identifier, color,...) from a file.
 * 
 * @author Abdelrahman AboEitta
 *
 */
public class BuiltinSpecialTokenReader {

	private static List<String> tokensList;
	private static String TOKENS_CONF_FILE = "conf/specialTokens.conf";

	/**
	 * Get the list of built-in token names
	 * 
	 * @return the list of built-in token names
	 */
	public static List<String> getTokensList() {
		if (tokensList == null) {
			readTokensFromFile();
		}
		return tokensList;
	}

	/**
	 * Read the tokens from the specialTokens config file
	 */
	private static void readTokensFromFile() {
		tokensList = new ArrayList<String>();
		Scanner reader;
		try {
			reader = new Scanner(new File(TOKENS_CONF_FILE));
		} catch (FileNotFoundException e1) {
			System.out.println("specialTokens.conf File not found");
			e1.printStackTrace();
			return;
		}
		while (reader.hasNextLine()) {
			String token = reader.nextLine();
			token = token.trim();
			tokensList.add(token);
		}
	}


}
