package com.amk;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.*;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
public class ShowBook {
	private static Scanner sc=new Scanner(System.in);
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
			//Obtener libro de una editorial
			System.out.print("¿Mostrar libros de qué editorial? ");
			String editorial=sc.nextLine();
			FindIterable<Libro> libros=mcol.find(eq("editorial",editorial));
			libros.forEach(System.out::println);
		}
	}
}