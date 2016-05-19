import java.util.ArrayList;

public class CarrinhoDeCompras {

	// LISTA PRIVADA PARA ARMAZENAR OBJETOS "PIZZA"
	private ArrayList<Pizza> carrinho = new ArrayList<Pizza>();
	
	public boolean adicionaItem(Pizza item){
		
		if (!item.conteudo.isEmpty())
			{
			carrinho.add(item);
			return true;
			}
		else return false;
		
		
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
