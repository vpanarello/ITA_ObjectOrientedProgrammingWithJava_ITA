

public class Informal implements FormatadorNome {
	private boolean masculino;

	public Informal(boolean masculino) {
		super();
		this.masculino = masculino;
	}

	@Override
	public String formatarNome(String nome, String sobrenome) {
		if(masculino) return nome + " " + sobrenome;
		else return nome + " " + sobrenome;
	}

}
