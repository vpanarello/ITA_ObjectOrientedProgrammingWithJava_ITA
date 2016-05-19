

public class ComTitulo implements FormatadorNome {
	private boolean masculino;

	public ComTitulo(boolean masculino) {
		super();
		this.masculino = masculino;
	}

	@Override
	public String formatarNome(String nome, String sobrenome) {	
		if(masculino) return "Magn�fico "+ nome + " " + sobrenome;
		else return "Magn�fica "+ nome + " " + sobrenome;
	}


}
