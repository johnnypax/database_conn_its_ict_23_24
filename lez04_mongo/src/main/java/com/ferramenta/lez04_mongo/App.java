package com.ferramenta.lez04_mongo;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
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
        	
        	MongoDatabase database = connection.getDatabase("ferramenta");
        	MongoCollection<Document> coll_oggetti = database.getCollection("oggetti");
        	
//        	Document vite = new Document();					//{}
//        	vite.append("nome", "Vite a stella");			//{"nome": "Vite a stella"}
//        	vite.append("codice", "VT123");
//        	vite.append("quantita", 582);
//        	vite.append("prezzo", 0.52);
//        	
//        	coll_oggetti.insertOne(vite);
        	
        	MongoCursor<Document> elencoRis = coll_oggetti.find().iterator();
        	
        	while(elencoRis.hasNext()) {
        		System.out.println(elencoRis.next().toJson());
        	}
        	
        	connection.close();
        	
        	System.out.println("STAPPOOOOOOOOOOOOO");
    	} catch (Exception e) {
			System.out.println("Errore: " + e.getMessage());
		}
    
    }
}
