

public class ComTitulo implements FormatadorNome {
	private boolean masculino;

	public ComTitulo(boolean masculino) {
		super();
		this.masculino = masculino;
	}

	@Override
	public String formatarNome(String nome, String sobrenome) {	
		if(masculino) return "Magnífico "+ nome + " " + sobrenome;
		else return "Magnífica "+ nome + " " + sobrenome;
	}


}
