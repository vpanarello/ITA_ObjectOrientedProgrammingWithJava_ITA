import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testeCarroMult {
	
	CarroMult c02;
	
	@Before
	public void inicializaCarro(){
		c02 = new CarroMult("Fusca",1.5,100);
	}
	
	@Test
	public void testCarroParado(){
		assertEquals(c02.getVelocidade(),0,0);
	}

	@Test
	public void testAcelerar_01Vez() {
		c02.acelerar();
		assertEquals(15,c02.getVelocidade(),0);
	}
	@Test
	public void testAcelerar_02Vez() {
		for(int i = 0; i < 2; i++){
			c02.acelerar();
		}
		assertEquals(22.5,c02.getVelocidade(),0);
	}
	@Test
	public void testFrear(){
		c02.acelerar();
		c02.frear();
		assertEquals(7.5,c02.getVelocidade(),0);
	}
	@Test
	public void testFrearAteZero(){
		c02.acelerar();
		for(int i = 0; i < 5; i++){
			c02.frear();
		}
		assertEquals(0,c02.getVelocidade(),0);
	}
	
	@Test
	public void testVelocidadeMaxima(){
		for(int i = 0; i <= 13; i++){
			c02.acelerar();
		}
		assertEquals(100,c02.getVelocidade(),0);
		
	}
}