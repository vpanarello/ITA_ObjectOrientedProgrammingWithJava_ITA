
public class Principal {

	public static void main(String[] args) {
		Corrida race = new Corrida(5000);
		
		race.addCarro(new CarroSoma("Fusca", 10, 110));
		race.addCarro(new CarroSoma("Brasilia", 8, 140));
		race.addCarro(new CarroMult("Chevette", 1.7, 100));
		race.addCarro(new CarroMult("Bellina", 1.4, 150));
		race.comecaCorrida();

	}

}
