package com.rubrica.classes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.jdbc.MysqlDataSource;
import com.mysql.cj.x.protobuf.MysqlxPrepare.Prepare;

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
	
	public boolean insert(Contatto con) throws SQLException{
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
	
	public boolean delete(int idDaElim) throws SQLException{
		boolean risultato = false;
		Connection conn = this.ds.getConnection();
		
		String query = "DELETE FROM Contatto WHERE contattoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, idDaElim);
		
		int righeCoinvolte = ps.executeUpdate();
		if(righeCoinvolte > 0)
			risultato = true;
		
		conn.close();
		return risultato;
	}
	
	public ArrayList<Contatto> findAll() throws SQLException{
		ArrayList<Contatto> risultato = new ArrayList<Contatto>();			//[]
		Connection conn = this.ds.getConnection();
		
		String query = "SELECT contattoID, nome, cognome, mail, telefono FROM Contatto";
		PreparedStatement ps = conn.prepareStatement(query);
				
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			Contatto temp = new Contatto();
			temp.setId( rs.getInt("contattoID") );
			temp.setNome( rs.getString("nome") );
			temp.setCogn( rs.getString("cognome") );
			temp.setMail( rs.getString("mail") );
			temp.setTele( rs.getString("telefono") );
			
			risultato.add(temp);
		}
		
		conn.close();
		return risultato;
	}
	
	public Contatto findById(int idDaCercare) throws SQLException{
		Contatto risultato = null;
		Connection conn = this.ds.getConnection();
		
		String query = "SELECT contattoID, nome, cognome, mail, telefono FROM Contatto WHERE contattoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setInt(1, idDaCercare);
		
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			risultato = new Contatto();
			risultato.setId( rs.getInt("contattoID") );
			risultato.setNome( rs.getString("nome") );
			risultato.setCogn( rs.getString("cognome") );
			risultato.setMail( rs.getString("mail") );
			risultato.setTele( rs.getString("telefono") );
		}		
		
		conn.close();
		return risultato;
	}

	public boolean update(Contatto obj)  throws SQLException{
		boolean risultato = false;
		Connection conn = this.ds.getConnection();
		
		String query = "UPDATE Contatto SET "
				+ "nome = ?, "
				+ "cognome = ?, "
				+ "mail = ?, "
				+ "telefono = ? "
				+ "WHERE contattoID = ?";
		PreparedStatement ps = conn.prepareStatement(query);
		ps.setString(1, obj.getNome() );
		ps.setString(2, obj.getCogn() );
		ps.setString(3, obj.getMail() );
		ps.setString(4, obj.getTele() );
		ps.setInt(5, obj.getId() );
		
		int righeCoinvolte = ps.executeUpdate();
		
		if(righeCoinvolte > 0)
			risultato = true;	
		
		conn.close();
		return risultato;
	}
	
}
