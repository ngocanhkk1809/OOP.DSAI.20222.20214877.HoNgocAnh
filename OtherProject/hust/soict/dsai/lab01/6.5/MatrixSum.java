import javax.swing.JOptionPane;

public class MatrixSum {
	//Convert matrix to string
	public static String matrixToString(double[][] matrix) {
		String strMatrix = "";
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				strMatrix += matrix[i][j] + "    ";
			}
			strMatrix += "\n";
		}
		return strMatrix;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Input size of matrix
		String input = JOptionPane.showInputDialog(null, "Please enter the size of the matrix: ", "Input", JOptionPane.INFORMATION_MESSAGE);
		String[] arr =  input.split(" ");
		int[] numbers = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			numbers[i] = Integer.parseInt(arr[i]);
		}
		double matrixA[][] = new double[numbers[0]][numbers[1]];
		double matrixB[][] = new double[numbers[0]][numbers[1]];
		double res[][] = new double[numbers[0]][numbers[1]];
		//Input matrix A
		for (int i = 0; i < numbers[0]; i++) {
			String inputRowA = JOptionPane.showInputDialog(null, "Please enter the element(s) of row" + (i + 1) +" of the matrix A: ", "Row input", JOptionPane.INFORMATION_MESSAGE);
			String[] rowA =  inputRowA.split(" ");
			for (int j = 0; j < numbers[1]; j++) {
				matrixA[i][j] = Double.parseDouble(rowA[j]);
			}
		}
		
		//Input matrix B
		for (int i = 0; i < numbers[0]; i++) {
			String inputRowB = JOptionPane.showInputDialog(null, "Please enter the element(s) of row" + (i + 1) +" of the matrix B: ", "Row input", JOptionPane.INFORMATION_MESSAGE);
			String[] rowB =  inputRowB.split(" ");
			for (int j = 0; j < numbers[1]; j++) {
				matrixB[i][j] = Double.parseDouble(rowB[j]);
			}
		}
		
		//Compute sum of two matrix
		for (int i = 0; i < numbers[0]; i++) {
			for (int j = 0; j < numbers[1]; j++) {
				res[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
		
		//Display result
		JOptionPane.showMessageDialog(null, "Matrix A: \n" + matrixToString(matrixA)
		+ "\n" + "Matrix B: \n" + matrixToString(matrixB) +  "\n" 
		+ "The sum of 2 matrix: \n" + matrixToString(res), "Result", JOptionPane.INFORMATION_MESSAGE);
	}
}