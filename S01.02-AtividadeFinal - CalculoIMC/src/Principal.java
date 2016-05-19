
public class Principal {

	public static void main(String[] args) {
		
		Paciente p01 = new Paciente(57, 1.73); // Paloma
		Paciente p02 = new Paciente(82, 1.70); // Jose
		Paciente p03 = new Paciente(67, 1.65); // Ivani
		
		
		System.out.format("%10.1f - %s%n", p01.calcularIMC(), p01.diagnostico());
		System.out.format("%10.1f - %s%n", p02.calcularIMC(), p02.diagnostico());
		System.out.format("%10.1f - %s%n", p03.calcularIMC(), p03.diagnostico());
	}
}
