package org.generation.italy.eventi;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.util.Calendar;

public class Evento {
	private String titolo;
	private LocalDate d;
	private int postiT;
	private int postiP;

	public Evento(String titolo, LocalDate d, int postiT) {
		try {
		this.titolo = titolo;
		this.d = d;
		this.postiT = postiT;
		this.postiP = 0;
			verificaData();
			verificaP();
			verificaPP();
			verificaPT();
		} catch (Exception e) {
			System.out.println("impossibile creare oggetto");
			System.out.println(e.getMessage());
		}
	}

	public Evento() {

	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public LocalDate getD() {
		return d;
	}

	public void setD(LocalDate d) {
		this.d = d;
	}

	public int getPostiT() {
		return postiT;
	}

	public int getPostiP() {
		return postiP;
	}

	private void verificaData() throws Exception {
		Calendar calendar = Calendar.getInstance();
		calendar.getTime();
		if (d.isBefore(LocalDate.now())) {
			throw new Exception("l'evento è gia passato");
		}
	}

	public String prenota(int x) throws Exception {
		if (postiP >= postiT) {
			throw new Exception("Tutti i Posti sono gia prenotati");
		}
		postiP = postiP + x;
		return "Operazione completata";
	}

	public String disdici(int x) throws Exception {
		if (postiP <= 0) {
			throw new Exception("Non ci sono Posti prenotati");
		}
		postiP = postiP - x;
		return "Operazione completata";
	}

	@Override
	public String toString() {
		return d + " - " + titolo;
	}

	private void verificaP() throws Exception {
		if (postiP > postiT)
			throw new Exception("I posti prenotati sono maggiori dei posti totali");
	}

	public void verificaPT() throws Exception {
		if (postiP <= 0)
			throw new Exception("I posti Prenotati devono essere maggiori o uguali a 0");
	}

	public void verificaPP() throws Exception {
		if (postiT < 0)
			throw new Exception("I posti totali devono essere maggiori di 0");
	}

	public int postiDisponibili() {
		return postiT - postiP;
	}
}
