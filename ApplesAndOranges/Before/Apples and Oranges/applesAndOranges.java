import java.util.Scanner;
import java.lang.Math;     // Note: Needed for math functions

public class MadeFromScratch {
   public static void main(String[] args) {
   		Scanner scnr = new Scanner(System.in);
   		// initialize varibales
      	int numApplesInStock = 0;
      	int numApplesNeededStock = 0;
      	int numOrangesInStock = 0;
      	int numOrangesNeededStock = 0;
        int applesToOrder = 0;
        int orangesToOrder = 0;
      	
      	// OBTAIN apples in stock
      	System.out.println("How many apples are in stock?: ");
      	numApplesInStock = scnr.nextInt();
      	// OBTAIN apples needed in stock
      	System.out.println("How many apples should be in stock?: ");
      	numApplesNeededStock = scnr.nextInt();
      	// OBTAIN oranges in stock
      	System.out.println("How many oranges are in stock?: ");
      	numOrangesInStock = scnr.nextInt();
      	// OBTAIN oranges needed in stock
      	System.out.println("How many oranges should be in stock?: ");
      	numOrangesNeededStock = scnr.nextInt();
        
        // CALCULATE apples to order  
      	applesToOrder = numApplesNeededStock - numApplesInStock;
      	// CALCULATE apples to order 
      	orangesToOrder = numOrangesNeededStock - numOrangesInStock;

      	// PRINT apples and oranges to be ordered (to fulfill need)
      	System.out.println(applesToOrder + " apples and " + orangesToOrder + " oranges need to be ordered.");


      return;
   }
}