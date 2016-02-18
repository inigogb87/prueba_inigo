package com.ipartek.formacion.inigo.modelo;

import static org.junit.Assert.*;
import java.sql.Connection;
import org.junit.Test;

import com.ipartek.formacion.inigo.pojo.Libro;

public class LibreriaDAOTest {

	static DbConnection db;
	static Connection conn;
	static LibroDAO dao;
	static Libro pMock1, pMock2;
	static int id; // identificador de la última operación realizada en el DAO

	@Test
	public static void setUpBeforeClass() throws Exception {

		db = new DbConnection();
		conn = db.getConnection();
		conn.setAutoCommit(false);
		dao = new LibroDAO();
	}

	@Test
	public static void tearDownAfterClass() throws Exception {
		conn.rollback();
		db.desconectar();
		db = null;
		dao = null;
	}

	@Test
	public void constructorVacio() {
		Libro l1 = new Libro();

		//assertEquals("El nombre del libro tiene que estar vacio", "", l1.getNombre());
		//assertEquals("La editorial del libro tiene que estar vacía", "", l1.getEditorial());
		//assertEquals("el autor del libro tiene que estar vacio","",l1.getAutor());
		//assertEquals("el pais del libro tiene que estar vacio","",l1.getPais());
		assertTrue("El numero de paginas debe ser 0", l1.getPaginas() == 0);
		
		
	
	}

	
}
