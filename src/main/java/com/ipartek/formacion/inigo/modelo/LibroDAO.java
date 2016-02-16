package com.ipartek.formacion.inigo.modelo;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.ipartek.formacion.inigo.pojo.Libro;

public class LibroDAO implements Persistable<Libro> {

	@Override
	public List<Libro> getAll() throws SQLException {

		DbConnection conn = new DbConnection();

		String sentencia = "select " + "`id`, " + "`nombre`, " + "`editorial`, " + "`autor`, " + "`pais`, "
				+ "`paginas`" + "from `libro`;";
		PreparedStatement consulta = conn.getConnection().prepareStatement(sentencia);
		ResultSet res = consulta.executeQuery();
		ArrayList<Libro> libros = new ArrayList<Libro>();

		while (res.next()) {
			libros.add(mapeo(res));
		}
		res.close();
		consulta.close();
		conn.desconectar();

		return libros;

	}

	@Override
	public Libro getById(int id) throws SQLException {
		// Se abre conexión
		DbConnection conn = new DbConnection();
		// nombre de la clase y ctrl + espacio
		String sql = "select  `id`,`nombre`, `editorial`, `autor`," + " `pais`, " + " paginas" + " from libro "
				+ " where `id` = ?;";

		PreparedStatement consulta = conn.getConnection().prepareStatement(sql);
		consulta.setInt(1, id);
		// ejecutar la consulta
		ResultSet res = consulta.executeQuery();

		// iterar sobre los resultados
		res.next();
		Libro c = mapeo(res);

		res.close();
		consulta.close();
		conn.desconectar();
		return c;
	}

	@Override
	public boolean delete(int id) throws SQLException {
		DbConnection conn = new DbConnection();
		boolean resul = false;
		String sql = "delete from `libro` where `id` = ?;";
		PreparedStatement pst = conn.getConnection().prepareStatement(sql);
		pst.setInt(1, id);
		if (pst.executeUpdate() == 1)// Si solo afecta a una línea
			resul = true;
		return resul;

	}

	@Override
	public boolean update(Libro persistable) throws SQLException {
		boolean resul = false;
		if (persistable != null) {
			DbConnection conn = new DbConnection();
			String sql = "update `libro` set nombre = ?, editorial = ?, autor = ?, pais = ?, paginas = ? where `id` = ? ;";
			PreparedStatement pst = conn.getConnection().prepareStatement(sql);
			pst.setString(1, persistable.getNombre());
			pst.setString(2, persistable.getEditorial());
			pst.setString(3, persistable.getAutor());
			pst.setString(5, persistable.getPais());
			pst.setInt(6, persistable.getPaginas());

			if (pst.executeUpdate() == 1)// Si solo afecta a una línea
				resul = true;
		}
		return resul;

	}

	@Override
	public int insert(Libro persistable) throws SQLException {
		int i;
		// Se abre conexión
		DbConnection conn = new DbConnection();
		try {
			String sql = "INSERT INTO `libro` (`nombre`, `editorial`, `autor`, `pais`, `paginas`) VALUES (?,?,?,?,?);";
			PreparedStatement pst = conn.getConnection().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			pst.setString(1, persistable.getNombre());
			pst.setString(2, persistable.getEditorial());
			pst.setString(3, persistable.getAutor());
			pst.setString(4, persistable.getPais());
			pst.setInt(5, persistable.getPaginas());
			// ejecutar la consulta. Si no afecta a una línea, lanzamos la
			// excepción
			if (pst.executeUpdate() != 1)
				throw new SQLException("No se ha insertado el dato");

			ResultSet generatedKeys = pst.getGeneratedKeys();
			generatedKeys.next();
			i = generatedKeys.getInt(1);
			persistable.setId(i);
			pst.close();

		} catch (Exception e) {
			i = -1;
			e.printStackTrace();
		}
		conn.desconectar();
		return i;
	}

	private Libro mapeo(ResultSet res) throws SQLException {

		Libro l = new Libro();
		l.setId(res.getInt("id"));
		l.setNombre(res.getString("nombre"));
		l.setEditorial(res.getString("editorial"));
		l.setAutor(res.getString("autor"));
		l.setPais(res.getString("pais"));
		l.setPaginas(res.getInt("paginas"));

		return l;
	}

}
