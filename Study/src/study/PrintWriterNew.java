package study;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterNew {
	
	static int a;
	
	public static void main(String[] args) throws IOException {
	//	PrintWriter pw2 = new PrintWriter(System.out);
	
		PrintWriter pw = new PrintWriter(new File("output.txt"));
		pw.println("test");
		pw.close();
		System.err.println("bug");
	
	}

	}

