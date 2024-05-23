package com.libreria.lez05_morphia;

import org.bson.Document;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.libreria.lez05_morphia.models.Libro;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

    	try {
    		MongoClientURI dataSource = new MongoClientURI("mongodb://localhost:27017");

	    	MongoClient connection = new MongoClient(dataSource);
	    	
	    	Morphia morphia = new Morphia();
	    	morphia.mapPackage("com.libreria.lez05_morphia.models");
	    	
	    	Datastore database = morphia.createDatastore(connection, "Libreria_Lello");
	    	database.ensureIndexes();
	    	
	    	Libro hp_uno = new Libro("123456", "Harry Potter e la p. f.", "Boh", "Federico");
	    	Libro il_sig = new Libro("123457", "IL signore degli anelli", "Non lo so", "Francesco");
	    	
	    	database.save(hp_uno);
	    	database.save(il_sig);
	    	
	    	connection.close();
	    	
	    	System.out.println("STAPPOOOOOOOOOO");
    	} catch (Exception e) {
			System.out.println("ERRORE: " + e.getMessage());
		}
    	
    	
    }
}
