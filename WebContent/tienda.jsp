<%@ page language="java" import="java.util.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Mi Tienda!</title>
</head>


<body>
	<%
		//Comprobamos si existe el objeto "carrito" en sesi�n.
		//Si no existe, lo creamos vac�o. Ser� de tipo HashMap
		@SuppressWarnings("unchecked")
		HashMap<String, Integer> carrito = (HashMap<String, Integer>) request.getSession().getAttribute("carrito");
		if (carrito == null) {
			carrito = new HashMap<String, Integer>();
		}

		//A�adimos el producto recibido al carrito de la compra (en caso de que no sea nulo!) 
		String producto = request.getParameter("producto");
		if (producto != null) {
			Integer cantidad = (Integer) carrito.get(producto);
			if (cantidad == null)
				cantidad = new Integer(1);
			else
				cantidad = new Integer(cantidad.intValue() + 1);
			//Y a�adimos el producto al carrito
			carrito.put(producto, cantidad);

			//A�adimos el carrito a la sesi�n 
			request.getSession().setAttribute("carrito", carrito);

		}
	%>
	<h1>Tienda Virtual</h1>
	<br>
	<form action="tienda.jsp" method="post">
		<br>
		<table align="center">
			<tr>
				<td align="center">escoja el art�culo que desea:</td>
			</tr>
			<tr>
				<td><select name="producto" size="1">
						<option value="010">la trampa</option>
						<option value="345">los p�jaros</option>
						<option value="554">matrix reloaded</option>
				</select></td>
			</tr>
			<tr>
				<td align="center"><input type="submit"
					value="a�adir al carrito..."></td>

			</tr>
		</table>
	</form>
	<br>
	<br>
	<center>
		<H2>Carrito de la compra</h2>
	</center>
	<br>
	<center>
		<ul>
			<c:forEach var="entry" items="${carrito}">
				<li><c:out
						value="Del producto ${entry.key}, ${entry.value} unidades" /></li>
			</c:forEach>
		</ul>
	</center>
</body>
<html>