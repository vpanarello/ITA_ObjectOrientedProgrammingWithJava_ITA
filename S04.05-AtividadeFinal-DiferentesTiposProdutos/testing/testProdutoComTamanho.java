import static org.junit.Assert.*;

import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testProdutoComTamanho {
	
	private ProdutoComTamanho a;
	private ProdutoComTamanho b;
	private ProdutoComTamanho c;
	private ProdutoComTamanho d;
	
	/* Inicializa 4 objetos "produto" */
	@Before
	public void inicializaProduto(){
		a = new ProdutoComTamanho("Chinelas", 70, 38);
		b = new ProdutoComTamanho("Camisa", 80, 10);
		c = new ProdutoComTamanho("Chinelas", 100, 42);
		d = new ProdutoComTamanho("Chinelas", 110, 42);	
	}
	
	/* Verifica se o produto foi criado com o "nome", "preco" e "tamanho" especificados */
	@Test
	public void criarNovoProduto() {
		
		assertTrue("(Instancia 'a' não encontrada)",a.getNome() == "Chinelas");
		assertEquals("(Atributo 'preco' é diferente)",70, a.getPreco());
		assertEquals("(Atributo 'tamanho' é diferente)",38, a.getTamanho());
	}
	
	/* Verifica igualdade de instancias baseando-se somente no atributo "nome" */
	@Test
	public void testMetodoHashCode(){
		assertFalse("(Instâncias deveriam ser diferentes)",a.equals(c));
		assertTrue("(Instancias deveriam ser iguais)",c.equals(d));
	}

}
