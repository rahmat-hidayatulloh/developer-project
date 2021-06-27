<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
	<div id="message">${message}</div>
	<table id="data"> 
    <c:forEach items="${stocktypes}" var="stocktype">
	    <tr>      
	        <td>${stocktype.id}</td>
	        <td>${stocktype.name}</td>
	        <td><a href="/getstocktype?id=${stocktype.id}">Edit</a></td>
	    </tr>
	</c:forEach>
	</table>
	<a id="tambah" href="/addstocktype">Tambah</a>
</body>
</html>