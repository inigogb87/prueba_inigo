
<%@page import="com.ipartek.formacion.inigo.constante.Constantes"%>
<%@page import="com.ipartek.formacion.inigo.pojo.Libro"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.ArrayList"%>

<%@page import="java.util.Calendar"%>

<!-- /.panel-heading -->
<div class="panel-body">
	<div class="row">
		<div class="col-lg-12">
			<div class="table-responsive">
				<table
					class="datatable table table-bordered table-hover table-striped">
					<thead>
						<tr>
							<th>#</th>
							<th>Nombre</th>
							<th>Editorial</th>
							<th>Autor</th>
							<th>Pais</th>							
							<th>Paginas</th>
							
						</tr>
					</thead>
					<tbody>
						<%
							//recoger "atributo listado personas de la request
							ArrayList<Libro> lista = (ArrayList<Libro>) request.getAttribute("listaLibros");
							if (lista == null)
								lista = new ArrayList<Libro>();

							for (int i = 1; i <= lista.size(); i++) {
								Libro per = lista.get(i - 1);
						%>
						<tr>
							<td><%=i%></td>
							<td><a
								href="<%=Constantes.CONTROLLER_LIBROS%>?op=<%=Constantes.OP_DETALLE%>&id=<%=per.getId()%>"
								title="Ir al detalle de <%=per.getNombre()%>"><%=per.getNombre()%></a></td>
							<td><%=per.getEditorial()%></td>
							<td><%=per.getAutor()%></td>
							<td><%=per.getPais()%></td>
							<td><%=per.getPaginas()%></td>
						</tr>
						<%
							} //end for
						%>
					</tbody>
				</table>
			</div>
			<!-- /.table-responsive -->
		</div>
		<!-- /.col-lg-4 (nested) -->
		<div class="col-lg-8">
			<div id="morris-bar-chart"></div>
		</div>
		<!-- /.col-lg-8 (nested) -->
	</div>
	<!-- /.row -->
</div>
<!-- /.panel-body -->