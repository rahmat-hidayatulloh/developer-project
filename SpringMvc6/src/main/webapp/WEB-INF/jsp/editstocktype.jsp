<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<body>
	<div>${message}</div>
	<div>${stocktype.id}</div>
	<form action="/updatestocktype" method="post">
		<input type="hidden" id="token" name="token" value="${token}" /> <input
			type="hidden" id="id" name="id" value="${stocktype.id}" />
		<div>
			<input type="text" id="name" name="name" value="${stocktype.name}" />
		</div>
		<div>
			<input type="submit" value="Simpan" />
		</div>
	</form>
	<div>
		<a href="/getallstocktype">Kembali</a>
	</div>
</body>
</html>