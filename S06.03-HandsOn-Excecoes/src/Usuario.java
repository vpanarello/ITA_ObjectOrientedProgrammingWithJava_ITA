
public class Usuario {
	
	private String login;
	private String pass;

	public Usuario(String nome, String senha) {
		this.login = nome;
		this.pass = senha;
	}

	public String getLogin() {
		return login;
	}

}
