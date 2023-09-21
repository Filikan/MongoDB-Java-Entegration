package com.bigdatacompany.mongodbtest;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase infoDB = mongoClient.getDatabase("Info");
        MongoCollection<Document> personalCollection = infoDB.getCollection("Personal");

        BasicDBObject data = new BasicDBObject().append("name", "Furkan")
                .append("date","2000")
                .append("country","Türkiye");

        BasicDBObject data2 = new BasicDBObject().append("name", "Mahmut")
                .append("date","1993")
                .append("country","Türkiye");

        /*Document parse = Document.parse(data.toJson());
        Document parse2 = Document.parse(data2.toJson());

        personalCollection.insertMany(Arrays.asList(parse,parse2));*/

        FindIterable<Document> documents = personalCollection.find();

        for (Document doc:documents){
            System.out.println(doc.toJson());
        }
    }
}
