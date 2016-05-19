
public interface Embaralhadores {

	/////////////* M�TODOS DO JOGO FORCA *//////////////
	char[] getPalavraForca();

	char[] getPalavraForca(String beginWith);
	/////////////* FIM M�TODOS DO JOGO FORCA *//////////////

	char[] getPalavraAtual();

	char[] getPalavraEmbaralhada(int modo, String beginWith);

	char[] getPalavraEmbaralhada(int modo);

	char[] getTracejado();

	int getLastWordSize();

	int getQuantidadePalavras();

}