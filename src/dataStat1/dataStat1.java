package dataStat;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class dataStat {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner reader1 = new Scanner(new FileReader("ages.txt"));
		BufferedReader reader2 = new BufferedReader(new FileReader("ages.txt"));
		int[] buffer;
		int lines = 0; 
		int arrInd = 0; 
		int arrSum = 0; 
		int arrMean = 0; 
		
		while (reader2.readLine()!=null) lines++;
		reader2.close();
		buffer = new int[lines];
		
		
		while (reader1.hasNextInt()) {
			buffer[arrInd]=reader1.nextInt();
			arrInd++;
		}
		reader1.close();
		//number of lines in text file ages
		System.out.println("ages.txt contains "+lines+" lines");
		//list of ages into array 
		System.out.println("Array Buffer: "+Arrays.toString(buffer));
		
		for (int i=0;i<buffer.length;i++) {
			arrSum += buffer[i];
		}
		arrMean = arrSum / buffer.length; 
		//array sum and array median 
		System.out.println("Array sum: "+arrSum+".");
		System.out.println("Array mean: "+arrMean+".");
		
		int []repAges = new int[lines];
		int counter = 0; 
		for (int i=0; i<buffer.length; i++) { 
			for (int j=i+1; j<buffer.length; j++) {
				if (buffer[i] == buffer[j]) {
					//System.out.println(buffer[i]);
					repAges[counter] = buffer[i];
					counter++; 
				}
			}
		}
		//duplicate ages in the text file 
		System.out.println("Duplicate Values in Array Buffer: " +Arrays.toString(repAges));
	
		int median; 
		if (buffer.length%2 ==1) {
			median = buffer[(buffer.length-1)/2]; 
		} else {
			median = (buffer[buffer.length/2]+buffer[(buffer.length/2)-1])/2;
		}
		System.out.println("Median Value: "+median+".");
		
		
		//variables to store upper and lower quartiles
		int lowQuart,uppQuart;
		//new arrays to calculate to find upper and lower quartiles from original array 
		int[] lowArr = new int[buffer.length/2];
		int[] uppArr = new int[buffer.length/2];
		
		//making lowerbound array to calculate lower quartile 
		for(int i=0; i<((buffer.length/2)); i++) {
			lowArr[i] = buffer[i];
		}
		//System.out.println(Arrays.toString(lowArr));
		
		//making upperbound array to calculate upper quartile 
		counter = 0; 
		for(int j=buffer.length/2; j<buffer.length; j++) {
			uppArr[counter] = buffer[j];
			counter++; 
		}
		//System.out.println(Arrays.toString(uppArr));
		
		//calculate lower quartile
		if (lowArr.length%2==1) {
			lowQuart = lowArr[(lowArr.length-1)/2];
		} else {
			lowQuart = (lowArr[lowArr.length/2] + lowArr[lowArr.length/2-1])/2;
		}
		System.out.println("Lower Quartile: " +lowQuart+".");
		
		//calculate upper quartile 
		if (uppArr.length%2==1) {
			uppQuart = uppArr[(uppArr.length-1)/2];
		} else {
			uppQuart = (uppArr[uppArr.length/2] + uppArr[uppArr.length/2-1])/2;
		}
		System.out.println("Upper Quartile: " +uppQuart+".");

	}

}