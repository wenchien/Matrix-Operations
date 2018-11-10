import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/* Algorithm from: The Science of Programming Matrix Computations
 * Chapter 2: Derivation of Linear Algebra, Alpha Plus Dot Product (APDOT)
 * 
 * Description: Accepts two vectors with dimensions of 1xn or nx1 and
 * 				calculates the dot product without the traditional usage
 * 				of indices. Instead it uses slicing and dicing technique
 * 				See figure 2.1 of the book for more detailed implementation
 */

class MatrixOperation {
	private Queue<Integer> xTopElements;
	private Queue<Integer> xBottomElements;
	private Queue<Integer> yTopElements;
	private Queue<Integer> yBottomElements;
	
	public MatrixOperation () {
		xTopElements = new PriorityQueue<Integer>();
		xBottomElements = new PriorityQueue<Integer>();
		yTopElements = new PriorityQueue<Integer>();
		yBottomElements = new PriorityQueue<Integer>();
	}
	
	/* Iterative method
	 * Assuming x and y vector are 1xn or nx1
	 */
	public int apdot(int[] x, int[] y, int alpha) {
		/* Initial partitioning
		 * partition x -> (xT | xB) and y -> (yT | yB)
		 * where xT and yT and have 0 elements
		 * because we just initialize the ArrayList for xT, xB, yT, and yB 
		 * they are already 0.
		 * We also need to put everything from vectors x and y to xB and yB first
		 */
		populateBottoms(x, y);
		while (xTopElements.size() < x.length) {
			/* we need to repartition here
			 * we'll pop the stack and add that to the xT and yT queue
			 */
			int chi_1 = xBottomElements.poll();
			int psi_1 = yBottomElements.poll();
			
			/* Update alpha value with the following
			 * alpha := chi1 * psi1 + alpha
			 */
			alpha = (chi_1 * psi_1) + alpha;
			
			/* Continue with moving the 
			 * bar to one below of chi1 and psi1
			 * 
			 */
			xTopElements.add(chi_1);
			yTopElements.add(psi_1);
		}
		return alpha;
	}
	
	/*
	 * This function will only be called   
	 * apdot() function
	 */
	private void populateBottoms(int[] x, int[] y) {
		for (int i = 0; i < x.length; i++) {
			xBottomElements.add(x[i]);
			yBottomElements.add(y[i]);
		}
	}
}

public class SlicingDicingAPDOT {
	static Scanner scan = new Scanner(System.in);
	static MatrixOperation mo;
	public static void main(String[] args) {
		System.out.println("Enter length of vector x and y: ");
		int array_length = scan.nextInt();
		
		int[] x = new int[array_length];
		int[] y = new int[array_length];
		
		for (int i = 0; i < x.length; i++) {
			System.out.println("Enter elements for vector x: ");
			x[i] = scan.nextInt();
		}
		
		for (int i = 0; i < x.length; i++) {
			System.out.println("Enter elements for vector y: ");
			y[i] = scan.nextInt();
		}
		
		mo = new MatrixOperation();
		System.out.println("Dot Product of the vectors x and y is: " + mo.apdot(x, y, 0));
	}
}
