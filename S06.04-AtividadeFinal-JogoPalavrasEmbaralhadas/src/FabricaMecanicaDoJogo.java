import java.io.IOException;
import java.util.Random;

public class FabricaMecanicaDoJogo implements MecanicaDoJogo {

	private String DictFile;
	private String DictDir;
	
	private char[] palavraAtual;
	
	private char[] letrasAdivinhadasForca;
	
	private boolean playingForca = false;
	private boolean PlayingPE = false;
	private boolean hitPE = false;
	
	private int chancesForca;
	private int chancesPE;
	
	Random random;
	
	FabricaEmbaralhadores play;	// MODIFICAR PARA EMBARALHADORES

	
	public FabricaMecanicaDoJogo(String dictFile, String dictDir) throws IOException {
		super();
		DictFile = dictFile;
		DictDir = dictDir;
		
		play = new FabricaEmbaralhadores(DictFile, DictDir);
		
		random =  new Random();
	
	}
	
  ///////////////* Métodos jogo de FORCA */////////////////////
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#pritForcaEndOfGame()
	 */
	@Override
	public String pritForcaEndOfGame(){
		String output = "";

		for(char v : this.palavraAtual){
			output = output +  v + "  ";
		}
		output = output + '\n';

		for(char v : play.getTracejado()){
			output = output +  v + "  ";}

		if (this.chancesForca >= 0) {
			output = output + "  Parabéns!" ;
		} else {
			output = output + "\n\nNão foi desta vez, mais sorte na próxima !" ;
		}
		return output;
	}

	/* (non-Javadoc)
	 * @see MecanicaDoJogo#printForca()
	 */
	@Override
	public String printForca(){
		String output = "";
		if (this.chancesForca >= 0) {
			for (char v : this.letrasAdivinhadasForca) {
				output = output + v + "  ";
			}
			output = output + '\n';
			for (char v : play.getTracejado()) {
				output = output + v + "  ";
			}
			output = output + "   Chances = " + this.chancesForca;
		}
		return output;
	}


	/* (non-Javadoc)
	 * @see MecanicaDoJogo#playForca(int, java.lang.String)
	 */
	@Override
	public String playForca(int chances, String beginWith){

		this.chancesForca = chances;
		this.palavraAtual = play.getPalavraForca(beginWith);
		this.playF();
		this.jogadaForca(beginWith, true);
		return this.printForca();
	}

	/* (non-Javadoc)
	 * @see MecanicaDoJogo#playForca(int)
	 */
	@Override
	public String playForca(int chances){
		this.chancesForca = chances;
		this.palavraAtual = play.getPalavraForca();
		this.playF();
		return this.printForca();
	}

	private void playF(){
		this.playingForca = true;
		this.letrasAdivinhadasForca = new char[play.getLastWordSize()];
		int rm = random.nextInt(play.getLastWordSize());

		for(int i = 0; i < play.getLastWordSize(); i++ ){
			if (i == rm) this.letrasAdivinhadasForca[i] = this.palavraAtual[i];
			else this.letrasAdivinhadasForca[i] = 32;
		}
		this.jogadaForca(palavraAtual[rm] + "", true);
	}

	/* (non-Javadoc)
	 * @see MecanicaDoJogo#jogadaForca(java.lang.String, boolean)
	 */
	@Override
	public void jogadaForca(String letra, boolean acerto){

		if (letra.length() > 0){
			char c = letra.toUpperCase().charAt(0);

			for (int i = 0; i < play.getLastWordSize(); i++){

				if(this.palavraAtual[i] == c && this.letrasAdivinhadasForca[i] != c ){
					this.letrasAdivinhadasForca[i] = this.palavraAtual[i];
					acerto = true;
				}
			}
			if (this.chancesForca >= 0){ 
				for (int i = 0; i < play.getLastWordSize(); i++){
					if(this.letrasAdivinhadasForca[i] == 32 ){
						this.playingForca = true; // continua
						break;
					} else {
						this.playingForca = false; // ganhou

					}
				}
			} else {
				this.playingForca = false;  // perdeu
			}
			if(!acerto) this.chancesForca --;
		}
		else {
			if (this.chancesForca < 0) this.playingForca = false;
		}
	}
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#isPlayingForca()
	 */
	@Override
	public boolean isPlayingForca(){
		return playingForca;
	}
///////////////* FIM Métodos jogo de FORCA */////////////////////
	
///////////////* Métodos jogo de PALAVRAS EMBARALHADAS */////////////////////	
	
	
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#printEndOfGamePE()
	 */
	@Override
	public String printEndOfGamePE(){
		String msg = "\n\n";
		
		for(char v : play.getPalavraAtual()){
			msg +=  v + " ";
		}
		msg += "\n\n";
		
		
		if(this.hitPE){
			msg += "Acertou, Parabéns !!";
		} else {
		    msg += "Não foi desta vez, mais sorte na próxima";
		}
		
		return msg;
	}
	
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#printPE()
	 */
	@Override
	public String printPE(){
		String str = "";
		for(char c: this.palavraAtual){
			str += c + " ";
		}
		str += String.format("            Chances: %d", this.chancesPE);
		
		if(this.chancesPE >= 0) return str;
		else return "";
	}
	
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#playPalavrasEmbaralhadas(int, int, java.lang.String)
	 */
	@Override
	public String playPalavrasEmbaralhadas(int modo, int chances, String beginWith){
		
		this.chancesPE = chances;
		this.palavraAtual = play.getPalavraEmbaralhada(modo, beginWith);
		return this.playPE();
	}

	/* (non-Javadoc)
	 * @see MecanicaDoJogo#playPalavrasEmbaralhadas(int, int)
	 */
	@Override
	public String playPalavrasEmbaralhadas(int modo, int chances){
		this.chancesPE = chances;
		this.palavraAtual = play.getPalavraEmbaralhada(modo);
		return this.playPE();
		
	}
	
	private String playPE(){
		this.PlayingPE = true;
		String str = "";
		
		str += "\nDê o seu palpite (digite no teclado e aperte ENTER) \n\n";
		
		for(char c: this.palavraAtual){
			str += c + " ";
		}
		str += String.format("            Chances: %d", this.chancesPE);
		
		return str;
	}
	
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#jogadaPE(java.lang.String)
	 */
	@Override
	public void jogadaPE(String tentativa){

		this.hitPE = false;

		char[] t = tentativa.toUpperCase().toCharArray();
		char[] p = play.getPalavraAtual();

		if(p.length == t.length){
			this.hitPE = true;
			for(int i = 0; i < p.length; i++){
				if(t[i] != p[i]){
					this.hitPE = false;
					break;
				}
			}
		} else this.chancesPE --;
		
		if(this.hitPE) this.PlayingPE = false;
		if(this.chancesPE < 0) this.PlayingPE = false;
	}


	
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#isPlayingPE()
	 */
	@Override
	public boolean isPlayingPE(){
		return this.PlayingPE;
	}
		
	
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#getPalavraAtual()
	 */
	@Override
	public char[] getPalavraAtual() {
		return palavraAtual;
	}
	
		
	/* (non-Javadoc)
	 * @see MecanicaDoJogo#getQuantidadePalavras()
	 */
	@Override
	public int getQuantidadePalavras(){
		return play.getQuantidadePalavras();
	}

	
	
	public void debugPrintDataBase(){
		play.debugPrintDataBase();
	}




}
