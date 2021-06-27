<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
	<form id="form" action="/addstock" method="post">
		<input type="hidden" id="token" name="token" value="${token}" />
	    <div><input type="text" id="name" name="name"/></div>
	    <div><input type="number" id="sellingPrice" name="sellingPrice"/></div>
	    <div><input type="number" id="buyingPrice" name="buyingPrice"/></div>
	    <div><input type="number" step="0.1" id="weight" name="weight"/></div>
	    <div>
			<select name="stockType" id="stockType">    
		    <c:forEach items="${stocktype}" var="st">
		    	<option value="${st.id}">${st.name}</option>
			</c:forEach>
			</select>
	    </div>
	    <div>
	    	<input type="radio" name="active" value="0" id="tidakaktif">Tidak Aktif<br>
	  		<input type="radio" name="active" value="1" id="aktif">Aktif<br>
	    </div>
	    <div>
	    	<input id="submit" type="submit" value="Tambah" />
	    </div>
    </form>
    <a href="/getallstock" id="kembali">Kembali</a>
</body>
</html>