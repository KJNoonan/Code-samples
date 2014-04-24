import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Kevin Noonan
 * Gets the filename from the user and opens the file. Then creates 
 * Djia objects and puts them in the MinPQ. Finally prints the 5 worst
 * Djia found in the file
 * */
public class DjiaApp {
	public static void greetings(){
		System.out.println("This program finds the N lowest closing averages in a");
		System.out.print("file of Dow Jones Industrial Average closing records.\n\n\n");
	}
	public static void main(String[] args) {
		greetings();
		//get the filename from the user
		Scanner nscn = new Scanner(System.in);
		System.out.print("N: ");
		int n = nscn.nextInt();
		System.out.print("Enter the filename to be scanned: ");
		String fname = nscn.next();
		nscn.close();
		
		//opens the file if it exists otherwise it prints the error message and kills the program
		Scanner in = null;
		try {
			in = new Scanner(new File(fname));
		} catch(FileNotFoundException e) {
			System.err.printf("Cannot open '%s' for input\n", fname);
			System.exit(0);
		}
		
		 MinPQ<Djia> pq = new MinPQ<Djia>();
		//Begin creating Djia objects and inserting into the MinPQ
		 while(in.hasNext()){
			Djia var = new Djia(in.next(), in.nextDouble(), in.nextDouble());
			pq.insert(var);
		}
		//safeguard against N's larger then the items in the file
		if(n > pq.size()){
		n = pq.size();
		}
		 //print the five worst averages from the file
		 System.out.println("Found "+pq.size()+" Dowe Jones Industrial Averages");
		 System.out.printf("    %11S %11S %11S\n", "Date", "Opening", "Closing");
		 for (int i=1; i < n+1; i++){
			System.out.print(i + ".  ");
			System.out.println(pq.deleteMin());
		}
		
		
	}
}
