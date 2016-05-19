
public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		
		Pilha p = new Pilha(10);
		
		p.empilhar("Eduardo");
		p.empilhar("Maria");
		p.empilhar("Jose");
		
		System.out.format("%s - %d %n", p.topo(), p.tamanho());
		
		// p.setTopo(6);
		
		// Desempilhar
		System.out.format("%s - %s - %d %n",	p.desempilhar().toString().toUpperCase(),
												p.topo().toString().toUpperCase(),
												p.tamanho());


	}

}
