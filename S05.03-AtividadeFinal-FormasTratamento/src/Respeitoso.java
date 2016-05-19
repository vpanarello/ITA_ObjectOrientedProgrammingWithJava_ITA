

public class Respeitoso implements FormatadorNome {
	private boolean masculino;

	public Respeitoso(boolean masculino) {
		super();
		this.masculino = masculino;
	}


	@Override
	public String formatarNome(String nome, String sobrenome) {
		if(masculino) return "Sr. "+ nome + " " + sobrenome;
		else return "Sra. "+ nome + " " + sobrenome;
	}

}
