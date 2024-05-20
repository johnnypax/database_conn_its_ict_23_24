package com.rubrica;

import java.sql.SQLException;

import com.rubrica.classes.Contatto;
import com.rubrica.classes.ContattoDAL;

public class Main {

	public static void main(String[] args) {

		Contatto uno = new Contatto("Mario", "Rossi", "mar@ros.com", "1236");
		Contatto due = new Contatto("Marika", "Mariko", "mar@iko.com", "1237");
		
		try {
			ContattoDAL condal = new ContattoDAL();
			if(condal.Insert(due)) {
				System.out.println("STAPPOOOOOOOO");
			}
			else {
				System.out.println("ERRORE DI INSERIMENTO");
			}
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
	}

}
