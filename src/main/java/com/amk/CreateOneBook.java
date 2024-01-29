package com.amk;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Arrays;
import java.util.List;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class CreateOneBook {
	private static final String url="mongodb://localhost";
	public static void main(String[] args) {
		ConnectionString connString = new ConnectionString(url);
		CodecRegistry pojoCodecRegistry = fromProviders(
				PojoCodecProvider.builder().automatic(true).build());
		CodecRegistry codecRegistry = fromRegistries(
				MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
		MongoClientSettings clientSettings = MongoClientSettings.builder()
				.applyConnectionString(connString)
				.codecRegistry(codecRegistry)
				.build();
		try (MongoClient mongoClient = MongoClients.create(clientSettings)) {
			MongoDatabase mdb = mongoClient.getDatabase("midb");
			MongoCollection<Libro> mcol = mdb.getCollection("books", Libro.class);
			//Insertar Libro(int id, String titulo, List<String> autores, String editorial, double precio)
			List<String> autores = Arrays.asList("aa", "bb");
			Libro l1 = new Libro(1, "Libro1", autores, "aaa", 50);
			mcol.insertOne(l1);
		}
	}
}
