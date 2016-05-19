import java.util.HashMap;
import java.util.Map;

public class Corrida {
	
	private int pista;
	private Map<CarroDeCorrida, Integer> carros = new HashMap<>();
	

	public Corrida(int tamanho) {
		pista = tamanho;
	}
	
	public void addCarro(CarroDeCorrida carro){
		carros.put(carro, 0);
	}
	
	private boolean terminou(){
		boolean value = false;
		for(int valor : carros.values()) {
			if(valor >= this.pista){
				value = true;
				break;
				
			} else {
				value = false;
				break;
			}	
		}
		return value;
	}
	
	public void comecaCorrida(){
		
		while (!terminou()) {
			for (CarroDeCorrida car : carros.keySet()) {
				car.acelerar();
				int distancia = carros.get(car);
				distancia += car.getVelocidade();
				carros.put(car, distancia);
			} 
		}
		for (CarroDeCorrida car : carros.keySet()) {
			System.out.println(car.getNome() + " - " + carros.get(car));
		}
		
		
	}

}
