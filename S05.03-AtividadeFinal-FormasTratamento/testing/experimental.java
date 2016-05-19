import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class experimental {
	
	/* vetor de objetos de dimensão 6 */
	private static Autoridade[] n = new Autoridade[6];
	
	@BeforeClass
	public static void inicializaInstancias(){
		
		int index = 0;
		
		/* criando 6 objetos e armazenando em cada espaço do vetor */
		n[index] = new Autoridade("Mário", "Bros", true, "respeitoso"); index++;
		n[index] = new Autoridade("Lara", "Croft", false, "Respeitoso"); index++;
		n[index] = new Autoridade("Dunha", "Silva", true, "comTitulo"); index++;
		n[index] = new Autoridade("Dilma", "Rousseff", false, "comTitulo"); index++;
		n[index] = new Autoridade("Lonchas", "Bueno", true, "Informal"); index++;
		n[index] = new Autoridade("Marina", "Silva", false, "Informal"); index++;
		
		/* rapida impressao para checar string gerada */
		for (int i = 0; i < index; i++){
			System.out.println(n[i].getTratamento());	
		}
	}
	
	
	/* testes automatizados com todas 6 condicoes possiveis */
	@Test
	public void Respeitoso_Homem() {
		assertTrue("String diferente do esperado", n[0].getTratamento().equals("Sr. Mário Bros"));
	}
	@Test
	public void Respeitoso_Mulher() {
		assertTrue("String diferente do esperado", n[1].getTratamento().equals("Sra. Lara Croft"));
	}
	@Test
	public void Titulo_Homem() {
		assertTrue("String diferente do esperado", n[2].getTratamento().equals("Magnífico Dunha Silva"));
	}
	@Test
	public void Titulo_Mulher() {
		assertTrue("String diferente do esperado", n[3].getTratamento().equals("Magnífica Dilma Rousseff"));
	}
	@Test
	public void Informal_Homem() {
		assertTrue("String diferente do esperado", n[4].getTratamento().equals("Lonchas Bueno"));
	}
	@Test
	public void Informal_Mulher() {
		assertTrue("String diferente do esperado", n[5].getTratamento().equals("Marina Silva"));
	}

}
