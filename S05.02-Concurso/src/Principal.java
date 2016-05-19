
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Principal {

	public Principal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		List<Candidato> l = new ArrayList<>();
		
		l.add(new Candidato(80, true, 30));
		l.add(new Candidato(80, false, 25));
		l.add(new Candidato(80, false, 28));
		l.add(new Candidato(90, false, 20));
		
		
		Collections.sort(l);
		
		for(Candidato c : l){
			System.out.println(c);
		}
		

	}


}
