package com.inserimento;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import com.inserimento.classes.Contatto;
import com.inserimento.classes.ContattoDAL;

public class Main {

	public static void main(String[] args) {

		//RECAP
//		Scanner interceptor = new Scanner(System.in);
//		
//		System.out.println("Inserisci il tuo nome");
//		String nome = interceptor.nextLine();
//		System.out.println("Ciao: " + nome);
		
		//I - Inserimento, S - Stampa, Q - Uscire dal programma
		Scanner interceptor = new Scanner(System.in);
		
		boolean insAbilitato = true;
		
		while(insAbilitato) {
			System.out.println("\nScegli l'operazione: \n"
					+ "I - Inserimento\n"
					+ "S - Stampa\n"
					+ "Q - Uscire dal programma");
			
			String input = interceptor.nextLine();
			
			switch (input) {
			case "I":

				System.out.println("Dammi il nome");
				String nome = interceptor.nextLine();
				System.out.println("Dammi il cognome");
				String cognome = interceptor.nextLine();
				System.out.println("Dammi il telefono");
				String telefono = interceptor.nextLine();
				System.out.println("Dammi la mail");
				String mail = interceptor.nextLine();
				
				Contatto temp = new Contatto(nome, cognome, telefono, mail);
				try {
					ContattoDAL conDalIns = new ContattoDAL();
					if(conDalIns.insert(temp))
						System.out.println("Inserimento completato");
					else
						System.out.println("Errore di inserimento");
				} catch (SQLException e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				break;
			case "S":
				try {
					ContattoDAL conDal = new ContattoDAL();
					ArrayList<Contatto> elenco = conDal.findAll();
					
					for(int i=0; i<elenco.size(); i++) {
						System.out.println(elenco.get(i));
					}
					
				} catch (SQLException e) {
					System.out.println("ERRORE: " + e.getMessage());
				}
				
				break;
			case "Q":
				insAbilitato = false;
				break;
			default:
				System.out.println("Comando non riconosciuto");
				break;
			}
		}
		
		System.out.println("Programma terminato");
		
	}

}
