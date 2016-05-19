import java.util.ArrayList;

public class CarrinhoDeCompras {

	// LISTA PRIVADA PARA ARMAZENAR OBJETOS "PIZZA"
	private ArrayList<Pizza> carrinho = new ArrayList<Pizza>();
	
	void adicionaItem(Pizza item){
		carrinho.add(item);	
	}

	// RETORNA LISTA INTEIRA COM OBJETOS "PIZZA"
	public ArrayList<Pizza> getItens(){
		return carrinho;
	}
	
	public int getTotal(){
		
		int total = 0;
		
		for (int i = 0; i < this.getItens().size(); i ++){
			total += this.getItens().get(i).getPreco();
			}
		return total;
	}
}
