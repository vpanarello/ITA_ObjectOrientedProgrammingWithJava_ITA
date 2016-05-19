public class Autoridade {
	
	private String nome;
	private String sobrenome;
	private boolean masculino;
	private String tratamento;
	
	
	/* Objeto que segue o padrao da interface "FormatadorNome" que é implementada pelas 3 classes de titulos */
	FormatadorNome elemento;
	
	/* Construtor da classe - recebe nome, sobrenome, genero e string que define o tratamento */
	public Autoridade(String nome, String sobrenome, boolean masculino, String tratamento) {
		super();
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.masculino = masculino;
		this.tratamento = tratamento;
	}

	
	public String getTratamento(){
		
		/* Switch Case instancia somente uma classe de acordo com a string tratamento recebida */
		switch(tratamento.toLowerCase()) {
			case "informal":
				elemento = new Informal(this.masculino);
				break;
			case "respeitoso":
				elemento = new Respeitoso(this.masculino);
				break;
			case "comtitulo":
				elemento = new ComTitulo(this.masculino);
				break;
				}
		
		return elemento.formatarNome(this.nome, this.sobrenome);	
		}
}
