<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
	<div id="message">${message}</div>
	<form id="form" action="/updatestocktype?id=${stocktype.id}" method="post">
		<input type="hidden" id="token" name="token" value="${token}" />
		<div id="id">${stocktype.id}</div>
	    <div><input type="text" id="name" name="name" value="${stocktype.name}" /></div>
	    <div>
	    	<input id="submit" type="submit" value="Simpan" />
	    </div>
    </form>
    <a href="/getallstocktype" id="kembali">Kembali</a>
</body>
</html>