package com.rubrica;

import java.sql.SQLException;
import java.util.ArrayList;

import com.rubrica.classes.Contatto;
import com.rubrica.classes.ContattoDAL;

public class Main {

	public static void main(String[] args) {

//		Contatto uno = new Contatto("Mario", "Rossi", "mar@ros.com", "1236");
//		Contatto due = new Contatto("Marika", "Mariko", "mar@iko.com", "1237");
//		
//		try {
//			ContattoDAL condal = new ContattoDAL();
//			if(condal.Insert(due)) {
//				System.out.println("STAPPOOOOOOOO");
//			}
//			else {
//				System.out.println("ERRORE DI INSERIMENTO");
//			}
//		} catch (SQLException e) {
//			System.out.println("Errore: " + e.getMessage());
//		}
		
		//ELIMINAZIONE
//		int daElim = 3;
//		
//		try {
//			ContattoDAL condal = new ContattoDAL();
//			if(condal.Delete(daElim)) {
//				System.out.println("STAPPOOOOOOOO");
//			}
//			else {
//				System.out.println("ERRORE DI ELIMINAZIONE");
//			}	
//		} catch (SQLException e) {
//			System.out.println("Errore: " + e.getMessage());
//		}
		
		//CERCA TUTTI
//		try {
//			ContattoDAL conDal = new ContattoDAL();
//			
//			ArrayList<Contatto> elenco = conDal.findAll();
//			for(int i=0; i<elenco.size(); i++) {
//				System.out.println( elenco.get(i) );
//			}
//		} catch (SQLException e) {
//			System.out.println("Errore: " + e.getMessage());
//		}
		
		//CERCA SINGOLO
//		int idCerca = 22;
//		
//		try {
//			ContattoDAL conDal = new ContattoDAL();
//			
//			Contatto risultato = conDal.findById(idCerca);
//			
//			if(risultato != null) {
//				System.out.println(risultato);
//			}
//			else {
//				System.out.println("Oggetto non trovato");
//			}
//			
//		} catch (SQLException e) {
//			System.out.println("Errore: " + e.getMessage());
//		}
//		
		//MODIFICA
		
		try {
			ContattoDAL conDal = new ContattoDAL();
			
			Contatto uno = conDal.findById(1);
			uno.setNome("Giovannotto");
			uno.setTele("88888");
			
			if(conDal.update(uno))
				System.out.println("STAPPPOOOOOOOOOO");
			else
				System.out.println("Errore di modifica");
			
		} catch (SQLException e) {
			System.out.println("Errore: " + e.getMessage());
		}
		
		
		
	}

}
