package com.example.dao;

import org.bson.Document;
import org.json.JSONArray;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class UserDaoImpl implements UserDao {

	
	MongoClient mongoClient = new MongoClient( "localhost" , 27017 );  
	MongoDatabase db = mongoClient.getDatabase("USER");  
	MongoCollection<Document> collection = db.getCollection("DETAILS"); 
	
	@Override
	public String getUserDetails() {
		JSONArray documents = new JSONArray();
		for (Document doc : collection.find()) {
		    doc.remove("_id");
		    documents.put(doc);
		}
		return documents.toString();
	}

}
