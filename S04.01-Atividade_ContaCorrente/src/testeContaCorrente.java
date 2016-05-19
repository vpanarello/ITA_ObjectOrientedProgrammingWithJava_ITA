import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class testeContaCorrente {
	
	ContaCorrente cc01;
	
	@Before
	public void inicializaConta(){
		cc01 = new ContaCorrente();
		cc01.depositar(1000);	
	}

	@Test
	public void testSacar(){
		assertTrue(cc01.sacar(500));
		assertEquals(500, cc01.getSaldo(),0);	
	}
	
	@Test
	public void testSaqueSemFundos(){	
		assertFalse(cc01.sacar(1500));
		assertEquals(1000, cc01.getSaldo(),0);
	}

}
