<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editare comanda</title>

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
				<h1 class="mt-4">Editare Comanda</h1>
				<ol class="breadcrumb mb-4">
					<li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
					<li class="breadcrumb-item active">Static Navigation</li>
				</ol>
				<div class="card mb-4">
					<div class="card-body">

						<h2>
							<c:out value="${model.mesaj}" />
						</h2>
						<form:form
							action="${pageContext.request.contextPath}/comanda-save.htm"
							method="post" commandName="comandaForm">
							<div class="form-group">
								<label class="small mb-1" for="nume">ID</label>
								<form:input class="form-control py-4" path="id" readonly="true"
									type="text" id="nume" />
							</div>
							<div class="form-group">
								<label class="small mb-1" for="nume">User ID</label>
								<form:input class="form-control py-4" path="userId" type="text"
									id="nume" />
							</div>
							<div class="form-group">
								<label class="small mb-1" for="nume">Meniu ID</label>
								<form:input class="form-control py-4" path="meniuId" type="nume"
									id="nume" />
							</div>
							<div class="form-group">
								<label class="small mb-1" for="telefon">Data Comanda</label>
								<form:input class="form-control py-4" path="dataComanda"
									type="text" id="telefon" />
							</div>
							<input class="btn btn-primary" type="submit" value="Salveaza" />
							</br/>
						</form:form>
					</div>
					<div class="card-footer text-center">
						<div class="small">
							<a href="<c:url value="/comanda.htm"/>">&lt; Back to list</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		</main>
		<%@ include file="/WEB-INF/common/footer.jsp"%>

	</div>
	<%@ include file="/WEB-INF/common/footer-imports.jsp"%>

</body>
</html>