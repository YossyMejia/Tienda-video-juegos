/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.Iterator;
import java.util.List;
import org.bson.Document;
/**
 *

 */
public class ConnectionMDB {
    private Mongo mongoClient;
    
    public ConnectionMDB(){
        try{
            
            mongoClient = new Mongo("LocalHost",27017);
            
        }
        catch(Exception e){
            System.out.println("ERROR"+e);
        }
    }
    
    

    public Mongo getMongoClient() {
        return mongoClient;
    }

    
    
}
