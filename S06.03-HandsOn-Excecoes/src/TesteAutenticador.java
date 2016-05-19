import static org.junit.Assert.*;

import org.junit.Test;

public class TesteAutenticador {

	@Test
	public void loginComSucesso() throws LoginException {
		Autenticador a = new Autenticador();
		Usuario u = a.logar("vagner", "vagnerpass");	
		assertEquals("vagner", u.getLogin());
	}
	
	@Test(expected = LoginException.class)
	public void loginFalha() throws LoginException {
		Autenticador a = new Autenticador();
		Usuario u = a.logar("vagner", "senhaerrada");
	}
	
	@Test
	public void informacaoDaFalha() {
		Autenticador a = new Autenticador();
		try {
			Usuario u = a.logar("vagner", "senhaerrada");
			fail();
		} catch (LoginException e) {
			assertEquals("vagner", e.getLogin());
		}
	}

}
