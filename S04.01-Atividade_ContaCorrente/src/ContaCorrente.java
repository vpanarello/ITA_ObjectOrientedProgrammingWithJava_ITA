
public class ContaCorrente {
	
	double saldo = 0;
	
	public boolean sacar(double saque) {
		if (saque <= saldo){
			this.saldo -= saque;
			return true;
		}
		else return false;
	}
	
	public void depositar(double valor){
		saldo += valor;
	}
	public double getSaldo(){
		return saldo;
		
	}
}
