import java.util.Iterator;
import java.util.Set;

public class Principal {

	public static void main(String[] args) {
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		
		/* CRIANDO PIZZA 1 SABOR BAIANA E ADD AO CARRINHO */
		Pizza baiana = new Pizza("Baiana");
		
		baiana.adicionaIngrediente("cebola", 1);
		baiana.adicionaIngrediente("tomate", 1);
		baiana.adicionaIngrediente("azeitona", 1);
		
		carrinho.adicionaItem(baiana);
		
		/* CRIANDO PIZZA 2 SABOR ALICHE E ADD AO CARRINHO */
		Pizza aliche = new Pizza("Aliche");
		
		aliche.adicionaIngrediente("rucula", 1);
		aliche.adicionaIngrediente("azeitona", 2);
		aliche.adicionaIngrediente("muzzarela", 1);
		aliche.adicionaIngrediente("alcachofra", 2);
		
		carrinho.adicionaItem(aliche);
		
		/* CRIANDO PIZZA 3 SABOR MUZZARELLA E ADD AO CARRINHO */
		Pizza muzzarella = new Pizza("Muzzarella");
		
		muzzarella.adicionaIngrediente("tomate", 1);
		muzzarella.adicionaIngrediente("azeitona", 2);
		muzzarella.adicionaIngrediente("oregano", 1);
		
		carrinho.adicionaItem(muzzarella);
		
		
		/* IMPRESSAO DOS ITENS DO CARRINHO E VALOR TOTAL  */
		for (int i = 0; i < carrinho.getItens().size(); i ++){
			System.out.format("%s = R$ %d%n",carrinho.getItens().get(i).getNome(),carrinho.getItens().get(i).getPreco());	
		}
		System.out.format("---------------------%nTotal = R$ %d %n%n%n", carrinho.getTotal());
		
		/*  EXEMPLO DO OUTPUT NO CONSOLE
		 *
		 * Baiana = R$ 20
		 * Aliche = R$ 20
		 * Muzzarella = R$ 20
		 * ---------------------
		 * Total = R$ 60
		 */
				
		/* Impressao em console da lista de ingredientes utilizados  */		
		Set set = Pizza.conteudo.keySet();
		Iterator iter = set.iterator();
		
		System.out.format("Ingredietes%n------------%n");
		
		 while (iter.hasNext()) {
			 Object chave = iter.next();
		     System.out.format("%s - %s%n",Pizza.conteudo.get(chave),chave);
		 }
		 /* Ingredietes
		  * ------------
		  * 1 - rucula
		  * 5 - azeitona
		  * 1 - oregano
		  * 2 - alcachofra
		  * 1 - muzzarela
		  * 1 - cebola
		  * 2 - tomate
		  */
	}
}
