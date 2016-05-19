
public class ContaEspecial extends ContaCorrente {
	
	private double limite;
	
	ContaEspecial(double li){
		this.limite = li;	
	}
	
	public boolean sacar(double saque) {
		if (saque <= (super.saldo + this.limite)){
			saldo -= saque;
			return true;
		}
		else return false;
	}

}
