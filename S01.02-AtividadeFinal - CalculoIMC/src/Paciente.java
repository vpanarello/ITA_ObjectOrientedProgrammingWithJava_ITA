
public class Paciente {
	
	double peso;
	double altura;
	
	Paciente(double p, double a) {
		peso = p;
		altura = a;
	}
	
	double calcularIMC() {
		return  peso / (altura*altura); 
	}
	
	String diagnostico() {
		
		double IMC = calcularIMC();
		String MSG = "";
		
    	if (IMC < 16){
    		MSG = "Baixo peso muito grave"; 
		}
		else if (IMC >= 16 && IMC < 17){
			MSG = "Baixo peso grave";
		}
		else if (IMC >= 17 && IMC < 18.5){
			MSG =  "Baixo peso";
		}
		else if (IMC >= 18.5 && IMC < 25){
			MSG =  "Peso normal";
		}
		else if (IMC >= 25 && IMC < 30){
			MSG =  "Sobrepeso";
		}
		else if (IMC >= 30 && IMC < 35){
			MSG =  "Obesidade grau I";
		}
		else if (IMC >= 35 && IMC < 40){
			MSG =  "Obesidade grau II";	
		}
		else {
			MSG =  "Obesidade grau III (obesidade mórbida)";
		}
    	return MSG;
		
	}
}

