package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean fine = true;
		String titolo;
		int giorno;
		int mese;
		int anno;
		int postiT;
		int menu;
		int x;
		boolean fineM;
		int c = 0;
		Evento evento;

		do {
			do {
				
				System.out.println("Inserire nome dell'evento: ");
				if(c==1) {
					s.next();
				}
				titolo = s.nextLine();
				System.out.println("Inserire numero posti totali: ");
				postiT = s.nextInt();
				System.out.println("Inserire data dell' evento: Anno/Mese/Giorno");
				anno = s.nextInt();
				mese = s.nextInt();
				giorno = s.nextInt();
				LocalDate d = LocalDate.of(anno, mese, giorno);
				evento = new Evento(titolo, d, postiT);
				c=1;
			} while (evento != null);

			do {
				System.out.println(
						"1 Quanti posti vuoi prenotare?, 2 Stampa PostiPrenotati e Disponibili, 3 Quanti Posti vuoi disdire? n Fine gestione oggetto");
				menu = s.nextInt();
				switch (menu) {
				case 1:
					x = s.nextInt();
					try {
						System.out.println(evento.prenota(x));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					evento.postiDisponibili();
					break;
				case 3:
					x = s.nextInt();
					try {
						System.out.println(evento.disdici(x));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				default:
				}
				System.out.println("Effettuare altra operazione? n per terminare, invio per continuare");
				if (s.nextLine() == "n") {
					fineM = false;
				} else
					fineM = true;
			} while (fineM == true);
			System.out.println("Terminare programma? s per terminare, invio per continuare");
		} while (s.nextLine() != "s");
		s.close();
	}

}
