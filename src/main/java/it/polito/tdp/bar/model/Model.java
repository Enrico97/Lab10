package it.polito.tdp.bar.model;

public class Model {
	
	Simulator s = new Simulator();
	
	public void run() {
		s.listaTavoli();
		s.run();
	}
	
	public int clienti () {
		return s.getClienti();
	}

	public int insoddisfatti () {
		return s.getInsoddisfatti();
	}
}
