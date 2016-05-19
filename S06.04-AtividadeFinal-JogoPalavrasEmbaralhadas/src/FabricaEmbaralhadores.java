import java.io.IOException;

public class FabricaEmbaralhadores implements Embaralhadores  {
	
	private BancoDePalavras banco;
	
	private char[] palavraAtual;

	public FabricaEmbaralhadores(String dictFileName, String dictFolder) throws IOException {
		
		banco = new BancoDePalavras(dictFileName, dictFolder);	
	}
	
	

	/////////////* MÉTODOS DO JOGO FORCA *//////////////
 	/* (non-Javadoc)
	 * @see Embaralhadores#getPalavraForca()
	 */
 	@Override
	public char[] getPalavraForca(){
		return banco.getPalavra().toUpperCase().toCharArray();	
	}
	
	/* (non-Javadoc)
	 * @see Embaralhadores#getPalavraForca(java.lang.String)
	 */
	@Override
	public char[] getPalavraForca(String beginWith){
		return banco.getPalavra(beginWith).toUpperCase().toCharArray();	
	}
	/////////////* FIM MÉTODOS DO JOGO FORCA *//////////////
	
	
	
	
/////////////* MÉTODOS DO JOGO DE EMBARALHAMENTO *//////////////
	
	/* (non-Javadoc)
	 * @see Embaralhadores#getPalavraAtual()
	 */
	@Override
	public char[] getPalavraAtual() {
		return this.palavraAtual.clone();
	} 
	
	
	/* (non-Javadoc)
	 * @see Embaralhadores#getPalavraEmbaralhada(int, java.lang.String)
	 */
	@Override
	public char[] getPalavraEmbaralhada(int modo, String beginWith){
		
		this.palavraAtual = banco.getPalavra(beginWith).toUpperCase().toCharArray();
		return this.getPE(modo);	
	}

	/* (non-Javadoc)
	 * @see Embaralhadores#getPalavraEmbaralhada(int)
	 */
	@Override
	public char[] getPalavraEmbaralhada(int modo){
		
		this.palavraAtual = banco.getPalavra().toUpperCase().toCharArray();
		return this.getPE(modo);		
	}
	
	private char[] getPE(int modo) {
		
		char[] embaralhado = this.palavraAtual.clone();
		
		boolean embaralha = false;
		boolean inversao = false;
		
		switch(modo){ // 1: inversão - 2: embaralha = 3: embaralha e inverte
			case 1:
				embaralha = false;
				inversao = true; 
				break;
			case 2:
				embaralha = true;
				inversao = false; 
				break;
			case 3:
				embaralha = true;
				inversao = true; 
				break;
		}

		/* inversao em conjunto de letras */

		if (embaralha) {
			int wordSize = this.palavraAtual.length;
			int CharGroups;
			for (CharGroups = 5; CharGroups > 0; CharGroups--) {
				if (wordSize % CharGroups == 0)
					break;
			}
			int wordSizePrimo = wordSize;
			/* processamento adicional em caso de numero primo de caracteres */
			if (CharGroups == 1) {
				wordSizePrimo--;
				for (CharGroups = 5; CharGroups > 0; CharGroups--) {
					if (wordSizePrimo % CharGroups == 0)
						break;
				}
			}
			/* loop de embaralhamento */
			for (int i = 0; i < wordSizePrimo; i++) {
				embaralhado[i] = this.palavraAtual[i + this.getMatrizEmbaralhamento(wordSize, CharGroups)[i]];
			}
		}

		if (inversao) {
			/* inversao total */
			for (int i = 0; i < this.palavraAtual.length; i++) {
				embaralhado[(this.palavraAtual.length - 1) - i] = this.palavraAtual[i];
			} 
		}
		return embaralhado;
	}
		
	
	private int[] getMatrizEmbaralhamento(int maxSize, int numLetras){
		
		int[][] matrixEmb = new int[5][maxSize];

		if (maxSize > 0 && (numLetras > 0 && numLetras < 6)) {
			for (int t = 0; t < 5; t++) {
				int count = 0;
				for (int i = 0; i < maxSize; i++) {

					if (t == 0)
						matrixEmb[t][i] = i;

					else if (t == 1) {
						if ((i & 1) == 0)
							matrixEmb[t][i] = +1;
						else
							matrixEmb[t][i] = -1;
					}

					else if (t == 2) {
						if (count == 0) {
							matrixEmb[t][i] = 2;
							count++;
						} else if (count == 1) {
							matrixEmb[t][i] = 0;
							count++;
						} else if (count == 2) {
							matrixEmb[t][i] = -2;
							count = 0;
						}
					} else if (t == 3) {
						if (count == 0) {
							matrixEmb[t][i] = 3;
							count++;
						} else if (count == 1) {
							matrixEmb[t][i] = 1;
							count++;
						} else if (count == 2) {
							matrixEmb[t][i] = -1;
							count++;
						} else if (count == 3) {
							matrixEmb[t][i] = -3;
							count = 0;
						}
					} else if (t == 4) {
						if (count == 0) {
							matrixEmb[t][i] = 4;
							count++;
						} else if (count == 1) {
							matrixEmb[t][i] = 2;
							count++;
						} else if (count == 2) {
							matrixEmb[t][i] = 0;
							count++;
						} else if (count == 3) {
							matrixEmb[t][i] = -2;
							count++;
						} else if (count == 4) {
							matrixEmb[t][i] = -4;
							count = 0;
						}
					}
				}
			} 
		}
		return matrixEmb[numLetras -1];
	}
	
	
	
	

	
	/* (non-Javadoc)
	 * @see Embaralhadores#getTracejado()
	 */
	@Override
	public char[] getTracejado(){
		char[] tr = new char[banco.getLastWordSize()];
		
		for (int i = 0; i < tr.length; i++) {
			tr[i] = '_';
		}
		return tr;
	}
	
	/* (non-Javadoc)
	 * @see Embaralhadores#getLastWordSize()
	 */
	@Override
	public int getLastWordSize(){
		return banco.getLastWordSize();
	}
	
	
	/* (non-Javadoc)
	 * @see Embaralhadores#getQuantidadePalavras()
	 */
	@Override
	public int getQuantidadePalavras() {
		return banco.getQuantidadePalavras();
	}
	
	public void debugPrintDataBase(){
		banco.debugPrintDataBase();
	}



}
