<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
	integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk"
	crossorigin="anonymous">

<!-- Datatables -->
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.21/css/jquery.dataTables.min.css">

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<a class="navbar-brand" href="#">Gestor Empleados</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="nombre, apellido o NIF" aria-label="Search">
				<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Buscar</button>
			</form>
		</div>
	</nav>


	<main class="container">

		<a href="">TODO Formulario para crear Empleado</a>

		<table class="table" id="example">
			<thead class="thead-dark">
				<tr>
					<th scope="col">#</th>
					<th scope="col">Empleado</th>
					<th scope="col">NIF</th>
					<th scope="col">Departamento</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${empleados}" var="empleado">
					<tr>
						<th scope="row">1</th>
						<td>${empleado.nombre},${empleado.ape1} ${empleado.ape2}</td>
						<td>${empleado.nif}</td>
						<td>
							<button type="button" class="btn btn-link" data-toggle="popover"
								title="${empleado.departamento.nombre}" data-html="true"
								data-placement="left"
								data-content="Gastos: <b>${empleado.departamento.gasto} €</b> <br> Presupuesto: <b>${empleado.departamento.presupuesto}  € </b>">${empleado.departamento.nombre}</button>
						</td>
					</tr>
				</c:forEach>

			</tbody>
		</table>

	</main>











	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
		integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
		crossorigin="anonymous"></script>

	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>

	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
		integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
		crossorigin="anonymous"></script>

	<!-- Datatables -->
	<script
		src="https://cdn.datatables.net/1.10.21/js/jquery.dataTables.min.js"></script>

	<!-- Scrip Propio -->
	<script>
		$(document)
				.ready(
						function() {

							console
									.info('Documento HTML cargado y listo para ejecutar nuestro Script');

							console.debug('Habilitar popover de Bootstrap');
							$('[data-toggle="popover"]').popover();

							console.debug('Habilitar Plugin Datatables');
							$('#example')
									.DataTable(
											{
												"language" : {
													"sProcessing" : "Procesando...",
													"sLengthMenu" : "Mostrar _MENU_ registros",
													"sZeroRecords" : "No se encontraron resultados",
													"sEmptyTable" : "Ningún dato disponible en esta tabla",
													"sInfo" : "Mostrando registros del _START_ al _END_ de un total de _TOTAL_ registros",
													"sInfoEmpty" : "Mostrando registros del 0 al 0 de un total de 0 registros",
													"sInfoFiltered" : "(filtrado de un total de _MAX_ registros)",
													"sInfoPostFix" : "",
													"sSearch" : "Filtrar:",
													"sUrl" : "",
													"sInfoThousands" : ",",
													"sLoadingRecords" : "Cargando...",
													"oPaginate" : {
														"sFirst" : "Primero",
														"sLast" : "Último",
														"sNext" : "Siguiente",
														"sPrevious" : "Anterior"
													},
													"oAria" : {
														"sSortAscending" : ": Activar para ordenar la columna de manera ascendente",
														"sSortDescending" : ": Activar para ordenar la columna de manera descendente"
													},
													"buttons" : {
														"copy" : "Copiar",
														"colvis" : "Visibilidad"
													}
												}
											});
						});
	</script>

</body>
</html>