import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TesteCarroSoma {
	
	CarroDeCorrida c01;
	
	@Before
	public void inicializaCarro(){
		c01 = new CarroSoma("Belina",10,100);
	}
	
	@Test
	public void testCarroParado(){
		assertEquals(c01.getVelocidade(),0,0);
	}

	@Test
	public void testAcelerar() {
		c01.acelerar();
		assertEquals(c01.getVelocidade(),10,0);
	}
	@Test
	public void testFrearAteZero(){
		c01.acelerar();
		for(int i = 0; i < 5; i++){
			c01.frear();
		}
		assertEquals(0,c01.getVelocidade(),0);
	}
	
	@Test
	public void testVelocidadeMaxima(){
		for(int i = 0; i <= 13; i++){
			c01.acelerar();
		}
		assertEquals(100,c01.getVelocidade(),0);
		
	}
}
