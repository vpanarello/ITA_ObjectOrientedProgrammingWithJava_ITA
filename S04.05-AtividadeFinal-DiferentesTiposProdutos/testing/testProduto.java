import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testProduto {
	
	private Produto a;
	private Produto b;
	private Produto c;
	
	/* Inicializa 3 objetos "produto" */
	@Before
	public void inicializaProduto(){
		a = new Produto("Chinelas", 50);
		b = new Produto("Camisa", 70);
		c = new Produto("Chinelas", 100);
	}
	
	/* Verifica se o produto foi criado com o "nome" e "preco" especificados */
	@Test
	public void criarNovoProduto() {
		
		assertTrue("(Instancia 'a' não encontrada)",a.getNome() == "Chinelas");
		assertEquals("(Atributo 'preco' é diferente)",50, a.getPreco());
	}
	
	/* Verifica igualdade de instancias baseando-se somente no atributo "nome" */
	@Test
	public void testMetodoHashCode(){
		assertTrue("(Instancias deveriam ser iguais)",a.equals(c));
		assertFalse("(Instâncias deveriam ser diferentes)",a.equals(b));
	}
}
