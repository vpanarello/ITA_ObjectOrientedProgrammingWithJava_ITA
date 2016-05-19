
public class Aluno {
	
	int bim1;
	int bim2;
	int bim3;
	int bim4;
	
	public int mediaAluno(Aluno a){
		int total = 0;
		total += this.bim1;
		total += this.bim2;
		total += this.bim3;
		total += this.bim4;
		return total / 4;		
	}
	
	public boolean passouDeAno(Aluno a){
		int media = mediaAluno(a);
		if(media >= 60)
			return true;
		return false;
	}

}
