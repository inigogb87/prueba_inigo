package com.ipartek.formacion.inigo.controlador;

import java.io.IOException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.ArrayList;


import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.inigo.constante.Constantes;
import com.ipartek.formacion.inigo.pojo.Libro;



/**
 * Servlet implementation class LibroServlet
 */
public class LibroServlet extends MasterServlet {
	private static final long serialVersionUID = 1L;

	private static int operacion;
	private static String pId; // Parámetro identificador del libro, aunque sea
								// un id, es un string, luego se parsea

	/**
	 * @see LibroServlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		super.service(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			// recoger parámetros a realizar
			if (request.getParameter("op") != null)
				operacion = Integer.parseInt(request.getParameter("op"));
			else
				operacion = Constantes.OP_LISTAR;

			// Realizar accion
			switch (operacion) {
			case Constantes.OP_LISTAR:
				listar(request);
				break;
			case Constantes.OP_DETALLE:
				detalle(request);
				break;
			case Constantes.OP_NUEVO:
				nuevo(request);
				break;
			case Constantes.OP_ELIMINAR:
				eliminar(request);
				break;
			case Constantes.OP_MODIFICAR:
				modificarCrear(request);
				break;
			}
			request.setAttribute("msj", msj);
			/*
			 * forward para servir la jsp (lanzarlo). en forward hay que poner
			 * dos argumentos. doGet tiene dos request y response, al ser una
			 * petición interna, hay que poner los mismos
			 */
			dispatch.forward(request, response);
		} catch (Exception e) {
			// TODO mejor en un LOG
			e.printStackTrace();

			// TODO ir a página error 404.jsp o 500.jsp
		}

	}

	/**
	 * modifica o crea un libro
	 * 
	 * @param request
	 * @throws ParseException
	 * @throws SQLException
	 */

	private void modificarCrear(HttpServletRequest request)
			throws ParseException, SQLException {
		// recoger parámetros formulario
		int pId = Integer.parseInt(request.getParameter("id")), 
			pPaginas = Integer.parseInt(request.getParameter("paginas"));

		String pNombre = request.getParameter("nombre"), 
				pEditorial = request.getParameter("Editorial"),
				pAutor = request.getParameter("Autor"), 
				pArgumento = request.getParameter("argumento");

		// construir un libro
		Libro libro = new Libro();
		libro.setId(pId);
		libro.setNombre(pNombre);
		libro.setEditorial(pEditorial);
		libro.setAutor(pAutor);
		libro.setArgumento(pArgumento);
		libro.setPaginas(pPaginas);

		

		// persistir en la bbdd
		if (libro.getId() == -1)
			if (daoLibro.insert(libro) != -1)
				msj = new Mensaje("libro insertado con éxito",
						Mensaje.TIPO_SUCCESS);
			else
				msj = new Mensaje("No se ha insertado el libro",
						Mensaje.TIPO_WARNING);
		else if (daoLibro.update(libro)) {
			msj = new Mensaje(MessageFormat.format(
					messages.getString("msj.registro.modificado"),
					messages.getString("label.libro")), Mensaje.TIPO_SUCCESS);
		} else {
			msj = new Mensaje("No se ha modificado el registro",
					Mensaje.TIPO_WARNING);
		}
		// listar
		listar(request);

	}

	private void eliminar(HttpServletRequest request) throws SQLException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if (daoLibro.delete(id)) {
				msj = new Mensaje("Registro eliminado con éxito",
						Mensaje.TIPO_SUCCESS);
			} else {
				msj = new Mensaje("No se ha eliminado el registro",
						Mensaje.TIPO_DANGER);
			}
		} catch (Exception e) {
			msj = new Mensaje("No se ha eliminado el registro",
					Mensaje.TIPO_DANGER);
		}
		listar(request);

	}

	/**
	 * Nos lleva a la vista del formulario para crear un libro
	 * 
	 * @param request
	 * @throws SQLException
	 */
	private void nuevo(HttpServletRequest request) throws SQLException {
		Libro libro = new Libro();
		request.setAttribute("libro", libro);
		ArrayList<Libro> libros = (ArrayList<Libro>) daoLibro.getAll();
		dispatch = request.getRequestDispatcher(Constantes.VIEW_LIBRO_FORM);

	}

	private void detalle(HttpServletRequest request)
			throws NumberFormatException, SQLException {
		pId = request.getParameter("id");
		Libro libro = daoLibro.getById(Integer.parseInt(pId));
		request.setAttribute("libro", libro);
		ArrayList<Libro> libros = (ArrayList<Libro>) daoLibro.getAll();
		request.setAttribute("libros", libros);
		dispatch = request.getRequestDispatcher(Constantes.VIEW_LIBRO_FORM);

	}

	private void listar(HttpServletRequest request) throws SQLException {
		// Llamar modelo para obtener listado

		ArrayList<Libro> listaLibros = (ArrayList<Libro>) daoLibro.getAll();

		// Guardar listado como atributo en request
		request.setAttribute("listaLibros", listaLibros);

		// Petición interna a la jsp (RequestDistapecher es para decirle a donde
		// tiene que ir, se carga el dispatcher)
		dispatch = request.getRequestDispatcher(Constantes.VIEW_LIBRO_LIST);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
