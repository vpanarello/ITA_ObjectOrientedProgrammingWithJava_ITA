
public class Principal {

	public static void main(String[] args) {
		Aluno Vagner = new Aluno();
		
		Vagner.bim1 = 70;
		Vagner.bim2 = 60;
		Vagner.bim3 = 80;
		Vagner.bim4 = 70;
		
		System.out.print(Vagner.mediaAluno(Vagner)+" - ");
		System.out.println(Vagner.passouDeAno(Vagner));

		
	}

}
