/**
 * Description of BalancedApp class: The program asks for a file name. It then reads the 
 * 		file character by charcter and looks for a (, { or [ and checks
 * 		that each one has the corresponding closer: ), }, and ]. If the
 * 		file is closed the program will print out that it's balanced. If not,
 * 		it will print out that there was an error.
 * 
 * Uses: DelimPos class
 * 
 * @author: Kevin Noonan
 * Class CSC-300-501
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class BalancedApp {
	public static void main(String[] args) {
		// Get the File name
		 Scanner stdin = new Scanner(System.in);
		 System.out.print("Please enter a filename: "); 
		 String fname = stdin.next();
		// scan in the strings
		Scanner in = null;
		try {// try to open the filename given
			in = new Scanner(new File(fname));
		} catch (FileNotFoundException e) {
			System.err.printf("Cannot open '%s' for input\n", fname);
			System.exit(0);
		}
		in.useDelimiter("");// will allow .next() to open for everything

		Stack<DelimPos> stk = new Stack<DelimPos>();
		int line = 1;
		System.out.print(line + ". ");// print the first line
		while (in.hasNext()) {// loop through grabing every char in the file
			String content = in.next();
			char ch = content.charAt(0);// grab each charcter

			if (ch == '(' || ch == '{' || ch == '[') {// program finds an open delimiter
			stk.push(new DelimPos(ch, line));
			}
			// check if it matched with the most recent element of the stack

			if (ch == ')' || ch == '}' || ch == ']') {
				if (stk.isEmpty()) {//doesn't have an opener to match
					System.out.printf("\nError: Line %d.", line);
					System.out
							.printf("Closing character'%c', with no matching opening character.",
									ch);
					System.exit(0);
				} else if (ch == (stk.peek().getOpp())) {//found a closing char that matches up, pop off the opener
					stk.pop();
				} else {//mismatch
					System.out.printf("\nError: Line %d. ", line);
					System.out.printf("'%c'", ch);
					System.out.printf(
							"is the wrong closing symbol for char = '%c'", stk
									.peek().getDelim());
					System.out.printf(", line %d", stk.peek().getLine());

					System.exit(0);
				}
			}
			if (ch == '\n') {// keep track of the line number & print out the lines in a meaningful manner
				line+=1;
				System.out.println("");
				System.out.print(line + ". ");
			} else {//print the character
				System.out.print(ch);
			}
		}
		//reached the end of the file
		if (!(stk.isEmpty())) {//check if there's anything left in the stack
			System.out
					.printf("\nError: At end of file, no closing symbol found for char = '%c'",
							stk.peek().getDelim());
			System.out.printf("line %d", stk.peek().getLine());
		}
		else System.out.println("\nInput is balanced.");
	}
}
