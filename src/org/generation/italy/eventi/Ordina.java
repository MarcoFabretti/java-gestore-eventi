package org.generation.italy.eventi;
import java.util.Comparator;

public class Ordina implements Comparator<Evento>{

	public int compare(Evento e1, Evento e2) {
		if (e1.getD().compareTo(e2.getD()) < 0) {
			return -1;
		} else if (e1.getD().compareTo(e2.getD()) > 0) {
			return 1;
		}
		return 0;
	}

}
