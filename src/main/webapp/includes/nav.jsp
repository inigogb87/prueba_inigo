<!-- /.navbar-top-links -->



<%@page import="com.ipartek.formacion.inigo.constante.Constantes"%>
<div class="navbar-default sidebar" role="navigation">
	<div class="sidebar-nav navbar-collapse">
		<ul class="nav" id="side-menu">
			<li class="sidebar-search">
				<div class="input-group custom-search-form">

					<form method="get" action="<%=Constantes.CONTROLLER_SEARCH%>">

						<input type="text" id="criterio" name="criterio"
							class="form-control" placeholder="Buscar..." autofocus requiered
							min="1"> <span class="input-group-btn">
							<button class="btn btn-default" type="submit">
								<i class="fa fa-search"></i>
							</button>
					</form>

					</span>
				</div> <!-- /input-group -->
			</li>
			<li><a href="<%=Constantes.VIEW_INDEX%>"><i
					class="fa fa-dashboard fa-fw"></i> Página principal</a></li>
			<li>
				<!-- vamos a llamar al controlador en lugar del jsp --> <a
				href="<%=Constantes.CONTROLLER_LIBROS%>"><i
					class="fa fa-user fa-fw"></i>Libros</a>
			</li>
			
		</ul>
	</div>
	<!-- /.sidebar-collapse -->
</div>
<!-- /.navbar-static-side -->
</nav>
<!-- End:Navigation -->