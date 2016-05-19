import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

public class testCarrinhoDeCompras {
	
	private static CarrinhoDeCompras car;
	
	/* Array para instancias de Produto */
	private ArrayList<Produto> p = new ArrayList<>();
	/* Array para quantidade de cada Produto */
	private ArrayList<Integer> q = new ArrayList<>();
	
	/* Metodo criado para imprimir um relatório de todo conteudo do Carrinho  */
	@AfterClass
	public static void executaPorUltimo(){
		imprimeConteudoCarrinho(car);
	}
	
	@Before
	public void criarProdutos_AddCarrinho(){
		
		CarrinhoDeCompras.limpaCarrinho();
		
		car = new CarrinhoDeCompras();
	
		p.add(new Produto("Camisa Polo", 25)); q.add(3);
		p.add(new Produto("Tenis Classico", 40)); q.add(2);
		p.add(new ProdutoComTamanho("Chinelas", 40, 20)); q.add(5);
		p.add(new ProdutoComTamanho("Chinelas", 40, 38)); q.add(1);
		
		/* Adiciona todos os produtos ao carrinho */
		for (Produto n: p){
			car.adicionaProduto(n, q.get(p.indexOf(n)));
		}
	}
	
	@Test
	public void testeProdutosInseridos(){
		
		for (Produto n: p) {
			assertTrue(CarrinhoDeCompras.getProdutos().containsKey(n));
		}
	}
	
	
	
	@Test
	public void testeTotalValorCompra(){
		
		assertEquals(395, car.getTotalValorCompra(), 0);
	}
	
	@Test
	public void testeRemoveProduto(){
		
		assertTrue(car.removeProduto(new Produto("Camisa Polo", 25), 1));
		assertTrue(car.removeProduto(new ProdutoComTamanho("Chinelas", 40, 20), 3));
	}
		

	
	/* Método suplementar para impressão do conteudo do objeto "CarrinhoDeCompras" */
	
	private static void imprimeConteudoCarrinho(CarrinhoDeCompras c){
		
		for (Produto p : CarrinhoDeCompras.getProdutos().keySet()){
			System.out.format("-------------------------------%n"
					+ "Código: %d%n"
					+ "Nome: %s%n", p.getCodigoProduto(),p.getNome());
		
			if (p.getClass() == ProdutoComTamanho.class){
				ProdutoComTamanho p2 = (ProdutoComTamanho) p;
				System.out.format("Tamanho %d%n", p2.getTamanho());
			}
			System.out.format("Quantidade: %d%n", CarrinhoDeCompras.getProdutos().get(p));
		}
		System.out.format("-------------------------------%nPreço Total: %d%n", car.getTotalValorCompra());
	}
	
}

