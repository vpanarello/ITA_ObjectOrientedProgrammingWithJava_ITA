

public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	public void printFibonacciSequence(){
		
		for(int i = 0; i <= 100; i++){
			double out = (Math.pow(((1 + Math.sqrt(5)) / 2 ), i) - Math.pow(((1 - Math.sqrt(5)) / 2 ), i) ) / Math.sqrt(5);
			System.out.format("%d - %.3f, %n", i, out);

		}	
	}
	
	public boolean isEven(int value){
		
		return (boolean)(value & 1);
	}

}
