
public class Calculadora {
	
	public float divide(int numerador, int denominador) throws ArithmeticException{
		
		try{
			float value = numerador / denominador;
			return value;
		}catch(ArithmeticException e){
			throw new ArithmeticException("Erro em operação " + e.getMessage());
		}
		
	}
	
}
		