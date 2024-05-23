package com.libreria.lez05_morphia.models;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

@Entity
public class Libro {


	@Id
	private ObjectId id;
	@Property
	private String isbn;	
	@Property
	private String titolo;
	@Property
	private String descrizione;	
	@Property
	private String autore;
	
	public Libro() {
		
	}
	
	public Libro(String isbn, String titolo, String descrizione, String autore) {
		super();
		this.isbn = isbn;
		this.titolo = titolo;
		this.descrizione = descrizione;
		this.autore = autore;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}

	@Override
	public String toString() {
		return "Libro [isbn=" + isbn + ", titolo=" + titolo + ", descrizione=" + descrizione + ", autore=" + autore
				+ "]";
	}
	
	
	
}
