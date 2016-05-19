
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;


public class Principal {
	
	static String DictFile = "dict.csv";
	static String DictDir = "dict";
	
	static MecanicaDoJogo game; // MODIFICAR PARA MECANICADOJOGO

	public static void main(String[] args) throws IOException {
		
		game = new FabricaMecanicaDoJogo(DictFile, DictDir);
		
		System.out.format("-----------------------------------------------------------------%n");
		System.out.format("         BEM-VINDO AO JOGO DE PALAVRAS EMBARALHADAS e FORCA      %n");
		System.out.format("-----------------------------------------------------------------%n");
		System.out.format("          O dicionário carregado conta com %d palavras           %n", game.getQuantidadePalavras());
		System.out.format("              Mais palavras podem ser adicionadas                %n");
		System.out.format("               editando-se o  arquivo '.%s/%s'                   %n", DictDir,DictFile);
		System.out.format("-----------------------------------------------------------------%n");
		System.out.format("\n\n\n","");
		
		BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
		
		
		MenuSelecao m = new MenuSelecao();
		
		itemMenu[] ref01 = new itemMenu[3];
		String[] str01 = {"Aleatória do dicionário", "Começada com a letra"};
		ref01[0] = ref01[1] = ref01[2] = m.addSubMenu(new itemMenu("Embaralhadas - Palavra do tipo?", str01),3);
		
		itemMenu[] ref02 = new itemMenu[2];
		String[] str02 = {"Fácil","Médio", "Complicado"};
		ref02[0] = m.addSubMenu(new itemMenu("Embaralhadas - Quão bom você é?", str02, ref01),2);
		
		
		String[] str03 = {"Aleatória do dicionário", "Começada com a letra"};
		ref02[1] = m.addSubMenu(new itemMenu("Jogo Forca - Palavra do tipo?", str03),2);
	
		String[] str04 = {"Palavras Embaralhadas", "Jogo da Forca"};
		m.addSubMenu(new itemMenu("Qual jogo você quer?", str04, ref02),1);
		
		Scanner stdin02 = new Scanner(System.in);
		
		while (m.isSelecting()){
			System.out.println(m.printHeaderLine());
			System.out.println(m.printHeader());
			System.out.println(m.printHeaderLine());
			System.out.println(m.printMenu());
			
			m.doMenuSelection(stdin02.nextInt());
			
		}
		
		/*for(int i = 0; i < m.getObjSequenceList().length; i++){
			System.out.print( m.getObjSequenceList()[i].getSelectedValue());
			System.out.print(" ");
			System.out.print(i);
			System.out.print(" ");
			System.out.println( m.getObjSequenceList()[i].getTitle() );	
		} */

		System.out.format("\n\n","");
		
		
		if (m.getObjSequenceList()[3].getSelectedValue() == 2) {
			if (m.getObjSequenceList()[2].getSelectedValue() == 2) {
				System.out.print("Digite a letra para começar: ");
				String comecadaCom = stdin.readLine();
				System.out.print("\n\n");
				System.out.println(game.playForca(10,comecadaCom));
			}
			else System.out.println(game.playForca(10));
			while (game.isPlayingForca()) {
				String value = stdin.readLine();
				game.jogadaForca(value, false);
				System.out.println(game.printForca());
			}
			System.out.println(game.pritForcaEndOfGame());
		}
		else if (m.getObjSequenceList()[3].getSelectedValue() == 1) {
			
			
			if(m.getObjSequenceList()[0].getSelectedValue() == 2){
				System.out.print("Digite a letra para começar: ");
				String comecadaCom = stdin.readLine();
				System.out.println(game.playPalavrasEmbaralhadas(m.getObjSequenceList()[1].getSelectedValue(),5, comecadaCom)); // 1: inv 2: emb 3: emb&inv
			}
			else{
				System.out.println(game.playPalavrasEmbaralhadas(m.getObjSequenceList()[1].getSelectedValue(),5)); // 1: inv 2: emb 3: emb&inv
			}
			
			
			
			while (game.isPlayingPE()) {
				
				String value = stdin.readLine();
				game.jogadaPE(value);
				System.out.println(game.printPE());
			}
			System.out.println(game.printEndOfGamePE());
		}
			
		stdin02.close();
		
		System.out.format("-----------------------------------------------------------------%n");
		System.out.format("                FIM DE JOGO / OBRIGADO POR JOGAR                 %n");
		System.out.format("-----------------------------------------------------------------%n");
		}
	}
