import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.FileOutputStream;

public class Main {
	
	public static void main(String[] args) {
		
		try {
			FileInputStream inputStream = new FileInputStream("input.txt");	
			char[] byteArray = new char[inputStream.available()];
			String word = new String();
			ArrayList<String> wordArray = new ArrayList<String>();

			//Reading Text file and add into character array
			for(int j = 0; j < byteArray.length;j++)
			{
				char byteInput = (char) inputStream.read();
				byteArray[j] = byteInput;
			}
			
			
			//Close input Stream
			inputStream.close();
			
			
			//Concat characters into strings and store into String ArrayList (wordArray)
			for(int k = 0; k < byteArray.length;k++)
			{	
				if(byteArray[k] ==' ' || byteArray[k]==',' || byteArray[k]=='\n' || byteArray[k] == '\r')
				{
					if(!(word.equals(""))){
						wordArray.add(word);
					}
					if (byteArray[k] == '\n') {
						wordArray.add('\n' + "");
					}
					word = "";
				}
				else
				{
					word = word.concat(byteArray[k]+"");
					if(k == (byteArray.length - 1) && !(word.equals("")))
					{
						wordArray.add(word);
					}
				}
			}
				

			
			//Declaring Output stream
			FileOutputStream outputStream = new FileOutputStream("output.txt");
			
			//DFA Class (implementation) 
			//Source: https://www.fbeedle.com/formallanguage/ch04.pdf
			DFA dfa = new DFA();
			for(int a=0; a < wordArray.size(); a++) {
				dfa.resetState();
				int result = dfa.processToken(wordArray.get(a));
				System.out.print(dfa.resultString(result));  //display result in console
				byte[] b = (dfa.resultString(result)).getBytes();
				outputStream.write(b); //write to text file
			}
			
			//close output Stream
			outputStream.close();
		}
		catch (Exception e){
			e.getStackTrace();
		}
	}

}

