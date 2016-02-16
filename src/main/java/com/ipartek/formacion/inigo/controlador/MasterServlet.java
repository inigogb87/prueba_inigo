package com.ipartek.formacion.inigo.controlador;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.ipartek.formacion.inigo.modelo.LibroDAO;

/**
 * Servlet implementation class MasterServlet
 */
public class MasterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//DAOs
	protected static LibroDAO daoLibro;
	
	
		
	protected RequestDispatcher dispatch; // El que se encarga de enrutar. Solo puede ir a un sitio, no se puede cargar dos veces	
	protected HttpSession session;
	
	protected ResourceBundle messages; //fichero de properties
	protected static Mensaje msj; //Mensaje a mostrar la usuario
	
	 

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		daoLibro = new LibroDAO();
		
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		daoLibro = null;
		
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");			
		msj = null;
		session = request.getSession();
		messages = null;
		super.service(request, response);
	}

}