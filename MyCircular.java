/*Kevin Noonan
 * CSC 300 - 501
 * 1/29/14
 * MrCircular
 * When given 2 strings the program will print out whether they are circular rotations of each other
 * */
public class MyCircular {

	public static void main(String[] args) {
		String s = "ACTGACG";
		String t = "GACZ";
		
		String q = s+s;
		
		if (q.indexOf(t) >= 0 && s.length() == t.length()){
			System.out.println("'"+t+"' is a circular rotation of '"+s+"' starting at position " + q.indexOf(t));
		}
		else System.out.println("'"+t+"' is not a circular rotation of '"+s+"'");

	}

}
