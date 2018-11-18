import Matrix.Matrix;
import Matrix.Vector;
import Matrix.Operations.VectorOperator;

public class testingMain {
	
	public static void main(String[] args) {
		double[] array = {2, 3 , 5};
		Vector vec1 = new Vector(3);
		Vector vec2 = new Vector(array);
		
		vec1.addElement(3);
		vec1.addElement(3);
		vec1.addElement(3);
		VectorOperator vec = new VectorOperator();
		System.out.println(vec.apdotOperation(vec1, vec2, 2));
		vec1 = vec.subtract(vec1, vec2);
		//vec.setToZero(vec1);
		vec1.printInFormat(1);
		
		Matrix mat1 = new Matrix(3, 3);
		mat1.addElement(2);
		mat1.addElement(3);
		mat1.addElement(4);
		mat1.addElement(1);
		mat1.addElement(1);
		mat1.addElement(1);
		mat1.addElement(1);
		mat1.addElement(1);
		mat1.addElement(1);
		System.out.println(mat1.getElementAt(1, 0));
		mat1.printInFormat();
	}
}
