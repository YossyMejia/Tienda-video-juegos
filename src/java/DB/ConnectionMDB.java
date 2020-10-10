/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import org.bson.Document;
/**
 *

 */
public class ConnectionMDB {
    private MongoClient mongoClient;
    private MongoDatabase database;
    private String base = "tiendagg";
    private MongoCollection<Document> collection;
    
    public ConnectionMDB(String collectionName){
        try{
            MongoClientURI uri = new MongoClientURI(
            "mongodb+srv://Yochi:Zorropelon88@clusteryochi.j2avc.mongodb.net/<tiendagg>?retryWrites=true&w=majority");
            mongoClient = new MongoClient(uri);
            database = mongoClient.getDatabase(base);
            collection = database.getCollection(collectionName);
        }
        catch(Exception e){
            System.out.println("ERROR"+e);
        }
    }
    
    public void test(){
        MongoCollection<Document> collection = database.getCollection("imagenes");
        FindIterable<Document> iterDoc = collection.find();
        Iterator it = iterDoc.iterator();
        while (it.hasNext()) {
           System.out.println(it.next());
        }
    }

    public MongoCollection<Document> getCollection() {
        return collection;
    }

    public void setCollection(MongoCollection<Document> collection) {
        this.collection = collection;
    }

    
    
    
}
