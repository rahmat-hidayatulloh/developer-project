<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<body>
	<form action="/addstock" method="post">
		<input type="hidden" id="token" name="token" value="${token}">
		<div>
			<input type="text" id="name" name="name" />
		</div>
		<div>
			<input type="number" id="sellingPrice" name="sellingPrice" />
		</div>
		<div>
			<input type="number" id="buyingPrice" name="buyingPrice" />
		</div>
		<div>
			<input type="number" step="0.1" id="weight" name="weight" />
		</div>
		<div>
			<select id="stockType" name="stockType">
				<c:forEach items="${stocktype}" var="st">
					<option value="${st.id}">${st.name}</option>
				</c:forEach>
			</select>
		</div>
		<div>
			<input type="radio" id="active" name="active" value="false" />Tidak
			Aktif
		</div>
		<div>
			<input type="radio" id="active" name="active" value="true" />Aktif
		</div>
		<div>
			<input type="submit" value="Tambah" />
		</div>
	</form>
	<div>
		<a href="/getallstock">Kembali</a>
	</div>

</body>
</html>