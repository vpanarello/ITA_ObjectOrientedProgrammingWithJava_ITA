import java.util.HashMap;

public class Pizza {
	
	 // LISTA DE INGREDIENTES COM SUAS QUANTIDADES BASEADA EM UMA TABELA DE DISPERSAO ESTATICA "HASHMAP<key, value>"
	 static HashMap<String, Integer> conteudo = new HashMap<String, Integer>();
	
	 private int totalIngredientes = 0;
	 private String Nome;
	
	 Pizza(String N){  // CONSTRUTOR
		 this.Nome = N;
	 }
	 
	 private void contabilizaIngrediente(int quantidade) {
		 totalIngredientes += quantidade;
	 }

	public void adicionaIngrediente(String ingrediente, int quantidade){
		
		if (conteudo.containsKey(ingrediente))
			conteudo.put(ingrediente, conteudo.get(ingrediente) +  quantidade);
		else conteudo.put(ingrediente, quantidade);

		this.contabilizaIngrediente(quantidade);
	}
	
	public int getPreco() {
		
		int preco = 0;
		
		if(this.totalIngredientes > 0 && this.totalIngredientes <= 2)preco = 15;
		else if(this.totalIngredientes > 2 && this.totalIngredientes <= 5) preco = 20;
		else if(this.totalIngredientes > 5) preco = 23;
		else preco = 0;
	
		return preco;
	}
	public String getNome(){
		return this.Nome;
	}
}
