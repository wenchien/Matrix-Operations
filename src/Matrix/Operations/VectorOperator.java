package Matrix.Operations;

import java.util.PriorityQueue;
import java.util.Queue;
import Matrix.Vector;
import Matrix.Exceptions.DimensionNotMatchException;
import Matrix.Interfaces.MatrixVectorInerface;
public class VectorOperator implements MatrixVectorInerface{
	private Queue<Double> xTopElements;
	private Queue<Double> xBottomElements;
	private Queue<Double> yTopElements;
	private Queue<Double> yBottomElements;

	public VectorOperator() {
		xTopElements = new PriorityQueue<Double>();
		xBottomElements = new PriorityQueue<Double>();
		yTopElements = new PriorityQueue<Double>();
		yBottomElements = new PriorityQueue<Double>();
	}
	
	/**
	 * Accepts two vectors with dimensions of 1xn or nx1 and
	 * calculates the dot product without the traditional usage
	 * of indices. Instead it uses slicing and dicing technique
	 * See figure 2.1 of the book for more detailed implementation 
	 * @param x A Vector object representing the 1st vector
	 * @param y A Vector object representing the 2nd vector
	 * @param alpha A double variable representing alpha. If alpha is not present, enter 0
	 * @return a double value denoting the result of the operation
	 */
	public double apdotOperation(Vector x, Vector y, double alpha) {
		if (x.getSize() != y.getSize()) throw new DimensionNotMatchException("Dimension Not Match");
		if (xBottomElements != null || yBottomElements != null) {
			cleanUp();//in case something gone bad
		}
		populateBottoms(x, y);
		while (xTopElements.size() < x.getSize()) {
			double chi_1 = xBottomElements.poll();
			double psi_1 = yBottomElements.poll();
			alpha = (chi_1 * psi_1) + alpha;
			xTopElements.add(chi_1);
			yTopElements.add(psi_1);
		}
		return alpha;
	}
	
	/**
	 * The function takes in two Vectors and does the subtract operation
	 * on two vectors x - y 
	 * @param x First vector 
	 * @param y Second vector
	 * @return It returns result vector of x - y
	 */
	public Vector subtract(Vector x, Vector y) {
		Vector temp = new Vector(x.getSize());
		if (x.getSize() != y.getSize()) throw new DimensionNotMatchException("Dimension Not Match");
		for (int i = 0; i < x.getSize(); i++) {
			temp.addElement((x.getElementAt(i) - y.getElementAt(i)));
		}
		return temp;
	}
	
	public Vector add(Vector x, Vector y) {
		Vector temp = new Vector(x.getSize());
		if (x.getSize() != y.getSize()) throw new DimensionNotMatchException("Dimension Not Match");
		for (int i = 0; i < x.getSize(); i++) {
			temp.addElement((x.getElementAt(i) + y.getElementAt(i)));
		}
		return temp;
	}
	
	public void setToZero(Vector x) {
		for(int i = 0; i < x.getSize(); i++) {
			x.changeElementAt(i, 0);
		}
	}
	
	public void scaleVector(double alpha, Vector x) {
		for(int i = 0; i < x.getSize(); i++) {
			double temp = x.getElementAt(i);
			x.changeElementAt(i, (temp * alpha));
		}
	}
	
	/**
	 * Do not call this directly
	 */
	private void cleanUp() {
		xTopElements = new PriorityQueue<Double>();
		xBottomElements = new PriorityQueue<Double>();
		yTopElements = new PriorityQueue<Double>();
		yBottomElements = new PriorityQueue<Double>();
	}
	
	/**
	 * Do not call this method directly
	 */
	@Override
	public void populateBottoms(Vector x, Vector y) {
		// TODO Auto-generated method stub
		for (int i = 0; i < x.getSize(); i++) {
			xBottomElements.add(x.getElementAt(i));
			yBottomElements.add(y.getElementAt(i));
		}
	}

}
