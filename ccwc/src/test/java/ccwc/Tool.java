package ccwc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Tool {
	
	
	public int getBytes(String filePath) throws FileNotFoundException, IOException {
		File file = this.validateFile(filePath);
		int bytes = 0;
		//try-with-resources (auto-close). similar to with file("file","r") as fp in Python)
		try(FileInputStream reader = new FileInputStream(file)) {
			//bufferedReader is bound to get characters. for this functionality, let's get the byte content.
			int nextByte = reader.read(); //brings the unicode representation of the character.
			while (nextByte != -1) {
				bytes += nextByte;
				nextByte = reader.read();
			}
		}
		return bytes;
	}
	
	public int getBytes() {
		//method overload, supporting read from stdin
		Scanner sc = new Scanner(System.in);
		int bytes = 0;
		while (sc.hasNext()) {
			//convert the token in the input to char and get its byte representation.
			String token = sc.next();
			for (byte b : token.getBytes()) {
				bytes += b;
			}
			
		}
		sc.close();
		return bytes;
	}
	
	private File validateFile(String filePath) throws FileNotFoundException, IOException {
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException("File does not exist");
		}
		return file;
	}
	
	public int getLines(String filePath) throws FileNotFoundException, IOException {
		File file = this.validateFile(filePath);
		int lines = 0;
		//try-with-resources (auto-close). similar to with file("file","r") as fp in Python)
		try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
			String line = reader.readLine();
			while (line != null) {
				lines++;
				line = reader.readLine();
			}
		}
		return lines;
	}
	
	public int getLines() throws FileNotFoundException, IOException {
		int lines = 0;
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()){
			if (sc.next().equals('\n')) {
				//EOL
				lines++;
			}
		}
		return lines;
	}
	
	private int countWhitespaces (String s) {
		int whitespaces = 0;
		for(char c : s.toCharArray()) {
			if (c == ' ') {
				whitespaces++;
			}
		}
		return whitespaces;
	}
	
	public int getWords(String filePath) throws FileNotFoundException, IOException {
		File file = this.validateFile(filePath);
		int words = 0;
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line = reader.readLine();
			while(line != null) {
				String[] lineProc = line.split("\\s");
				//whitespaces shouldn't count as words. And other characters, too.
				//neither empty lines.
				for (String word : lineProc) {
					if (!word.equals("")) { //pretty sure this can be solved through regex
						words += 1;
					}
				}
				line = reader.readLine();
			}
		}
		return words;
	}
	
	public int getWords() throws FileNotFoundException, IOException {
		int words = 0;
		try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = reader.readLine();
			while (line != null) {
				String[] lineProc = line.split("\\s");
				for (String word : lineProc) {
					if (!word.equals("")) {
						words += 1;
					}
				}
				line = reader.readLine();
			}
		}
		return words;
	}
	
	public int getChars(String filePath) throws FileNotFoundException, IOException {
		File file = this.validateFile(filePath);
		int chars = 0;
		try(BufferedReader reader = new BufferedReader(new FileReader(file))){
			String line = reader.readLine();
			while(line != null) {
				String[] procLine = line.split("\\s");
				for (String word : procLine) {
					chars += word.length();
				}
				line = reader.readLine();
			}
		}
		return chars;
	}
	
	public int getChars() throws FileNotFoundException, IOException {
		int chars = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String line = reader.readLine();
			while(line != null) {
				String[] procLine = line.split("\\s");
				for (String word : procLine) {
					chars += word.length();
				}
				line = reader.readLine();
			}
		}
		return chars;
	}

}
