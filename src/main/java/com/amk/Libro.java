package com.amk;

import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

public class Libro {
	@MongoId(FieldType.INT32)
	private int id;
	private String titulo;
	private List<String> autores;
	private String editorial;
	private double precio;

	public Libro() {
	}

	public Libro(int id, String titulo, List<String> autores, String editorial, double precio) {
		this.id = id;
		this.titulo = titulo;
		this.autores = autores;
		this.editorial = editorial;
		this.precio = precio;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public List<String> getAutores() {
		return autores;
	}

	public void setAutores(List<String> autores) {
		this.autores = autores;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Libro{" +
				"id=" + id +
				", titulo='" + titulo + '\'' +
				", autores=" + autores +
				", editorial='" + editorial + '\'' +
				", precio=" + precio +
				'}';
	}
}
