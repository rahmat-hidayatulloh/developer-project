<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
	<div id="message">${message}</div>
	<form id="form" action="/updatestock?id=${stock.id}" method="post">
		<input type="hidden" id="token" name="token" value="${token}" />
		<div id="id">${stock.id}</div>
	    <div><input type="text" id="name" name="name" value="${stock.name}" /></div>
	    <div><input type="number" id="sellingPrice" name="sellingPrice" value="${stock.sellingPrice}" /></div>
	    <div><input type="number" id="buyingPrice" name="buyingPrice" value="${stock.buyingPrice}" /></div>
	    <div><input type="number" step="0.1" id="weight" name="weight" value="${stock.weight}" /></div>
	    <div>
			<select name="stockType" id="stockType">    
		    <c:forEach items="${stocktype}" var="st">
		    	<option value="${st.id}" <c:if test = "${st.id == stock.stockType.id}">selected</c:if>>${st.name}</option>
			</c:forEach>
			</select>
	    </div>
	    <div>
	    	<input type="radio" name="active" value="0" id="tidakaktif" <c:if test = "${stock.active == false}">checked</c:if>>Tidak Aktif<br>
	  		<input type="radio" name="active" value="1" id="aktif" <c:if test = "${stock.active == true}">checked</c:if>>Aktif<br>
	    </div>
	    <div>
	    	<input id="submit" type="submit" value="Simpan" />
	    </div>
    </form>
    <a href="/getallstock" id="kembali">Kembali</a>
</body>
</html>