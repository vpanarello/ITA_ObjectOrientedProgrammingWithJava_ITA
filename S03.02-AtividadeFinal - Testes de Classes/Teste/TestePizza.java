import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class TestePizza {
	
	
	@Before
	public void clearAllIngredients(){
		Pizza.clearIngredientes();	
	}

	@Test
	public void testQuantidadeIngredientes() {
		Pizza p = new Pizza("Marguerita");
		
		p.adicionaIngrediente("rucula", 1);
		p.adicionaIngrediente("azeitona", 2);
		p.adicionaIngrediente("muzzarela", 1);
		p.adicionaIngrediente("alcachofra", 2);
		
		
		Set set = Pizza.conteudo.keySet();
		Iterator iter = set.iterator();
		
		int totalIngredientes = 0;
		
		 while (iter.hasNext()) {
			 Object chave = iter.next();
			 totalIngredientes += Pizza.conteudo.get(chave);
		 }
		 assertEquals(6, totalIngredientes);	
	}
	
		
	@Test
	public void testRegistroIngredientes() {
			
		
		Pizza p = new Pizza("Marguerita");
		
		p.adicionaIngrediente("rucula", 1);
		p.adicionaIngrediente("azeitona", 2);
		p.adicionaIngrediente("muzzarela", 1);
		p.adicionaIngrediente("alcachofra", 2);
		
		System.out.println(Pizza.conteudo.get("rucula"));
		
		assertEquals((Integer)1, Pizza.conteudo.get("rucula"));
		assertEquals((Integer)2, Pizza.conteudo.get("azeitona"));
		assertEquals((Integer)1, Pizza.conteudo.get("muzzarela"));
		assertEquals((Integer)2, Pizza.conteudo.get("alcachofra"));
	}
	
	@Test
	public void testCarrinho(){
		
		Pizza p = new Pizza("Marguerita");
		
		p.adicionaIngrediente("rucula", 1);
		p.adicionaIngrediente("azeitona", 2);
		p.adicionaIngrediente("muzzarela", 1);
		p.adicionaIngrediente("alcachofra", 2);
		
		CarrinhoDeCompras carrinho = new CarrinhoDeCompras();
		carrinho.adicionaItem(p);
		assertEquals(23, carrinho.getTotal());
		}
		
		
	@Test
		public void testCarrinhoPizzaSemIngredientes(){
		CarrinhoDeCompras c2 = new CarrinhoDeCompras();
		Pizza p2 = new Pizza("Marguerita");

		assertFalse(c2.adicionaItem(p2));
		
	}
		
	}



