import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Console_To_File {
//	Implement console application that meets following requirements:
//	Implement console text editor
//	Program asks user to input text
//	Program writes all user input to file
//	When user writes ‘exit’ - program stops execution
//	When program is finished - content of the file is written to console

	private static final String EXIT_TEXT = "exit";
	private static File fileToWrite;
	
	public Console_To_File(File fileToWrite) {
		this.fileToWrite = fileToWrite;
	};
	
	private static void saveTextToFile(StringBuilder sb) {
		try {
			Files.write(fileToWrite.toPath(), sb.toString().getBytes(), StandardOpenOption.CREATE, 
					StandardOpenOption.TRUNCATE_EXISTING);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String [] args) {
		
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		while (true) {
			String inputText = sc.nextLine();
			if (inputText.equalsIgnoreCase(EXIT_TEXT)) {
				saveTextToFile(sb);
				return;
			}
			sb.append(inputText).append(System.lineSeparator());
		}
	}
}
