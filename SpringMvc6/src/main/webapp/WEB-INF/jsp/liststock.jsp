<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
	<div id="message">${message}</div>
	<div><form id="search" action="/findstock" method="get"><input type="text" id="name" name="name" value="${search}"/><input id="submit" type="submit" value="Cari" /></form></div>
	<table id="data">    
    <c:forEach items="${stocks}" var="stock">
	    <tr>      
	        <td>${stock.id}</td>
	        <td>${stock.name}</td>
	        <td>${stock.sellingPrice}</td>
	        <td>${stock.buyingPrice}</td>
	        <td>${stock.weight}</td>  
	        <td>${stock.stockType.id}</td>  
	        <td>${stock.stockType.name}</td>  
	        <td>${stock.active}</td>
	        <td><a href="/getstock?id=${stock.id}">Edit</a></td>
	        <td>
	        	<form action="/deletestock" method="post">
	        		<input type="hidden" name="token" id="token${stock.id}" value="${token}"> 
	        		<input type="hidden" name="id" id="id" value="${stock.id}">  
	        		<input type="submit" id="submit${stock.id}" value="Hapus" />
	        	</form>
	        </td>  
	    </tr>
	</c:forEach>
	</table>
	<a id="tambah" href="/addstock">Tambah</a>
</body>
</html>