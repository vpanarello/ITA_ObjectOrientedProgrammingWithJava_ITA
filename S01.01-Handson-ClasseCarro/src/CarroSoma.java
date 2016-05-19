
public class CarroSoma extends CarroDeCorrida{
	
	private double potencia;
	
	public CarroSoma(String nome, double potencia, double velocidadeMaxima) {
		super(nome, velocidadeMaxima);
		this.potencia = potencia;
	}
	@Override
	protected void acelerar(){
		super.velocidade += this.potencia;
		if (super.velocidade > super.velocidadeMaxima){
			super.velocidade = super.velocidadeMaxima;
		}
	}
}
