package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ProgrammEventi {
	private String titolo;
	private ArrayList<Evento> eventi;

	public ProgrammEventi(String Titolo) {
		ArrayList<String> eventi = new ArrayList();
		this.titolo = titolo;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public ArrayList<Evento> getEventi() {
		return eventi;
	}

	public void setEventi(ArrayList<Evento> eventi) {
		this.eventi = eventi;
	}

	public void addEventi(Evento eventi) {
		this.eventi.add(eventi);
	}

	public ArrayList<Evento> eventoData(LocalDate data) {
		ArrayList<Evento> eData = new ArrayList<Evento>();

		for (Evento s : eventi) {
			if (s.getD().isEqual(data)) {
			}
		}
		return eData;
	}

	public int numeroEventi() {
		return eventi.size();
	}

	public String clearEventi() {
		eventi.clear();
		return "operazione completata";
	}
	
	
	public static ArrayList<String> ordinaLista(ArrayList<Evento> eventi){
		ArrayList<String> lista = new ArrayList<String>();
		Collections.sort(eventi, new Ordina());
		for(Evento s : eventi) {
			lista.add(s.getD().toString()+" "+s.getTitolo());
		}
		return lista;
	}
}