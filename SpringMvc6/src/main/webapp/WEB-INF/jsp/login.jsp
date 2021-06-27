<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html lang="en">

<body>
	<div id="message">${message}</div>
	<form id="form" action="/login" method="post">
    	<div><input type="text" id="username" name="username"/></div>
    	<div><input type="password" id="password" name="password"/></div>
    	<div><input type="submit" id="submit" value="Login" /> </div>
    </form>
</body>
</html>