public class DFA {
	private static final int q0 = 0;
	private static final int q1 = 1;
	private static final int q2 = 2;
	private static final int q3 = 3;
	private static final int q4 = 4;
	private static final int q5 = 5;
	private static final int q6 = 6;
	private static final int q7 = 7;
	private static final int q8 = 8;
	private static final int q9 = 9;
	private static final int q10 = 10;
	private static final int q11 = 11;
	private static final int q12 = 12;
	private static final int q13 = 13;
	private static final int q14 = 14;
	private static final int q15 = 15;
	private static final int q16 = 16;
	private static final int q17 = 17;
	private static final int q18 = 18;
	private static final int q19 = 19;
	private static final int q20 = 20;
	private static final int q21 = 21;
	private static final int q22 = 22;
	private static final int q23 = 23;
	private static final int q24 = 24; //reject 
	private static final int q25 = 25; //delims
	
	private int state;
	
	static private int transition(int state, char c)
	{
		switch (state) {
			case q0: switch(c) {
				case 'D': return q1;
				case 'R': return q12;
				case '$': return q13;
				case 'F': return q14;
				case ' ':
				case ',':
				case '\r':
				case '\n': return q25;
				default: return q24;
			}
			case q1: switch(c) {
				case 'A': return q2;
				case 'M': return q3;
				default: return q24;
			}
			case q2: switch(c) {
				case 'D': return q4;
				default: return q24;
			}
			case q3: switch(c) {
				case 'U': return q7;
				default: return q24;
			}
			case q4: switch(c) {
				case 'D': return q5;
				default: return q24;
			}
			case q5: switch(c) {
				case 'I': return q6;
				case 'U': return q8;
				default: return q24;
			}
			case q6: switch(c) {
				case 'U': return q8;
				default: return q24;
			}
			case q7: switch(c) {
				case 'L': return q9;
				default: return q24;
			}
//			case q8: switch(c) {
//				case 'D': return q4;
//				default: return q24;
//			}
			case q9: switch(c) {
				case 'T': return q10;
				default: return q24;
			}
			case q10: switch(c) {
				case 'U': return q8;
				default: return q24; 
			}
			case q11: switch(c) {
				case '0': return q20;
				case '1': return q20;
				case '2': return q20;
				case '3': return q20;
				case '4': return q20;
				case '5': return q20;
				case '6': return q20;
				case '7': return q20;
				case '8': return q20;
				case '9': return q20;
				default: return q24;
			}
			case q12: switch(c) {
				case '0': return q17;
				case '1': return q11;
				case '2': return q11;
				case '3': return q18;
				case '4': return q17;
				case '5': return q17;
				case '6': return q17;
				case '7': return q17;
				case '8': return q17;
				case '9': return q17;
				default: return q24;
			}
			case q13: switch(c) {
				case '0': return q17;
				case '1': return q11;
				case '2': return q11;
				case '3': return q18;
				case '4': return q17;
				case '5': return q17;
				case '6': return q17;
				case '7': return q17;
				case '8': return q17;
				case '9': return q17;
				case 'F': return q14;
				default: return q24;
			}
			case q14: switch(c) {
				case '0': return q23;
				case '1': return q15;
				case '2': return q15;
				case '3': return q21;
				case '4': return q23;
				case '5': return q23;
				case '6': return q23;
				case '7': return q23;
				case '8': return q23;
				case '9': return q23;
				case 'F': return q23;
				default: return q24;
			}
			case q15: switch(c) {
				case '0': return q16;
				case '1': return q16;
				case '2': return q16;
				case '3': return q16;
				case '4': return q16;
				case '5': return q16;
				case '6': return q16;
				case '7': return q16;
				case '8': return q16;
				case '9': return q16;
				default: return q24;
			}
//			case q16: switch(c) {
//				case 'D': return q1;
//				case 'R': return q12;
//				case '$': return q13;
//				case 'F': return q14;
//				default: return q24;
//			}
//			case q17: switch(c) {
//				case 'D': return q1;
//				case 'R': return q12;
//				case '$': return q13;
//				case 'F': return q14;
//				default: return q24;
//			}
			case q18: switch(c) {
				case '0': return q19;
				case '1': return q19;
				default: return q24;
			}
//			case q19: switch(c) {
//				case 'A': return q2;
//				case 'M': return q3;
//				default: return q24;
//			}
//			case q20: switch(c) {
//				case 'D': return q4;
//				default: return q24;
//			}
			case q21: switch(c) {
				case '0': return q22;
				case '1': return q22;
				default: return q24;
			}
//			case q22: switch(c) {
//				case 'D': return q1;
//				case 'R': return q12;
//				case '$': return q13;
//				case 'F': return q14;
//				default: return q24;
//			}
//			case q23: switch(c) {
//				case 'D': return q1;
//				case 'R': return q12;
//				case '$': return q13;
//				case 'F': return q14;
//				default: return q24;
//			}
			default: return q24;
				
		}//end switch bracket
	}
	
	public void resetState() {
		state = q0;
	}
	
	public int processToken(String word) {
		for (int i=0; i < word.length(); i++)
		{
			char tokenChar = word.charAt(i);
			state = transition(state,tokenChar);
		}
		return state;
	}
	
	public String resultString(int state) {
		if(state == q8 || state == q10)
		{
			return "KEYWORD ";
		}
		else if (state == q11 || state == q17 || state == q18 || state == q19 || state == q20)
		{
			return "GPR ";
		}
		else if (state == q15 || state == q16 || state == q21 || state == q22 || state == q23)
		{
			return "FPR ";
		}
		else if (state == q25) //delims
		{
			return "\n";
		}
		else
			return "ERROR "; 
	}
}
