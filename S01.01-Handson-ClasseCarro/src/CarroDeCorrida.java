
public abstract class CarroDeCorrida {

	protected abstract void acelerar(); // Declaração de método

	protected double velocidade;
	protected double velocidadeMaxima;
	protected String nome;

	public CarroDeCorrida(String nome, double velocidadeMaxima) {
		super();
		this.nome = nome;
		this.velocidadeMaxima = velocidadeMaxima;
		this.velocidade = 0;
	}
	
	
	protected void frear() {
		velocidade = velocidade / 2;
		if(velocidade < 0.5) velocidade = 0;
	}

	public double getVelocidade() {
		return velocidade;
	}

	public String getNome() {
		return nome;
	}

}
