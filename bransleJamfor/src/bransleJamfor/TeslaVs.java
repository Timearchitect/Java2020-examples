package bransleJamfor;
import java.util.*;

/* 
 *  Ondsdagen matte avrundning
 *  2021-09-08 
 * 
 * 
 * Tesla
 * 15.3 kWh
 * 1.71 l/100 km
 * 7 (CO2, g/km)
 * 
 * Audi
 * 4.9 l/100 km
 * 114 (CO2,g/km)
 * 
 * BMW
 * 4.8 (l/100 km) 
 * 112  (CO2,g/km)
 * 
 * Peugeot
 * 3.8 (l/100 km) 
 * 88 (CO2,g/km)
 * 
 */

public class TeslaVs {

	public static void main(String[] args) {
		System.out.println("Tesla Vs cars:");
		ArrayList<Bil> bilar = new ArrayList<Bil>(); 
		
		// inputInfo= scan.nextLine();		
		bilar.add(  new Bil("Tesla",(float)1.71, (float)7.0 ) );
		bilar.add(  new Bil("Audi",(float)4.9, (float)114 ) );
		bilar.add(  new Bil("BMW",(float)4.8, (float)112 ) );
		bilar.add(  new Bil("Peugeot",(float)3.8, (float)88 ) );

		
		/*
		 *  Ok lösning 
		 *  
		int skipIndexes=-1;
		for ( int i = 0 ; i< bilar.size(); i++) {
			skipIndexes++;
			for (Bil b: bilar) {
				if(skipIndexes < bilar.indexOf(b) && bilar.get(i) != b) {
					System.out.println(bilar.get(i).getName()+" vs "+ b.getName());
				}
			}
		}
		*/

		for ( int i = 0 ; i< bilar.size(); i++) {
			for (int j = i+1 ; j< bilar.size() ; j++ ) {
					System.out.print(bilar.get(i).getName()+" vs "+ bilar.get(j).getName() +" ");
					System.out.println(compareAndReturnPercent1(
							bilar.get(i).getFuelConsumption() 
							, bilar.get(j).getFuelConsumption())+"%");

			}
		}
		
		
		
	}

	// intressant string lösning
	public static double compareAndReturnPercent(float x,float y) {
		double percent=0;
		String foo = String.valueOf(x/y*100)+"00"; 
		int dotIndex = foo.indexOf('.');
		System.out.println( foo.substring(0, dotIndex+3) );
		return percent;
	}
	
	// för printning
	public static String compareAndReturnPercent1(float x,float y) {
		String percent = String.format("%.2f",(double)(x/y)*100); 
		return percent;
	}
	
	// för körning
	public static double compareAndReturnPercent2(float x,float y) {
		double percent = Math.round(x/y*10000.00)/100.00 ;
		return percent;
	}
}
