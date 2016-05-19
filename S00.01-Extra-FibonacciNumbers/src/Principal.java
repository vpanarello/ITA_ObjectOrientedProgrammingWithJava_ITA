
public class Principal {
	
	private static Fibonacci fi = new Fibonacci();

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		// fi.printFibonacciSequence();
		
		
		for(int i = 0; i < 9; i++){
			System.out.format("%d - %d%n",i,fi.isEven(i));
		}
		
	}

}
