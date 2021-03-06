<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

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
			<h1 class="mt-4">Detalii User</h1>
				<ol class="breadcrumb mb-4">
					  <li class="breadcrumb-item"><a href="index.html">Dashboard</a></li>
                      <li class="breadcrumb-item active">Static Navigation</li>
                </ol>
		<div class="card mb-4">
		<div class="card-body">


Id:<c:out value = "${model.meniu.id}"/><br/>
Pret:<c:out value = "${model.meniu.pret}"/><br/>
Descriere:<c:out value = "${model.meniu.descriere}"/><br/>
Alergeni:<c:out value = "${model.meniu.alergeni}"/><br/>
<a href =" <c:url value="/meniu.htm"/>">Inapoi la lista</a>

</div>
</div>                        
 </div>
</div>                 
 </main>
<%@ include file="/WEB-INF/common/footer.jsp" %>
 
     </div>
	<%@ include file="/WEB-INF/common/footer-imports.jsp" %>

</body>
</html>