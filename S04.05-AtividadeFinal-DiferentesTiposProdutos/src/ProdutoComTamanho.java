
public class ProdutoComTamanho extends Produto {
	
	private int tamanho;

	public ProdutoComTamanho(String n, int v, int t) {
		super(n, v);
		tamanho = t;
	}

	public int getTamanho() {
		return tamanho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + tamanho;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoComTamanho other = (ProdutoComTamanho) obj;
		if (tamanho != other.tamanho)
			return false;
		return true;
	}
}

