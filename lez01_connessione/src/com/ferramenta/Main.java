package com.ferramenta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ferramenta.classes.Prodotto;
import com.mysql.cj.jdbc.MysqlDataSource;

public class Main {

	public static void main(String[] args) {

		// INSERIMENTO
//		try {
//			MysqlDataSource ds = new MysqlDataSource();
//			ds.setUser("root");
//			ds.setPassword("toor");
//			ds.setServerName("localhost");		//127.0.0.1
//			ds.setPort(3306);
//			ds.setDatabaseName("lez_recap_01_ferramenta");
//			ds.setUseSSL(false);
//			ds.setAllowPublicKeyRetrieval(true);
//			
//			Connection conn = ds.getConnection();
//			
//			Prodotto pro = new Prodotto("Trapano", "Di Trapani", "Bricolage", 150.0f, 12);
//			
//			String query = "INSERT INTO Prodotto(nome, descrizione, categoria, prezzo, quantita) VALUES	(?, ?, ?, ?, ?)";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, pro.getNome() );
//			ps.setString(2, pro.getDesc() );
//			ps.setString(3, pro.getCate() );
//			ps.setFloat(4, pro.getPrez() );
//			ps.setInt(5, pro.getQuan());
//
//			int affRows = ps.executeUpdate();
//			
//			if(affRows > 0)
//				System.out.println("STAPPOOOOOOOOO");
//			else
//				System.out.println("Inserimento non riuscito");
//			
//			conn.close();
//			
//		} catch (SQLException ex) {
//			System.out.println("ERRORE: " + ex.getMessage());
//		}
		
		//ELIMINAZIONE
//		int idDaEliminare = 5;
//		
//		try {
//			MysqlDataSource ds = new MysqlDataSource();
//			ds.setUser("root");
//			ds.setPassword("toor");
//			ds.setServerName("localhost");		//127.0.0.1
//			ds.setPort(3306);
//			ds.setDatabaseName("lez_recap_01_ferramenta");
//			ds.setUseSSL(false);
//			ds.setAllowPublicKeyRetrieval(true);
//			
//			Connection conn = ds.getConnection();
//			
//			String query = "DELETE FROM Prodotto WHERE prodottoID = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setInt(1, idDaEliminare);
//			
//			int affRows = ps.executeUpdate();
//			if(affRows > 0)
//				System.out.println("STAPPOSTO");
//			else
//				System.out.println("Errore, eliminazione non riuscita");
//			
//			conn.close();
//			
//		} catch (SQLException ex) {
//			System.out.println("ERRORE: " + ex.getMessage());
//		}
		

		//UPDATE
//		try {
//			MysqlDataSource ds = new MysqlDataSource();
//			ds.setUser("root");
//			ds.setPassword("toor");
//			ds.setServerName("localhost");		//127.0.0.1
//			ds.setPort(3306);
//			ds.setDatabaseName("lez_recap_01_ferramenta");
//			ds.setUseSSL(false);
//			ds.setAllowPublicKeyRetrieval(true);
//			
//			Connection conn = ds.getConnection();
//			
//			String query = "UPDATE Prodotto SET "
//					+ "nome = ?, "
//					+ "descrizione = ?, "
//					+ "categoria = ?, "
//					+ "prezzo = ?, "
//					+ "quantita = ? "
//					+ "WHERE prodottoID = ?";
//			PreparedStatement ps = conn.prepareStatement(query);
//			ps.setString(1, "Barattolo");
//			ps.setString(2, "Vernicioso");
//			ps.setString(3, "Bricolage");
//			ps.setFloat(4, 15.0f);
//			ps.setInt(5, 12);
//			ps.setInt(6, 3);				//ProdottoID
//			
//			int affRows = ps.executeUpdate();
//			if(affRows > 0)
//				System.out.println("STAPPOSTO");
//			else
//				System.out.println("Errore, modifica non riuscita");
//			
//			conn.close();
//			
//		} catch (SQLException ex) {
//			System.out.println("ERRORE: " + ex.getMessage());
//		}
		
		//GET ALL
//		try {
//			MysqlDataSource ds = new MysqlDataSource();
//			ds.setUser("root");
//			ds.setPassword("toor");
//			ds.setServerName("localhost");		//127.0.0.1
//			ds.setPort(3306);
//			ds.setDatabaseName("lez_recap_01_ferramenta");
//			ds.setUseSSL(false);
//			ds.setAllowPublicKeyRetrieval(true);
//			
//			Connection conn = ds.getConnection();
//			
//			String query = "SELECT prodottoID, nome, descrizione, categoria, prezzo, quantita FROM Prodotto";
//			PreparedStatement ps = conn.prepareStatement(query);
//			
//			ResultSet rs = ps.executeQuery();
//			
//			while(rs.next()) {
//				Prodotto temp = new Prodotto();
//				temp.setId( rs.getInt("prodottoID") );
//				temp.setNome( rs.getString("nome") );
//				temp.setDesc( rs.getString("descrizione") );
//				temp.setCate( rs.getString("categoria") );
//				temp.setPrez( rs.getFloat("prezzo") );
//				temp.setQuan( rs.getInt("quantita") );
//				
//				System.out.println(temp);
//			}
//			
//			conn.close();
//			
//		} catch (SQLException ex) {
//			System.out.println("ERRORE: " + ex.getMessage());
//		}
		
		//GET BY ID
		int idDaCercare = 3;
		
		try {
			MysqlDataSource ds = new MysqlDataSource();
			ds.setUser("root");
			ds.setPassword("toor");
			ds.setServerName("localhost");		//127.0.0.1
			ds.setPort(3306);
			ds.setDatabaseName("lez_recap_01_ferramenta");
			ds.setUseSSL(false);
			ds.setAllowPublicKeyRetrieval(true);
			
			Connection conn = ds.getConnection();
			
			String query = "SELECT prodottoID, nome, descrizione, categoria, prezzo, quantita FROM Prodotto WHERE prodottoID = ?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, idDaCercare);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				Prodotto temp = new Prodotto();
				temp.setId( rs.getInt("prodottoID") );
				temp.setNome( rs.getString("nome") );
				temp.setDesc( rs.getString("descrizione") );
				temp.setCate( rs.getString("categoria") );
				temp.setPrez( rs.getFloat("prezzo") );
				temp.setQuan( rs.getInt("quantita") );
				
				System.out.println(temp);
			} else {
				System.out.println("Prodotto non trovato");
			}
			
			
			conn.close();
			
		} catch (SQLException ex) {
			System.out.println("ERRORE: " + ex.getMessage());
		}
		
		
		
		
	}

}
