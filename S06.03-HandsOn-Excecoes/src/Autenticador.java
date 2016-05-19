
public class Autenticador {

	public Autenticador() {
	}
	
	public Usuario logar(String login, String senha) throws LoginException{
		if(login.equals("vagner") && senha.equals("vagnerpass")){
			return new Usuario(login, senha);
		}
		else throw new LoginException("Senha/Usuário Incorretos", login);
	}

}
