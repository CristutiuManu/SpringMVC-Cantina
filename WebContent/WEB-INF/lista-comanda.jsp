<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Comenzi</title>

<link href="<c:url value="/sb-admin/css/styles.css"/>" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js"
	crossorigin="anonymous"></script>

</head>
<body>

	<%@ include file="/WEB-INF/common/headers.jsp"%>
	<div id="layoutSidenav">
		<%@ include file="/WEB-INF/common/sidebar.jsp"%>
		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid">
					<h1 class="mt-4">Lista Comenzi</h1>
					<ol class="breadcrumb mb-4">
						<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
						<li class="breadcrumb-item active">Static Navigation</li>
					</ol>
					<div class="card mb-4">
						<div class="card-body">
							<table class="table table-bordered">
								<tr>
									<td>Id</td>
									<td>userId</td>
									<td>meniuId</td>
									<td>Data Comanda</td>
									<td></td>
								</tr>
								<c:forEach var="comanda" items="${model.comenzi}">
									<tr>
										<td><c:out value="${comanda.id}" /></td>
										<td><c:out value="${comanda.userId}" /></td>
										<td><c:out value="${comanda.meniuId}" /></td>
										<td><c:out value="${comanda.dataComanda}" /></td>
										<td><a
											href="<c:url value="/comanda-detalii.htm?id=${comanda.id}"/>">Detalii</a>
										</td>
										<td><a
											href="<c:url value="/comanda-edit.htm?id=${comanda.id}"/>">Edit</a></td>
										<td><a
											href="<c:url value="/comanda-delete.htm?id=${comanda.id}"/>">Delete</a>
									</tr>
								</c:forEach>
							</table>
							<br /> <a href="<c:url value="/comanda-add.htm"/>">Adauga
								comanda</a>
						</div>
</body>
</html>