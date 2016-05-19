
public interface MecanicaDoJogo {

	///////////////* Métodos jogo de FORCA */////////////////////
	String pritForcaEndOfGame();

	String printForca();

	String playForca(int chances, String beginWith);

	String playForca(int chances);

	void jogadaForca(String letra, boolean acerto);

	boolean isPlayingForca();
	///////////////* FIM Métodos jogo de FORCA */////////////////////

	String printEndOfGamePE();

	String printPE();

	String playPalavrasEmbaralhadas(int modo, int chances, String beginWith);

	String playPalavrasEmbaralhadas(int modo, int chances);

	void jogadaPE(String tentativa);

	boolean isPlayingPE();

	char[] getPalavraAtual();

	int getQuantidadePalavras();

}