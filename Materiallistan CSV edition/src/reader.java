import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/*	
 * 
 * 	Materiallista csv edition ,csv läsning
 * 
 * 	@author Author Alrik
 *	@date 2021-09-17
 *  
 */


public class reader {

	public static void main(String[] args) {
		ArrayList<String> lista= new ArrayList<String>(); 
		String path="src/Materiallista.csv";
		String line = "";
		String[][] arry = new String[11][3] ;
		int i=0;
		 
		try {
			BufferedReader br = new BufferedReader( new FileReader(path));
			
		

			/*  ---- do while loop för att lägga in datan  ----
			 *
			 * do {
				line = br.readLine();	
				if(line!=null)lista.addAll( Arrays.asList( line.split(",")) );
				}while(line!=null); 
		
		
				//lista.remove(0);  // om man la in allt så finns det tomt på sist indexen
				//System.out.println( lista );
			 */
			 
	/*------------------------------- Lite mer optimiserad lösning -------------------------------*/
			
			while(line!=null){		
				line = br.readLine(); 		 // (får null på slutet.)
				if(line!=null) {
					arry[i]= line.split(",");
					if(1<i && i<12) { 		 // från rad 2 börjar datan
						int val1 =  Integer.parseInt((arry[i][1].split("([\s]+)"))[0]);
						int val2 = 	Integer.parseInt((arry[i][1].split("[x\\)]"))[1]);				
						arry[i][2]=String.valueOf(val1*val2);
					}
					i++;
				}
			}
			
			
			/*------------------------------- Char index lösning -------------------------------*/

			/*for(int j=2 ; j<11 ; j++ ) {
				int val1 =  Integer.parseInt((arry[j][1].split("([\s]+)"))[0]);
				int val2 = 	Integer.parseInt((arry[j][1].split("[x\\)]"))[1]);				
			
				//int b=(int)arry[j][1].indexOf('x'),e = (int)arry[j][1].indexOf(')'); 	// char index metod, sämre lösning
				//int val2= Integer.parseInt(arry[j][1].substring(b+1, e)) ;
				
				arry[j][2]=String.valueOf(val1*val2);
			}*/
			
			
			//printa ut allt med Arrays från util.array
			for( String [] s:arry) 
				System.out.println(Arrays.toString(s));
				
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			catch (IOException e) {
				e.printStackTrace();
			}

	}

}
