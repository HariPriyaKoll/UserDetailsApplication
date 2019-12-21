package com.example.dao;

import org.bson.Document;
import org.json.JSONArray;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class UserDaoImpl implements UserDao {

	
	MongoClient mongoClient = new MongoClient( "mongo1-156824810.us-east-2.elb.amazonaws.com" , 27017 );  
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
