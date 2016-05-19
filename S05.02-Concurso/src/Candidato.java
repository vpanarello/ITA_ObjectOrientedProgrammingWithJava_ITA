
public class Candidato implements Comparable<Candidato> {
	
	private int nota;
	private boolean deficiencia;
	private int idade;

	public Candidato(int nota, boolean deficiencia, int idade) {
		super();
		this.nota = nota;
		this.deficiencia = deficiencia;
		this.idade = idade;
	}
	
	/* Definir uma receita de como a classe Collections ira ordenar itens de uma lista*/
	@Override
	public int compareTo(Candidato c) {
		if(this.nota == c.getNota()){
			if(this.deficiencia == c.deficiencia) return idade - c.getIdade();
		} else {
			if(this.deficiencia) return 1;
			else return -1;
		}
		return 0;
	}
	@Override
	public String toString() {
		//return super.toString();
		return this.getNota() + " - " + this.getIdade() + " - " + this.isDeficiencia();
	}
	
	protected int getNota() {
		return nota;
	}
	protected boolean isDeficiencia() {
		return deficiencia;
	}
	protected int getIdade() {
		return idade;
	}


}
