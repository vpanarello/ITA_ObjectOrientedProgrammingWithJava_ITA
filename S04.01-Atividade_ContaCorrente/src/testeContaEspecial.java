import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class testeContaEspecial extends testeContaCorrente {
	
	ContaEspecial cc02;

	@Before
	public void testContaEspecial() {
		cc02 = new ContaEspecial(2000);
	}
	
	@Test
	public void testSacar(){
		assertTrue(cc02.sacar(500));
		
		assertEquals(cc02.getSaldo(),-500,0);
	//	fail("(Saldo de R$ " + String.valueOf(cc02.getSaldo())+")");
	
	}
	
	
	
	

}
