import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

public class test {
	
	Embaralhadores em;
	
	
	/*   Sistema de embaralhamento completamente Randomico, Impossível utilização de AssertEquals nos teste.*/
	@Test
	public void testeEmbaralhadores() throws IOException{
		
		em = new FabricaEmbaralhadores("dict.csv", "dict");
		
		for(char i :em.getPalavraEmbaralhada(1,"a")){
			System.out.format("%s ", i);
		}
		
		System.out.println("");
		System.out.println("");
		
		for(char i :em.getPalavraAtual()){
			System.out.format("%s ", i);
		}
		
		System.out.println(" ");
	}
}
