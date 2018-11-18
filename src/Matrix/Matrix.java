package Matrix;

import Matrix.Exceptions.ElementNotFoundException;
import Matrix.Exceptions.VectorElementOutOfBoundException;

public class Matrix {
	private double[][] array;
	private int currPtr;
	private int currRow;
	private int row_size;
	private int col_size;

	/**
	 * Use this when you have a populated array (non-null)
	 * @param obj
	 */
	public Matrix(double[][] obj) {
		this.array = obj;
		this.row_size = obj.length;
		this.col_size = obj[0].length;
		this.currPtr = this.row_size * this.col_size;
		this.currRow = this.row_size;
	}

	/**
	 * Use this when you want to create a Matrix obj
	 * without any input array
	 * @param x The desired size for row
	 * @param y The desired size for column
	 */
	public Matrix(int x, int y) {
		this.array = new double[x][y];
		this.row_size = x;
		this.col_size = y;
		this.currPtr = 0;
		this.currRow = 0;
	}

	public void addElement(double n) {
		if (currPtr >= col_size && !(currRow > row_size)) {
			currPtr = 0; 
			currRow++;
			array[currRow][currPtr] = n; 
			currPtr++; 
			//System.out.println("Inserted new row");
		}
		else if (currPtr >= col_size && currRow >= row_size) throw new VectorElementOutOfBoundException();
		else {
			array[currRow][currPtr] = n; 
			currPtr++; 
			//System.out.println("Just insert");
		}
	}

	public double getElementAt(int i, int j) {
		if (array == null) throw new ElementNotFoundException("Array is empty");
		if (i >= row_size) throw new VectorElementOutOfBoundException("You cannot access any elements out of the size: " + this.row_size);
		if (j >= col_size) throw new VectorElementOutOfBoundException("You cannot access any elements out of the size: " + this.col_size);
		else return array[i][j];
	}

	public int getRowSize() {
		if (array == null) throw new ElementNotFoundException("Array is empty");
		return row_size;
	}

	public int getColSize() {
		if (array == null) throw new ElementNotFoundException("Array is empty");
		return col_size;
	}

	public void changeElementAt(int i, int j, double num) {
		if (i >= row_size || j >= col_size) throw new VectorElementOutOfBoundException("You cannot access any elements out of the size: " + this.row_size
				+ " x " + this.col_size);
		else array[i][j] = num;
	}
	
	/**
	 * This function prints out your matrix
	 */
	public void printInFormat() {
		for (int i = 0; i < row_size; i++) {
			if (i == 0) {System.out.print("[ ");}
			else System.out.println("");
			for (int j = 0; j < col_size; j++) {
				if (j == col_size) {
					System.out.println("");
				}
				else 
					System.out.print(this.getElementAt(i, j) + " ");
			}
		}
		System.out.println("]" + "\n");
	}
}
