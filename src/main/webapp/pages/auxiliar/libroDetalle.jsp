
<%@page import="com.ipartek.formacion.inigo.pojo.Libro"%>
<%@page import="java.util.ArrayList"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.GregorianCalendar"%>

	

<%@page import="java.util.Calendar"%>
<%@include file="../../includes/head.jsp"%>

<div id="page-wrapper">
	<div class="row">
		<div class="col-lg-12">
			<%
				//recoger "atributo persona de la request
				Libro per = (Libro) request.getAttribute("libro");
				boolean isNew = (per.getId() == -1);
			%>
			<h1 class="page-header"><%=per.getNombre()%></h1>
		</div>

		<!-- Formularios -->
		<form method="post" action="back/usuarios">

			<div class="form-group">
				<label for="id" class="col-sm-2 control-label"
					style="margin: 10px 0;">ID</label>
				<div class="col-sm-10">
					<label for="id" class="col-sm-2 control-label"
						style="margin: 10px 0;"><%=per.getId()%></label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="nombre" class="col-sm-2 control-label"
					style="margin: 10px 0;">Nombre</label>
				<div class="col-sm-10">
					<input type="text" name="nombre" placeholder="Escribe tu nombre"
						value="<%=per.getNombre()%>" required
						style="margin: 10px 0;"
						size="60" autofocus>
				</div>
			</div>

			<div class="form-group">
				<label for="editorial" class="col-sm-2 control-label"
					style="margin: 10px 0;">Editorial</label>
				<div class="col-sm-10">
					<input type="text" name="editorial" placeholder="Escribe la editorial"
						value="<%=per.getEditorial()%>" size="60" required style="margin: 10px 0;">
				</div>
			</div>

			<div class="form-group">
				<label for="autor" class="col-sm-2 control-label"
					style="margin: 10px 0;">Autor</label>
				<div class="col-sm-10">
					<input type="text" name="autor" placeholder="Escribe el autor"
						value="<%=per.getAutor()%>" size="60" required style="margin: 10px 0;">
				</div>
			</div>

			<div class="form-group">
				<label for="argumento" class="col-sm-2 control-label"
					style="margin: 80px 0;">Argumento</label>
				<div class="col-sm-10">
					<textarea class="form-control" rows="3" name="argumento"
						placeholder="Escribe algo" style="margin: 10px 0;"><%=per.getArgumento()%></textarea>
				</div>
			</div>

			<div class="form-group">
				<label for="paginas" class="col-sm-2 control-label"
					style="margin: 10px 0;">Paginas</label>
				<div class="col-sm-10">
					<input type="text" name="paginas" placeholder="Escribe paginas"
						value="<%=per.getPaginas()%>" size="60" required style="margin: 10px 0;">
				</div>
			</div>

			
			
						
			<input type="hidden" name="id" value="<%=per.getId()%>"> <input
				type="hidden" name="nombre" value="<%=per.getNombre()%>"> <input
				type="hidden" name="editorial" value="<%=per.getEditorial()%>"> <input
				type="hidden" name="autor" value="<%=per.getAutor()%>"> <input
				type="hidden" name="argumento" value="<%=per.getArgumento()%>"><input
				type="hidden" name="paginas" value="<%=per.getPaginas()%>">  <input
				type="hidden" name="op"
				value="<%=Constantes.OP_MODIFICAR%>">
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<%
						if (isNew) {
					%>
					<button type="submit" class="btn btn-primary"
						style="margin: 10px 0;">Crear</button>
					<%
						} else {
					%>
					<button type="submit" class="btn btn-primary"
						style="margin: 10px 0;">Modificar</button>
					<button type="button" class="btn btn-danger" data-toggle="modal"
						data-target="#eliminar">Eliminar</button>
					<%
						}
					%>
				</div>
			</div>
		</form>
		<!-- Pop Up de eliminación-->
		<div class="modal fade" id="eliminar" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">
							<span aria-hidden="true">×</span><span class="sr-only">Cerrar</span>
						</button>
						<h4 class="modal-title" id="myModalLabel">Eliminación de
							usuario</h4>
					</div>
					<div id="nuevaAventura" class="modal-body">
						<form method="post" action="back/usuarios">
							<div class="form-group">
								<input type="hidden" name="op"
									value="<%=Constantes.OP_ELIMINAR%>"> <input
									type="hidden" name="id" value="<%=per.getId()%>"> <label
									for="aviso">¿Está seguro que desea eliminar al usuario?
									Esta acción no se puede deshacer.</label>
								<button type="submit" class="btn btn-danger" id="eliminacion"
									style="margin: 10px 0;">Eliminar</button>
								<button type="button" class="btn btn-success"
									data-dismiss="modal" style="margin: 10px 0;">Cerrar</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
		<!-- fin Pop Up de eliminación-->
	</div>
	<!-- END <div class="row"> -->
</div>
<!-- END <div id="page-wrapper"> -->

<%@include file="../../includes/footer.jsp"%>