<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
	<form id="form" action="/addstocktype" method="post">
		<input type="hidden" id="token" name="token" value="${token}" />
	    <div><input type="text" id="name" name="name"/></div>
	    <div>
	    	<input id="submit" type="submit" value="Tambah" />
	    </div>
    </form>
    <a href="/getallstocktype" id="kembali">Kembali</a>
</body>
</html>