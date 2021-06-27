<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
    <div id="message">${message}</div>
    <div><a href="/getallstocktype">Pengaturan Tipe Stok</a></div>
    <div><a href="/getallstock">Pengaturan Stok</a></div>
    <div><a href="/logout?token=${token}">Keluar</a></div>
    <input type="hidden" id="token" name="token" value="${token}" />
</body>
</html>