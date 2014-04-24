/**
 * Description of DelimPos class object: The object stores a character 
 * 		and a line number in the constructor. Also supports methods for 
 * 		returning the line number, the delimiter and the corresponding closing
 * 		delimiter.
 * 
 * @author Kevin Noonan
 * Class CSC-300-501
 * */
public class DelimPos {
	private int line;
	private char delim;
	
	//Constructor - sets the private memebers of the class 
	public DelimPos(char c, int l){
		line = l;
		delim = c;
	}
	
	//@returns the line number of the DelimPos object
	public int getLine(){
		return (int)line;
	}
	
	//@returns the character of the DelimPos object
	public char getDelim(){
		return (char)delim;
	}
	
	/*determines the closing corresponding charcter
	* @returns the opposite character 
	*/
	public char getOpp(){
		if (delim == '(') return ')';
		else if (delim == '{') return '}';
		else return ']';
	}
	
	
}
