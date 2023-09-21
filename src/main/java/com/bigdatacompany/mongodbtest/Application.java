package com.bigdatacompany.mongodbtest;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Application {
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase infoDB = mongoClient.getDatabase("Info");
        MongoCollection<Document> personalCollection = infoDB.getCollection("Personal");

        BasicDBObject data = new BasicDBObject().append("name", "Furkan")
                .append("date","2000")
                .append("country","Türkiye");

        personalCollection.insertOne(Document.parse(data.toJson()));
    }
}
