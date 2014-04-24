/*Kevin Noonan
 * CSC 300 - 501
 * 1/29/14
 * MyFibonacci
 * Optimizes the recusive fib algorithm solving and storing answers within an array
 * */
import java.util.Scanner;


public class MyFibonacci {
	//prompts the user for step of the Fibonacci sequence that the user wants and prints the answer
	public static final int MAX = 100;
    public static int[] A = new int[MAX];

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Which step of the Fibonacci Sequence would you like? ");
		int n = in.nextInt();
		A[0] = 1;
		A[1] = 1;
		System.out.println(rfib(n-1));
		
	}
	public static int rfib(int n){
		if (A[n] == 0){//If A[n] is 0 the program doesn't have a value stored so it needs to find it
			A[n] = rfib(n-1) + rfib(n-2);
			return A[n];}
		else return A[n];//if there isn't a 0 the program has a value and returns it 
		}
		
	}


