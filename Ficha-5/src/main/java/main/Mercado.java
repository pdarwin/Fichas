package main;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
	List<Pessoa> listaPessoas;

	public Mercado() {
		super();
		listaPessoas = new ArrayList<>();
	}
	
	public void addPessoa(Pessoa a) {
		listaPessoas.add(a);
	}
}
