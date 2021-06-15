<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<body>
	<div>${message}</div>
	<div>${stock.id}</div>
	<form action="/updatestock" method="post">
		<div>
			<input type="hidden" id="token" name="token" value="${token}" /> <input
				type="hidden" id="id" name="id" value="${stock.id}" />
		</div>
		<div>
			<input type="text" id="name" name="name" value="${stock.name}" />
		</div>
		<div>
			<input type="number" id="sellingPrice" name="sellingPrice"
				value="${stock.sellingPrice}" />
		</div>
		<div>
			<input type="number" id="buyingPrice" name="buyingPrice"
				value="${stock.buyingPrice}" />
		</div>
		<div>
			<input type="number" step="0.1" id="weight" name="weight"
				value="${stock.weight}" />
		</div>
		<div>
			<select id="stockType" name="stockType">
				<c:forEach items="${stocktype}" var="st">
					<option value="${st.id}"
						<c:if test="${st.id == stock.stockType.id}">selected=true</c:if>>${st.name}</option>

				</c:forEach>
			</select>
		</div>
		<div>
			<input type="radio" id="active1" name="active" value="false"
				<c:if test="${stock.active == false}">checked="checked"</c:if> />Tidak
			Aktif

		</div>
		<div>
			<input type="radio" id="active2" name="active" value="true"
				<c:if test="${stock.active == true}">checked="checked"</c:if> />Aktif
		</div>
		<div>
			<input type="submit" value="Simpan" />
		</div>
	</form>
	<div>
		<a href="/getallstock">Kembali</a>
	</div>

</body>
</html>