package com.bigdatacompany.mongodbtest;

import com.mongodb.BasicDBObject;
import com.mongodb.ConnectionString;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017");
        MongoClient mongoClient = MongoClients.create(connectionString);
        MongoDatabase infoDB = mongoClient.getDatabase("Info");
        MongoCollection<Document> personalCollection = infoDB.getCollection("Personal");

        BasicDBObject data = new BasicDBObject().append("name", "Cem")
                .append("date","1990")
                .append("country","Germany");

        BasicDBObject data2 = new BasicDBObject().append("name", "Elon")
                .append("date",2001)
                .append("country","Türkiye")
                .append("job","student"); //you can add extra field, because it's unstructured.

        /*Document parse = Document.parse(data.toJson());
        Document parse2 = Document.parse(data2.toJson());

        personalCollection.insertMany(Arrays.asList(parse,parse2));*/

        /*FindIterable<Document> documents = personalCollection.find(new BasicDBObject("date","1993"));

        for (Document doc:documents){
            System.out.println(doc.toJson());
        }*/

        /*Bson filter = Filters.exists("job");
        Bson update = Updates.set("child", "Ahmet");
        personalCollection.updateOne(filter,update);*/

        Bson deleteFilter = Filters.eq("name", "Cem");
        personalCollection.deleteOne(deleteFilter);

        FindIterable<Document> documents = personalCollection.find();

        for (Document doc:documents){
            System.out.println(doc.toJson());
        }
    }
}
