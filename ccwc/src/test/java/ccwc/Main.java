package ccwc;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		Tool t = new Tool();
		
		//this will look better as a switch case statement.
		if (args[0].endsWith(".txt")) {
			//file name has been supplied:

			if (args.length == 1) {
				//only the file name has been supplied:
				try {
					int bytes = t.getBytes(args[0]);
					int lines = t.getLines(args[0]);
					int words = t.getWords(args[0]);
					int chars = t.getChars(args[0]);
					System.out.println(bytes + " " + lines + " " + words + " " + chars + " " + 
							args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}	
			if (args[1].equals("-c")){
				try {
					System.out.println(t.getBytes(args[0]) + " " + args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}
			if (args[1].equals("-l")) {
				try {
					System.out.println(t.getLines(args[0]) + " " + args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}
			if (args[1].equals("-w")) {
				try {
					System.out.println(t.getWords(args[0]) + " " + args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}
			if(args[1].equals("-m")) {
				try {
					System.out.println(t.getChars(args[0]) + " " + args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}
		}
		else {
			//file name has not been supplied. read from stdin
			if (args.length == 0) {
				//no args have been supplied:
				try {
					int bytes = t.getBytes();
					int lines = t.getLines();
					int words = t.getWords();
					int chars = t.getChars();
					System.out.println(bytes + " " + lines + " " + words + " " + chars + " " + 
							args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
				
			}
			if (args[1].equals("-c")){
				System.out.println(t.getBytes() + " " + args[0]);
			}
			if (args[1].equals("-l")) {
				try {
					System.out.println(t.getLines() + " " + args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}
			if (args[1].equals("-w")) {
				try {
					System.out.println(t.getWords() + " " + args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}
			if(args[1].equals("-m")) {
				try {
					System.out.println(t.getChars() + " " + args[0]);
				}
				catch (IOException e) {
					System.err.println("Error in reading file");
				}
			}
			
		}
	}
		
}
