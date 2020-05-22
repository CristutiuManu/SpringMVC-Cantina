<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Lista Meniu</title>

<link href="<c:url value="/sb-admin/css/styles.css"/>"  rel="stylesheet">
<script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/js/all.min.js" crossorigin="anonymous"></script>

</head>
<body>

<%@ include file="/WEB-INF/common/headers.jsp"%>
<div id ="layoutSidenav">
<%@ include file="/WEB-INF/common/sidebar.jsp" %>
<div id="layoutSidenav_content">
                <main>
                    <div class="container-fluid">
                        <h1 class="mt-4">Lista Meniuri</h1>
                        <ol class="breadcrumb mb-4">
                            <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                            <li class="breadcrumb-item active">Static Navigation</li>
                        </ol>
                        <div class="card mb-4">
                            <div class="card-body">
<table class = "table table-bordered">
	<tr>
		<td>Id</td>
		<td>Pret</td>
		<td>Descriere</td>
		<td>Alergeni</td>
		<td></td>
	</tr>
	<c:forEach var = "meniu" items="${model.meniuri}">
		<tr> 
	 		<td><c:out value = "${meniu.id}"/></td>
			<td><c:out value = "${meniu.pret}"/> </td>
			<td><c:out value = "${meniu.descriere}"/> </td>
			<td><c:out value = "${meniu.alergeni}"/> </td>
			<td><a href="<c:url value="/meniu-detalii.htm?id=${meniu.id}"/>">Detalii</a> </td>
			<td><a href="<c:url value="/meniu-edit.htm?id=${meniu.id}"/>">Edit</a>		
			<td><a href="<c:url value="/meniu-delete.htm?id=${meniu.id}"/>">Delete</a>
				 
			
		</tr>
	</c:forEach>
</table>
<br/>
	<a href="<c:url value="/meniu-add.htm"/>">Adauga meniu</a>
	</div>
	</div>
    </div>                        
	</main>
                
		<%@ include file="/WEB-INF/common/footer.jsp" %>
		
			</div>
            </div>
            
	<%@ include file="/WEB-INF/common/footer-imports.jsp" %>
	
</body>
</html>