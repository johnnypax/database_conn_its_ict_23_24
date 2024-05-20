package com.rubrica.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.MysqlDataSource;

public class ContattoDAL {

	private MysqlDataSource ds;
	
	public ContattoDAL() throws SQLException {
		this.ds = new MysqlDataSource();
		this.ds.setUser("root");
		this.ds.setPassword("toor");
		this.ds.setServerName("localhost");		//127.0.0.1
		this.ds.setPort(3306);
		this.ds.setDatabaseName("lez_recap_03_rubrica");
		this.ds.setUseSSL(false);
		this.ds.setAllowPublicKeyRetrieval(true);
	}
	
	public boolean Insert(Contatto con) throws SQLException{
		Connection conn = this.ds.getConnection();
		boolean risultato = false;
		
		String query = "INSERT INTO Contatto(nome, cognome, mail, telefono) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, con.getNome() );
		ps.setString(2, con.getCogn() );
		ps.setString(3, con.getMail() );
		ps.setString(4, con.getTele() );
		
		int righeCoinvolte = ps.executeUpdate();
		if(righeCoinvolte > 0)
			risultato = true;
		
		conn.close();
		return risultato;
	}
	
	//TODO: Delete
	//TODO: Update
	//TODO: Ricerca tutti
	//TODO: Ricerca puntuale
	
}
