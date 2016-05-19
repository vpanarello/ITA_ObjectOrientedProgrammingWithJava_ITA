import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
	
	static private Calculadora c;

	public Principal() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args){
		
		int num = 0;
		int den = 0;
		
		
		Scanner input = new Scanner(System.in);
		c = new Calculadora();
		
		try {
			System.out.print("Entre numerador: ");
			num = input.nextInt();
			System.out.print("Entre denominador: ");
			den = input.nextInt();
			System.out.println(c.divide(num, den));
			
			
		} catch (ArithmeticException e) {
				System.err.println(e.getMessage()); 
			
		} catch (InputMismatchException e){
			System.err.println("Somente números");
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
/*
	public static void main(String[] args) throws Exception {
		a(100);

	}
	public static void a(int i) throws Exception{
		System.out.println("Executando a() com " + i);
		try {
			b(100);
		} catch (Exception e) {
			System.out.println("Tratando a excecao " + e.getMessage());
		}
	}
	
	public static void b(int i) throws Exception{
		System.out.println("Executando b()  com " + i);
		throw new Exception("Mensagem");
	}*/
	
	

	


}
