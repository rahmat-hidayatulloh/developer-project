<!DOCTYPE html>
<html lang="en">
<body>
	<form action="/addstocktype" method="post">
		<div>
			<input type="hidden" id="token" name="token" value="${token}" />
		</div>
		<div>
			<input type="text" id="name" name="name" />
		</div>
		<div>
			<input type="submit" value="Tambah" />
		</div>
	</form>
</body>
</html>