package com.ipartek.formacion.inigo.constante;

public class Constantes {

	// Generales
	public static final String APP_NAME = "Inigo_v1.0.0";
	public static final String SERVER = "http://localhost:8080/";
	public static final String ROOT = SERVER + APP_NAME + "/";
	
	
	// OPERACIONES CONTROLADORES
	public static final int OP_NUEVO = 0;
	public static final int OP_DETALLE = 1;
	public static final int OP_LISTAR = 2;
	public static final int OP_MODIFICAR = 3;
	public static final int OP_ELIMINAR = 4;

	// CONTROLADORES
	
	public static final String CONTROLLER_LIBROS = 	"back/libros";
	public static final String CONTROLLER_SEARCH = "back/search";

	// VISTAS
	
	public static final String VIEW_INDEX = "index.jsp";

	public static final String VIEW_LIBRO_LIST = "/pages/auxiliar/libros.jsp";
	public static final String VIEW_LIBRO_FORM = "/pages/auxiliar/libroDetalle.jsp";


}
