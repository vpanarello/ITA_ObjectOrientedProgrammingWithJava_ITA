import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class CarrinhoDeCompras {
	
	private static Map<Produto, Integer> produtos = new HashMap<>();

	public CarrinhoDeCompras() {
		super();
	}

	public void adicionaProduto(Produto p, int quantidade){
		if (produtos.containsKey(p)) {
			produtos.put(p, quantidade + produtos.get(p));
		}
		else {
			produtos.put(p, quantidade);
		}
	}
		
	public boolean removeProduto(Produto p, int quantidade){
		
		if(produtos.containsKey(p)){
			if(produtos.get(p) > quantidade){
				produtos.put(p, produtos.get(p) - quantidade);
			}
			else {
				produtos.remove(p);
			}
			return true;
		}
		else return false;	
	}
	
	public int getTotalValorCompra(){
		
		int value = 0;
		for (Produto p : produtos.keySet()) {
			value += p.getPreco() * produtos.get(p);	
		}
		return value;	
	}
	

	public static void limpaCarrinho(){
		produtos.clear();
	}
	public static Map<Produto, Integer> getProdutos() {
		return produtos;
	} 
}
	