package org.generation.italy.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String titolo;
		int giorno;
		int mese;
		int anno;
		int postiT;
		int menu;
		int x;
		ArrayList<Evento> eventi = new ArrayList<Evento>(); 
		int g;
		int c = 0;
		ArrayList <String> risultato = new ArrayList<String>();
		Evento evento;

		do {
			do {
				System.out.println("Inserire nome dell'evento: ");
				if (c == 1) {
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
				c = 1;
				eventi.add(evento);
			} while (evento.getTitolo() == null);
		
			risultato=ProgrammEventi.ordinaLista(eventi);
			
			
			for(String e : risultato) {
			System.out.println(e);
			}
			
			
			
			do {
				System.out.println(
						"1 Quanti posti vuoi prenotare?, 2 Stampa PostiPrenotati e Disponibili, 3 Quanti Posti vuoi disdire? numero Fine gestione oggetto");
				menu = s.nextInt();
				switch (menu) {
				case 1:
					System.out.println("quanti posti?");
					x = s.nextInt();
					try {
						System.out.println(evento.prenota(x));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
					break;
				case 2:
					System.out.println("i posti disponibili sono: ");
					System.out.println(evento.postiDisponibili());
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
			} while (menu == 1 || menu==2 || menu==3);
			System.out.println("Terminare programma? 1 per terminare, altro per aggiungere un nuovo oggetto");
			g = s.nextInt();
		} while (!(g==1));
		s.close();
		System.out.println("Programma Terminato");
	}

}
