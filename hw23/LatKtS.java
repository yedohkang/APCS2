// Yedoh Kang
// APCS2 pd1
// HW23 -- Stack: What is it Good For?
// 2017-03-24

/*****************************************************
 * class LatKtS (LatKeysToSuccess)
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS 
{

    /**********************************************************
     * precondition:  input string has length > 0
     * postcondition: returns reversed string s
     *                flip("desserts") -> "stressed"
     **********************************************************/
    public static String flip( String s ) 
    {
	String retStr = "";
	Latkes word = new Latkes(s.length());
	for (int i = 0; i < s.length(); i++) {
	    word.push(s.substring(i,i+1));
	}
	while (!word.isEmpty()) {
	    retStr += word.pop();
	}
	return retStr;
    }//end flip()


    /**********************************************************
     * precondition:  s contains only the characters {,},(,),[,]
     * postcondition: allMatched( "({}[()])" )    -> true
     *                allMatched( "([)]" )        -> false
     *                allMatched( "" )            -> true
     **********************************************************/
    public static boolean allMatched( String s ) 
    {
	if(s.length() % 2 != 0){
	    return false;
	}
	Latkes temp = new Latkes(s.length());
	for(int x = 0; x < s.length(); x ++){
	    String current = s.substring(x, x + 1);
	    if(current.equals("{") ||
	       current.equals("[") ||
	       current.equals("("))
		temp.push(current);
	    else{
		String match = temp.pop();
		if((current.equals("}") && (! match.equals("{")))||
		   (current.equals(")") && (! match.equals("(")))||
		   (current.equals("]") && (! match.equals("[")))){
		    return false;
		}
	    }
	}
	return true;
		
    }//end allMatched()

    //main method to test
    public static void main( String[] args ) { 


	System.out.println(flip("stressed"));

	System.out.println(allMatched( "({}[()])" )); //true
	System.out.println(allMatched( "([)]" ) ); //false
	System.out.println(allMatched( "(){([])}" ) ); //true
	System.out.println(allMatched( "](){([])}" ) ); //false
	System.out.println(allMatched( "(){([])}(" ) ); //false
	System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
	/*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
          ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
    }

}//end class LatKtS
