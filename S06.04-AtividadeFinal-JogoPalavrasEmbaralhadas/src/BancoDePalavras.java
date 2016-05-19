import java.io.File;
import java.io.FileReader;
// import java.io.FileWriter;
import java.io.IOException;

import java.util.Random;


/**
 * Classe BancoDePalavras tem m�todos que criam uma subpasta a partir da pasta de projeto,  
 * e nela criam um arquivo de dicion�rio no formato .CSV. 
 * 
 * O arquivo de dicion�rio por ser criado no Excel respeitando-se somente o cabe�alho.
 * No qual dever�o conter a primeira linha com cada letra do alfabeto ingl�s a at� z
 * As colunas dever�o receber somente palavras come�adas com a respectiva letra da coluna
 * 
 * @author vpanarello
 *
 */
public class BancoDePalavras{

	private String dictFileName;
	private String dictFolder;

	/* esses atributos acululam a dimens�o do arquivo .CSV */
	private int dataBaseColumns;
	private int dataBaseRows;
	
	private int lastWordSize;

	private String[][] palavras;
	
	private Random random;

	/* CONSTRUTOR DE CLASSE */

	public BancoDePalavras(String dictFileName, String dictFolder) throws IOException {
		super();
		this.dictFileName = dictFileName;
		this.dictFolder = dictFolder;

		this.preparaArquivo(new File(this.dictFolder));

		random = new Random();
		
		File arquivo = new File(this.dictFolder + "/" + this.dictFileName);

		/* Verifica se e um arquivo valido atraves do cabecalho, gera Excecao caso contrario
		 * Determina tamanho do arquivo CSV para reservar esta�o apra o Array*/

		if( ! this.verificaArquivo(arquivo))
			throw new BancoPalavrasExceptions("Arquivo '"+ dictFileName + "' n�o � um arquivo v�lido");


		/* aloca espaco em Array com a quantidade de palavras do arquivo .CSV */
		palavras = new String[this.dataBaseRows][this.dataBaseColumns];

		/* L� todo o conte�do do arquivo CSV e armazena na array passada respeitando estrutura (linha,coluna) */
		this.abreArquivoCSV(new FileReader(arquivo),palavras);
	}


	/* INICIO DOS M�TODOS DE CLASSE */

	private void preparaArquivo(File arquivo) throws IOException{

		if(!arquivo.isDirectory()){
			if(!arquivo.mkdir())
				throw new BancoPalavrasExceptions("diret�rio '" +this.dictFolder+ "' n�o pode ser criado");
		}

		arquivo = new File(dictFolder + "/" + dictFileName);


		if(!arquivo.canRead()){
			if(!arquivo.createNewFile())
				throw new BancoPalavrasExceptions("Arquivo '" +this.dictFileName+ "' dicion�rio n�o pode ser lido/criado"); 				 
		} 
	}

	/* Faz leitura do n�mero de linhas/colunas do .CSV, e verifica cabe�alho retorna TRUE se o arquivo tem o cabe�alho esperado */
	private boolean verificaArquivo(File csvFile) throws IOException {

		FileReader dataBase = new FileReader(csvFile);
		String firstRow = "";

		this.dataBaseColumns = this.dataBaseRows = 0;
		while(dataBase.ready()){
			char c = (char)dataBase.read();
			if(c == '\r') break;
			else {
				if(c != ';'){
					firstRow = firstRow + c;
					this.dataBaseColumns++; 
				}
			}
		}
		dataBase.close();
		dataBase = new FileReader(csvFile);

		/* Detecta numero de linhas do .CSV */

		while(dataBase.ready()){
			char c = (char)dataBase.read();
			if(c == '\r') dataBaseRows++;
		}

		dataBase.close();

		if(firstRow.equals("abcdefghijklmnopqrstuvwxyz")) return true;
		else return false;

	}

	/* inicia leitura do arquivo .CSV e faz alocacao dos valores no Array */
	private void abreArquivoCSV(FileReader dataBase, String[][] dataBaseArray) throws IOException{

		String swapString = "";

		int column = -1;
		int row = 0;

		char c = '\0';

		while(dataBase.ready()){ 
			if(!swapString.equals("")) dataBaseArray[row][column] = swapString;
			swapString = "";

			if (c == '\r' || c == '\n'){
				column = -1;
				if (c == '\n') row++;
			}

			while(true){
				c = (char)dataBase.read();
				if (!dataBase.ready() || c == '\r' || c == '\n' || c == ';'){
					column++;
					break;
				}
				swapString = swapString + c;
			}
		}
		dataBase.close(); 
	}


	public int getDataBaseColumns() {
		return dataBaseColumns;
	}


	public int getDataBaseRows() {
		return dataBaseRows;
	}


	public String[][] getPalavras() {
		return palavras;
	}
	
	public String getPalavra() {
		int randomColumn = random.nextInt(palavras[0].length);
		int i;
		for (i = 0; ((palavras[i][randomColumn] != null) && (i < this.dataBaseRows - 1)); i++);
		int randomRow = random.nextInt(i - 1) + 1;
		this.lastWordSize = palavras[randomRow][randomColumn].length();
		return palavras[randomRow][randomColumn];
	}
	public String getPalavra(String beginWith){
		if(beginWith.length() == 1){
			int randomColumn;
			for(randomColumn = 0; ! palavras[0][randomColumn].equals(beginWith.toLowerCase()); randomColumn++);
			int i; 
			for (i = 0; ((palavras[i][randomColumn] != null) && (i < this.dataBaseRows - 1)); i++);
			int randomRow = random.nextInt(i - 1) + 1;
			this.lastWordSize = palavras[randomRow][randomColumn].length();
			return palavras[randomRow][randomColumn];
		}
		return "";
	}
	public int getLastWordSize() {
		return lastWordSize;
	}
	
	public int getQuantidadePalavras(){
		int value = 0;


		for (int row = 1; row < this.getDataBaseRows(); row++){
			for(int column = 0; column < this.getDataBaseColumns(); column++ ){
				if(this.getPalavras()[row][column] != null) value++;
			}
		}	
		return value;
	}
	
	public void debugPrintDataBase(){
		for(String[] var1 : palavras){
			for(String var2 : var1){
				System.out.format("%s ",var2.toUpperCase());				
			}
			System.out.println("");
		}
		
		
		
	}





}
	
		
	

		
		 
	
