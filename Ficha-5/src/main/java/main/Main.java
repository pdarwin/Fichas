package main;

import java.util.ArrayList;

public class Main {
	public static void main(String [] args) {
		LoadFromFile aux = new LoadFromFile();
		
		ArrayList <Pessoa> listaPessoas = aux.obterInformacaoFicheiro("pessoas.json");
		
		for(Pessoa a : listaPessoas) {
			System.out.println(a);
		}
	}
}
