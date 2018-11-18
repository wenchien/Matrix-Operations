package Matrix;

import Matrix.Exceptions.ElementNotFoundException;
import Matrix.Exceptions.VectorElementOutOfBoundException;

public class Vector {
	private double[] array;
	private int size;
	private int currPtr;
	
	/**
	 * Vector(double[] obj) as format. Use this when you have a populated array (non-null)
	 * @param obj Any double array
	 */
	public Vector(double[] obj) {
		this.size = obj.length;
		this.array = obj;
		this.currPtr = size;
	}
	
	/**
	 * Vector(int n) as format. Use this when you want to create a Vector obj
	 * without any input Object array
	 * @param n The desired size for the Vector
	 */
	public Vector(int n) {
		this.size = n;
		array = new double[n];
		currPtr = 0;
	}
	
	public void addElement(double n) {
		if (currPtr == size) throw new VectorElementOutOfBoundException("You cannot add any elements anymore");
		else array[currPtr] = n; currPtr++;
	}
	
	public double getElementAt(int i) {
		if (array == null) throw new ElementNotFoundException("Array is empty");
		if (i >= size) throw new VectorElementOutOfBoundException("You cannot access any elements out of the size: " + this.size);
		else return array[i];
	}
	
	public int getSize() {
		if (array == null) throw new ElementNotFoundException("Array is empty");
		return size;
	}
	
	public void changeElementAt(int i, double num) {
		if (i >= size) throw new VectorElementOutOfBoundException();
		else array[i] = num;
	}
	
	/**
	 * This function prints out your vector with specified format
	 * @param constant Takes an integer type, either 1 or 2
	 */
	public void printInFormat(int constant) {
		switch(constant) {
			/*prints horizontal*/
			case 1 : for (int i = 0; i < this.size; i++) {
				if (i == 0) {
					System.out.print("[ ");
				}
				System.out.print(this.getElementAt(i) + " ");
				if (i == (this.size - 1)) {
					System.out.print("]\n");
				}
			}
			break;
			/*prints vertical*/
			case 2 : for (int i = 0; i < this.size; i++) {
				if (i == 0) {
					System.out.println("[ ");
				}
				
				System.out.println(this.getElementAt(i) + " ");
				
				if (i == (this.size - 1)) {
					System.out.println("]");
				}
			}
			break;

			default : 
				break;
		}
	}
}
