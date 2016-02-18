package com.ipartek.formacion.inigo.pojo;

/**
 * 
 * Clase instanciable de tipo POJO para representar a un <code>Libro</code>
 * 
 * @author Curso
 *
 */

public class Libro {

	/********* ATRIBUTOS **************/

	private int id;
	private String nombre;
	private String editorial;
	private String autor;
	private String pais;
	private int paginas;

	/********* CONSTRUCTORES **********/

	public Libro() {
		this.id = -1;
		this.nombre = "";
		this.editorial = "";
		this.autor = "";
		this.pais = "";
		this.paginas = 0;
	}

	public Libro(int id, String nombre, String editorial, String autor, String pais, int paginas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.autor = autor;
		this.pais = pais;
		this.paginas = paginas;
	}
	
	
	/********* GETTERS Y SETTERS ***********/

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public int getPaginas() {
		return paginas;
	}

	public void setPaginas(int paginas) {
		this.paginas = paginas;
	}
	
	/****** OTRAS FUNCIONES ********/
	
	@Override
	public String toString() {
		return "Libro [id=" + id + ", nombre=" + nombre + ", editorial=" + editorial + ", autor=" + autor + ", pais="
				+ pais + ", paginas=" + paginas + "]";
	}

	
	
}
