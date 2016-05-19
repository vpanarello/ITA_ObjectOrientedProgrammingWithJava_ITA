import java.util.Map;

public class  Produto {
	
	private String nome;
	private int preco;

	public Produto(String n, int v) { // Constructor
		this.nome = n;;
		this.preco = v;
	}

	public String getNome() {
		return nome;
	}

	public int getPreco() {
		return preco;
	}

	public long getCodigoProduto(){
		return Math.abs(this.hashCode()) ;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
}
